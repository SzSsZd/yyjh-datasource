package com.group_six.yyjhservice.dao.auth;

import com.group_six.yyjhservice.domain.auth.TRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TRoleMapper {
    int delTRoleById(Integer id);

    int addTRole(TRole record);

    TRole findTRoleById(Integer id);

    int updTRole(TRole record);

    List<TRole> findTRoleByLogid(String logid);
}