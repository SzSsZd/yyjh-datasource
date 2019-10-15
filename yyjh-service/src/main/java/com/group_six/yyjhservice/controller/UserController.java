package com.group_six.yyjhservice.controller;

import com.group_six.yyjhservice.domain.user.TUser;
import com.group_six.yyjhservice.enumeration.DatasourceEnum;
import com.group_six.yyjhservice.service.user.TUserService;
import com.group_six.yyjhservice.vo.ControllerResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private TUserService tUserService;

    @RequestMapping("/getself")
    @RequiresPermissions(value = {"select"})
    public Object getself(@RequestParam String log_id){
        ControllerResult result = new ControllerResult();
        result.setCode(DatasourceEnum.FAIL.getCode());
        result.setMsg(DatasourceEnum.SUCCESS.getMsg());

        TUser u = tUserService.findTUserByLogid(log_id);

        if (u != null){
            result.setCode(DatasourceEnum.SUCCESS.getCode());
            result.setPayload(u);
            result.setMsg(DatasourceEnum.SUCCESS.getMsg());
        }
        return result;
    }
}
