//package com.group_six.yyjhservice.service.auth;
//
//import com.group_six.yyjhservice.domain.auth.TPermission;
//import junit.framework.TestCase;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TPermissionServiceImplTest extends TestCase {
//    @Autowired
//    TPermissionService tPermissionService;
//
//    @Test
//    public void testFindTPermissionByRoleid() {
//        List<TPermission> permissions = tPermissionService.findTPermissionByRoleid(2);
//        for (TPermission permission : permissions){
//            System.out.println(permission.toString());
//        }
//    }
//}