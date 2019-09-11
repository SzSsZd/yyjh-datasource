//package com.group_six.tools;
//
//import junit.framework.TestCase;
//import org.junit.Test;
//
//import java.net.MalformedURLException;
//import java.text.ParseException;
//import java.util.Date;
//
//public class YYJHToolsTest extends TestCase {
//
//    @Test
//    public void testFormatDateByPara() {
//        Date date = new Date();
//        String dataStr = "2019-09-11 16:06:28";
//        try {
//            System.out.println(YYJHTools.formatDateByPara(dataStr,""));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testParseDateToStr() {
//        Date date = new Date();
//        try {
//            System.out.println(YYJHTools.parseDateToStr(date,""));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testFormatURL() {
//        String url = "http://hnrc8m.natappfree.cc";
//        try {
//            System.out.println(YYJHTools.formatURL(url));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testIsEmail() {
//        String email = "1474140287@qq.com";
//        System.out.println(YYJHTools.isEmail(email));
//    }
//
//    @Test
//    public void testFilterInnerBlank() {
//        String str = "asd s  dd f";
//        System.out.println(YYJHTools.filterInnerBlank(str));
//    }
//}