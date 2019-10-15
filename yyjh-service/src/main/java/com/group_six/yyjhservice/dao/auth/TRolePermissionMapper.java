package com.group_six.yyjhservice.dao.auth;

import com.group_six.yyjhservice.domain.auth.TRolePermission;
import com.group_six.yyjhservice.vo.RolePerVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TRolePermissionMapper {
    int delTRolePerById(Integer id);

    int addTRolePer(TRolePermission record);

    TRolePermission findTRolePerById(Integer id);

    int updTRolePerById(TRolePermission record);

    List<RolePerVO> getAll();

    List<TRolePermission> findTRolePerByR_id(Integer id);
}