package com.group_six.tools;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class YYJHTools {
    public static final String DEFAULT_FORMAT_PARAM = "yyyy-MM-dd' 'HH:mm:ss";

    //根据格式化参数求格式化日期字符串
    public static Date formatDateByPara(String date, String param) throws ParseException {
        if(null == param || "".equals(param.trim())){
            param = YYJHTools.DEFAULT_FORMAT_PARAM;
        }
        DateFormat df = new SimpleDateFormat(param);
        return df.parse(date);
    }

    //根据格式化参数求格式化日期字符串
    public static String parseDateToStr(Date date, String param) throws ParseException {
        if(null == param || "".equals(param.trim())){
            param = YYJHTools.DEFAULT_FORMAT_PARAM;
        }
        DateFormat df = new SimpleDateFormat(param);
        return df.format(date);
    }

    //url格式化
    public static URL formatURL(String url) throws MalformedURLException {
        return new URL(url);
    }

    //判断是否为email
    public static boolean isEmail(String email){
        return email.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
    }

    //去除所有，包括字符间的空格
    public static String filterInnerBlank(String str){
        return str.replaceAll(" ","");
    }
}
