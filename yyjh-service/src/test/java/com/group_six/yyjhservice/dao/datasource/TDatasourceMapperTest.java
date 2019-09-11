//package com.group_six.yyjhservice.dao.datasource;
//
//import com.group_six.yyjhservice.domain.datasource.TDatasource;
//import junit.framework.TestCase;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TDatasourceMapperTest extends TestCase {
//
//    @Autowired
//    TDatasourceMapper tDatasourceMapper;
//
//    @Test
//    public void testDelTDatasourceById() {
//        System.out.println(tDatasourceMapper.delTDatasourceById(3));
//    }
//
//    @Test
//    public void testAddTDatasource() {
//        TDatasource tDatasource = new TDatasource();
//        tDatasource.setDescription("test");
//        tDatasource.setAuth("test");
//        System.out.println( tDatasourceMapper.addTDatasource(tDatasource));
//    }
//
//    @Test
//    public void testFindTDatasourceByid() {
//        System.out.println(tDatasourceMapper.findTDatasourceByid(1));
//    }
//
//    @Test
//    public void testUpdTDatasource() {
//        TDatasource tDatasource = new TDatasource();
//        tDatasource.setDescription("test1");
//        tDatasource.setAuth("test1");
//        tDatasource.setId(1);
//        tDatasource.setUserId("2");
//        tDatasourceMapper.updTDatasource(tDatasource);
//    }
//
//    @Test
//    public void testGetAll() {
//        System.out.println(tDatasourceMapper.getAll());
//    }
//}