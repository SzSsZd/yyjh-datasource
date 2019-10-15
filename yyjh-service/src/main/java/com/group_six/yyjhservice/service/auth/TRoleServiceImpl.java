package com.group_six.yyjhservice.service.auth;

import com.group_six.yyjhservice.dao.auth.TRoleMapper;
import com.group_six.yyjhservice.domain.auth.TRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class TRoleServiceImpl implements TRoleService {
    @Autowired
    private TRoleMapper tRoleMapper;

    @Override
    public boolean delTRoleById(Integer id) {
        int count = tRoleMapper.delTRoleById(id);
        if (count > 0)
            return true;
        return false;
    }

    @Override
    public boolean addTRole(TRole record) {
        int count = tRoleMapper.addTRole(record);
        if (count > 0)
            return true;
        return false;
    }

    @Override
    public TRole findTRoleById(Integer id) {
        return tRoleMapper.findTRoleById(id);
    }

    @Override
    public boolean updTRoleById(TRole record) {
        int count = tRoleMapper.updTRoleById(record);
        if (count > 0)
            return true;
        return false;
    }

    @Override
    public List<TRole> getAll() {
        return tRoleMapper.getAll();
    }

    @Override
    public TRole findTRoleByRolename(String rolename) {
        return tRoleMapper.findTRoleByRolename(rolename);
    }

    @Override
    public List<TRole> findTRoleByLogid(String logid) {
        return tRoleMapper.findTRoleByLogid(logid);
    }
}
