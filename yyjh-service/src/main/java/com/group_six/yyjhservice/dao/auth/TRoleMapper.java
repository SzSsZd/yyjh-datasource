package com.group_six.yyjhservice.dao.auth;

import com.group_six.yyjhservice.domain.auth.TRole;
import org.springframework.stereotype.Repository;

@Repository
public interface TRoleMapper {
    int delTRoleById(Integer id);

    int addTRole(TRole record);

    TRole findTRoleById(Integer id);

    int updTRole(TRole record);
}