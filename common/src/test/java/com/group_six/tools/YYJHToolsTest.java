//package com.group_six.tools;
//
//import junit.framework.TestCase;
//import org.junit.Test;
//
//import java.net.MalformedURLException;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class YYJHToolsTest extends TestCase {
//
//    @Test
//    public void testFormatDateByPara() {
//        Date date = new Date();
//        String dataStr = "2019-09-11 16:06:28";
//        try {
//            System.out.println(YYJHTools.formatDateByPara(dataStr,"dd/MM/yyyy' 'HH:mm:ss"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testParseDateToStr() {
//        Date date = new Date();
//        try {
//            System.out.println(YYJHTools.parseDateToStr(date,"dd/MM/yyyy' 'HH:mm:ss"));
//            DateFormat df = new SimpleDateFormat();
//            System.out.println(df.parse(YYJHTools.parseDateToStr(date,"dd/MM/yyyy' 'HH:mm:ss")));
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