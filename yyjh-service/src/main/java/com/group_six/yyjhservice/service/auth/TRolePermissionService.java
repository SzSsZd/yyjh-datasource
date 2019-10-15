package com.group_six.yyjhservice.service.auth;

import com.group_six.yyjhservice.domain.auth.TRolePermission;
import com.group_six.yyjhservice.vo.RolePerVO;

import java.util.List;

public interface TRolePermissionService {
    boolean delTRolePerById(Integer id);

    boolean addTRolePer(TRolePermission record);

    TRolePermission findTRolePerById(Integer id);

    boolean updTRolePerById(TRolePermission record);

    List<RolePerVO> getAll();

    List<TRolePermission> findTRolePerByR_id(Integer id);
}
