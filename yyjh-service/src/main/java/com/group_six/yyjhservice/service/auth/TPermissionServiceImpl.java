package com.group_six.yyjhservice.service.auth;

import com.group_six.yyjhservice.dao.auth.TPermissionMapper;
import com.group_six.yyjhservice.domain.auth.TPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class TPermissionServiceImpl implements TPermissionService{
    @Autowired
    TPermissionMapper tPermissionMapper;
    @Override
    public List<TPermission> findTPermissionByRoleid(Integer id) {
        return tPermissionMapper.findTPermissionByRoleid(id);
    }
}
