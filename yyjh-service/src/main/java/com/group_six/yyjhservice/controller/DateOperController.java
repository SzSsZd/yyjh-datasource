package com.group_six.yyjhservice.controller;

import com.group_six.yyjhservice.domain.dateForm.TDateForm;
import com.group_six.yyjhservice.domain.user.TUser;
import com.group_six.yyjhservice.enumeration.DatasourceEnum;
import com.group_six.yyjhservice.service.dateForm.TDateFormService;
import com.group_six.yyjhservice.service.user.TUserService;
import com.group_six.yyjhservice.vo.ControllerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dateOper")
public class DateOperController {
    @Autowired
    TUserService tUserService;
    @Autowired
    TDateFormService tDateFormService;

    @RequestMapping("/setForm")
    public Object setForm(@RequestParam("id")int id){
        ControllerResult controllerResult = new ControllerResult();
        controllerResult.setCode(DatasourceEnum.FAIL.getCode());
        controllerResult.setMsg(DatasourceEnum.FAIL.getMsg());
        TDateForm tDateForm = tDateFormService.findDateFormByState(1);
        tDateForm.setForm(null);
        if (tDateForm!=null){
            tDateForm.setState(0);
            if (tDateFormService.updDateForm(tDateForm)){
                tDateForm.setState(1);tDateForm.setId(id);
                if (tDateFormService.updDateForm(tDateForm)){
                    controllerResult.setCode(DatasourceEnum.SUCCESS.getCode());
                    controllerResult.setMsg(DatasourceEnum.SUCCESS.getMsg());
                }
            }
        }

        return controllerResult;
    }

    @RequestMapping("/getForm")
    public Object getForm(){
        ControllerResult controllerResult = new ControllerResult();
        controllerResult.setCode(DatasourceEnum.FAIL.getCode());
        controllerResult.setMsg(DatasourceEnum.FAIL.getMsg());
        TDateForm tDateForm = tDateFormService.findDateFormByState(1);
        if (tDateForm!=null){
            controllerResult.setCode(DatasourceEnum.SUCCESS.getCode());
            controllerResult.setMsg(DatasourceEnum.SUCCESS.getMsg());
            controllerResult.setPayload(tDateForm);
        }
        return controllerResult;
    }

    @RequestMapping("/getUser")
    public Object getUser(){
        ControllerResult controllerResult = new ControllerResult();
        controllerResult.setCode(DatasourceEnum.FAIL.getCode());
        controllerResult.setMsg(DatasourceEnum.FAIL.getMsg());
        TUser tUser = tUserService.findTUserById(1);
        if (tUser!=null){
            controllerResult.setCode(DatasourceEnum.SUCCESS.getCode());
            controllerResult.setMsg(DatasourceEnum.SUCCESS.getMsg());
            controllerResult.setPayload(tUser);
        }
        return controllerResult;
    }
}
