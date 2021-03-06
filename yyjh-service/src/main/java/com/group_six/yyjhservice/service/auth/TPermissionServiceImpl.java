package com.group_six.yyjhservice.service.auth;

import com.group_six.yyjhservice.dao.auth.TPermissionMapper;
import com.group_six.yyjhservice.domain.auth.TPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class TPermissionServiceImpl implements TPermissionService {
    @Autowired
    private TPermissionMapper tPermissionMapper;


    @Override
    public boolean delTPermissionById(Integer id) {
        int count = tPermissionMapper.delTPermissionById(id);
        if (count > 0)
            return true;
        return false;
    }

    @Override
    public boolean addTPermission(TPermission record) {
        int count = tPermissionMapper.addTPermission(record);
        if (count > 0)
            return true;
        return false;
    }

    @Override
    public TPermission findTPermissionById(Integer id) {
        return tPermissionMapper.findTPermissionById(id);
    }

    @Override
    public boolean updTPermissionById(TPermission record) {
        int count = tPermissionMapper.updTPermissionById(record);
        if (count > 0)
            return true;
        return false;
    }

    @Override
    public List<TPermission> getAll() {
        return tPermissionMapper.getAll();
    }

    @Override
    public TPermission findTPermissionByName(String permission) {
        return tPermissionMapper.findTPermissionByName(permission);
    }

    @Override
    public List<TPermission> findTPermissionByRoleid(Integer id) {
        return tPermissionMapper.findTPermissionByRoleid(id);
    }
}
