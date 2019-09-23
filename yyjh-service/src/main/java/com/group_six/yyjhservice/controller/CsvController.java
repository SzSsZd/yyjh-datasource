package com.group_six.yyjhservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.group_six.tools.YYJHTools;
import com.group_six.yyjhservice.domain.datasource.TDatasource;
import com.group_six.yyjhservice.enumeration.DatasourceEnum;
import com.group_six.yyjhservice.service.datasource.TDatasourceService;
import com.group_six.yyjhservice.vo.ControllerResult;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/csv")
public class CsvController {

    @Value("${file.upload.path.datasource.csv}")
    private String csv_path;
    @Autowired
    TDatasourceService tDatasourceService;
    //CSV上传
    @RequestMapping("/csvUpload")
    public Object csvUpload(@RequestParam("csv_upload") MultipartFile[] files) throws IOException {
        ControllerResult controllerResult = new ControllerResult();
        controllerResult.setCode(DatasourceEnum.NOFILE.getCode());
        controllerResult.setMsg(DatasourceEnum.NOFILE.getMsg());
        if (null != files && files.length != 0){
            //创建目录
            File directory = new File(csv_path);
            if (!directory.exists()) directory.mkdirs();
            //遍历
            for(MultipartFile file:files) {
                //拿文件名称
                String original=file.getOriginalFilename();
                String suffix=original.substring(original.lastIndexOf("."));
                if(!".csv".equals(suffix.trim()))
                    continue;
                //生成UUID
                String uuid= YYJHTools.getUID();
                String real_path=csv_path+File.separator+uuid+suffix;
                File csv=new File(real_path);
                //存库，存文件
                FileUtils.copyInputStreamToFile(file.getInputStream(),csv);
                TDatasource csv_data=new TDatasource();
                csv_data.setDatabaseName(uuid);
                csv_data.setType("csv");
                csv_data.setUrl(real_path);
                csv_data.setAlias(original);
                boolean flag=tDatasourceService.addTDatasource(csv_data);
                if(flag){
                    controllerResult.setCode(DatasourceEnum.SUCCESS.getCode());
                    controllerResult.setMsg(DatasourceEnum.SUCCESS.getMsg());
                }else{
                    controllerResult.setCode(DatasourceEnum.FAIL.getCode());
                    controllerResult.setMsg(DatasourceEnum.FAIL.getMsg());
                }
            }
        }

        return controllerResult;
    }


    //CSV预览
    @RequestMapping(value = "/previewCSV")
    public Object previewCSV(@RequestParam("csv_upload") MultipartFile[] files,@RequestParam("csv_interpret") String interpret) throws IOException {
        ControllerResult result=new ControllerResult();
        result.setCode(DatasourceEnum.NOFILE.getCode());
        result.setMsg(DatasourceEnum.NOFILE.getMsg());
        if(null !=files && files.length!=0){
            ObjectMapper om=new ObjectMapper();
            ArrayNode datas=om.createArrayNode();
            //循环File
            for(MultipartFile file:files){
                if(file.isEmpty())
                    continue;
                ObjectNode json_file=om.createObjectNode();
                ArrayNode file_datas=om.createArrayNode();
                //流操作
                InputStream in=file.getInputStream();
                Reader r_in=new BufferedReader(new InputStreamReader(in,"utf-8"));
                BufferedReader bufferedReader=new BufferedReader(r_in);
                String line="";
                while ((line=bufferedReader.readLine())!=null){
                    int index=1;
                    String[] cols=line.split(interpret);
                    ObjectNode json_cols=om.createObjectNode();
                    for(String col:cols){
                        json_cols.put("col"+index,col);
                        index++;
                    }
                    file_datas.add(json_cols);
                }
                json_file.put("filename",file.getOriginalFilename());
                json_file.put("filedatas",file_datas);
                datas.add(json_file);
            }
            //返回数据
            result.setCode(DatasourceEnum.SUCCESS.getCode());
            result.setPayload(datas);
            result.setMsg(DatasourceEnum.SUCCESS.getMsg());
        }
        return result;
    }
}
