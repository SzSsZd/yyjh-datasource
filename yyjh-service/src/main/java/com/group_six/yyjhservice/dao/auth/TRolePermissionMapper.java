package com.group_six.yyjhservice.dao.auth;

import com.group_six.yyjhservice.domain.auth.TRolePermission;
import org.springframework.stereotype.Repository;

@Repository
public interface TRolePermissionMapper {
    int delTRolePermissionById(Integer id);

    int addTRolePermission(TRolePermission record);

    TRolePermission findTRolePermissionById(Integer id);

    int updTRolePermission(TRolePermission record);
}