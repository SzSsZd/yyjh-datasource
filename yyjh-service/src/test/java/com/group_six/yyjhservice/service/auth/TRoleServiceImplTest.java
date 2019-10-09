//package com.group_six.yyjhservice.service.auth;
//
//import com.group_six.yyjhservice.domain.auth.TRole;
//import junit.framework.TestCase;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.junit.Test;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TRoleServiceImplTest extends TestCase {
//
//    @Autowired
//    TRoleService tRoleService;
//    @Test
//    public void testFindTRoleByLogid() {
//        List<TRole> roles = tRoleService.findTRoleByLogid("test");
//        for (TRole role : roles){
//            System.out.println(role.toString());
//        }
//    }
//}