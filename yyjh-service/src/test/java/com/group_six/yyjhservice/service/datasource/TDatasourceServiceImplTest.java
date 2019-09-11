//package com.group_six.yyjhservice.service.datasource;
//
//import com.group_six.yyjhservice.domain.datasource.TDatasource;
//import junit.framework.TestCase;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.junit.Test;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TDatasourceServiceImplTest extends TestCase {
//
//    @Autowired
//    TDatasourceService tDatasourceService;
//
//    @Test
//    public void testDelTDatasourceById() {
//        System.out.println(tDatasourceService.delTDatasourceById(2));
//    }
//
//    @Test
//    public void testAddTDatasource() {
//        TDatasource tDatasource = new TDatasource();
//        tDatasource.setUserId("2");
//        tDatasource.setId(2);
//        System.out.println(tDatasourceService.addTDatasource(tDatasource));
//    }
//
//    @Test
//    public void testFindTDatasourceByid() {
//        System.out.println(tDatasourceService.findTDatasourceByid(2));
//    }
//
//    @Test
//    public void testUpdTDatasource() {
//        TDatasource tDatasource = new TDatasource();
//        tDatasource.setUserId("22");
//        tDatasource.setId(2);
//        System.out.println(tDatasourceService.updTDatasource(tDatasource));
//    }
//
//    @Test
//    public void testGetAll() {
//        System.out.println(tDatasourceService.getAll());
//    }
//}