package com.group_six.yyjhservice.dao.auth;

import com.group_six.yyjhservice.domain.auth.TUserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserRoleMapper {
    int delTUserRoleById(Integer id);

    int addTUserRole(TUserRole record);

    TUserRole findTUserRoleById(Integer id);

    int updTUserRole(TUserRole record);
}