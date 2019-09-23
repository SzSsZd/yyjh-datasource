package com.group_six.yyjhservice.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ControllerResult implements Serializable {
    private int code;
    private Object payload;
    private String msg;
}
