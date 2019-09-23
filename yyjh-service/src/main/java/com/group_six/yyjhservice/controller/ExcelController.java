package com.group_six.yyjhservice.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group_six.tools.ExcelOper;
import com.group_six.tools.YYJHTools;
import com.group_six.yyjhservice.domain.datasource.TDatasource;
import com.group_six.yyjhservice.enumeration.DatasourceEnum;
import com.group_six.yyjhservice.service.datasource.TDatasourceService;
import com.group_six.yyjhservice.vo.ControllerResult;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("excel")
public class ExcelController {
    @Autowired
    TDatasourceService tDatasourceService;
    @Value("${file.upload.path.datasource.excel}")
    private String excel_path;

    //上传
    @RequestMapping("excelUpload")
    public Object excelUpload(@RequestParam("excel_upload") MultipartFile[] files,
                              @RequestParam("excel_interpret") String excel_interpret) throws IOException {
        ControllerResult controllerResult = new ControllerResult();
        controllerResult.setCode(DatasourceEnum.NOFILE.getCode());
        controllerResult.setMsg(DatasourceEnum.NOFILE.getMsg());
        if (null != files && files.length != 0){
            //创建目录
            File directory = new File(excel_path);
            if (!directory.exists()) directory.mkdirs();
            //遍历
            for(MultipartFile file:files) {
                //拿文件名称
                String original=file.getOriginalFilename();
                String suffix=original.substring(original.lastIndexOf("."));
                if(!".xlsx".equals(suffix.trim()) && !".xls".equals(suffix.trim()))
                    continue;
                //生成UUID
                String uuid= YYJHTools.getUID();
                String real_path=excel_path+File.separator+uuid+suffix;
                File excel=new File(real_path);
                //存库，存文件
                FileUtils.copyInputStreamToFile(file.getInputStream(),excel);
                TDatasource excel_data=new TDatasource();
                excel_data.setDatabaseName(uuid);
                excel_data.setType("excel");
                excel_data.setUrl(real_path);
                excel_data.setAlias(original);

                ObjectMapper om = new ObjectMapper();
                List<Map<String,Object>> excel_interprets
                        =om.readValue(excel_interpret, new TypeReference< List<Map<String,Object>>>(){});
                for(Map<String,Object> excel_in : excel_interprets){
                    if(original.equals(excel_in.get("filename").toString())){
                        String encode = om.writeValueAsString(excel_in);
                        excel_data.setEncode(encode);
                        break;
                    }
                }

                boolean flag=tDatasourceService.addTDatasource(excel_data);
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

    //预览
    @RequestMapping("/previewExcel")
    public Object previewExcel(@RequestParam("excel_upload") MultipartFile[] files,
                               @RequestParam("excel_interpret") String excel_interpret) throws IOException, InvalidFormatException {
        ControllerResult controllerResult = new ControllerResult();
        controllerResult.setCode(DatasourceEnum.NOFILE.getCode());
        controllerResult.setMsg(DatasourceEnum.NOFILE.getMsg());

        if(null !=files && files.length!=0){
            List<Map<String,Object>> datas = ExcelOper.translateExcel(files);
            controllerResult.setCode(DatasourceEnum.SUCCESS.getCode());
            controllerResult.setMsg(DatasourceEnum.SUCCESS.getMsg());
            controllerResult.setPayload(datas);
        }

        return controllerResult;
    }
}
