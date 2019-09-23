package com.group_six.yyjhservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/router")
public class RouterController {
    @RequestMapping(value = "/datasource")
    public String datasource(){
        return "datasource/datasource";
    }
}
