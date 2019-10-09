package com.group_six.yyjhservice.service.auth;

import com.group_six.yyjhservice.dao.auth.TRoleMapper;
import com.group_six.yyjhservice.domain.auth.TRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class TRoleServiceImpl implements TRoleService{
    @Autowired
    TRoleMapper tRoleMapper;
    @Override
    public List<TRole> findTRoleByLogid(String logid) {
        return tRoleMapper.findTRoleByLogid(logid);
    }
}
