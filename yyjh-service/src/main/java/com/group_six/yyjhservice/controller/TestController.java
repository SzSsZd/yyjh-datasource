package com.group_six.yyjhservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/testcsv")
    public String testcsv(){
        //csv是文件名称，找到文件地址，然后返回页面
        return "csv";
    }
}
