package com.group_six.yyjhservice.controller;

import com.group_six.yyjhservice.config.jedis.JedisUtil;
import com.group_six.yyjhservice.domain.user.TUser;
import com.group_six.yyjhservice.enumeration.DatasourceEnum;
import com.group_six.yyjhservice.service.user.TUserService;
import com.group_six.yyjhservice.vo.ControllerResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/index")
public class LoginController {
    @Autowired
    TUserService tUserService;
    @Autowired
    JedisUtil jedisUtil;

    @RequestMapping("/login")
    public Object login(@RequestParam("log_param")String log_param,@RequestParam("log_pwd")String pwd){
        ControllerResult controllerResult = new ControllerResult();
        controllerResult.setCode(DatasourceEnum.FAIL.getCode());
        controllerResult.setMsg(DatasourceEnum.FAIL.getMsg());
        if (log_param!=null){
            TUser user = tUserService.findTUserByParam(log_param);
            if (user !=null&&jedisUtil.get(user.getLoginid(),0)==null&&
                    user.getPassword().equals(pwd)){
                //添加用户认证信息
                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken usernamePasswordToken
                        = new UsernamePasswordToken(user.getLoginid(), pwd);
                //进行验证，这里可以捕获异常，然后返回对应信息
                subject.login(usernamePasswordToken);
                //System.out.println("loginShiro:" + usernamePasswordToken);
                Map<String,Object> resp = new HashMap<String, Object>();
                jedisUtil.set(user.getLoginid(),"1",0);
                resp.put("log_id",user.getLoginid());
                controllerResult.setPayload(resp);
                controllerResult.setCode(DatasourceEnum.SUCCESS.getCode());
                controllerResult.setMsg(DatasourceEnum.SUCCESS.getMsg());
            }
        }
        return controllerResult;
    }
    @RequestMapping("/logout")
    public Object login(@RequestParam("log_id")String log_id){
        ControllerResult controllerResult = new ControllerResult();
        controllerResult.setCode(DatasourceEnum.FAIL.getCode());
        controllerResult.setMsg(DatasourceEnum.FAIL.getMsg());
        if (jedisUtil.get(log_id,0)!=null){
            jedisUtil.del(log_id,0);
            controllerResult.setCode(DatasourceEnum.SUCCESS.getCode());
            controllerResult.setMsg(DatasourceEnum.SUCCESS.getMsg());
        }
        return controllerResult;
    }

    @RequestMapping("/testShiro")
    @RequiresRoles(value = {"data_manager","super_admin"},logical = Logical.OR)
    public Object testShiro(){
        ControllerResult controllerResult = new ControllerResult();
        controllerResult.setCode(DatasourceEnum.FAIL.getCode());
        controllerResult.setMsg(DatasourceEnum.FAIL.getMsg());
        if (true){
            controllerResult.setCode(DatasourceEnum.SUCCESS.getCode());
            controllerResult.setMsg(DatasourceEnum.SUCCESS.getMsg());
        }

        return controllerResult;
    }
}
