package com.group_six.yyjhservice.dao.auth;

import com.group_six.yyjhservice.domain.auth.TPermission;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TPermissionMapper {
    int delTPermissionById(Integer id);

    int addTPermission(TPermission record);

    TPermission findTPermissionById(Integer id);

    int updTPermissionById(TPermission record);

    List<TPermission> getAll();

    List<TPermission> findTPermissionByRoleid(Integer roleid);

    TPermission findTPermissionByName(String permission);
}