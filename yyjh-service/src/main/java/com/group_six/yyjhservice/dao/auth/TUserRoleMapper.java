package com.group_six.yyjhservice.dao.auth;

import com.group_six.yyjhservice.domain.auth.TUserRole;
import com.group_six.yyjhservice.vo.UserRoleVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TUserRoleMapper {
    int delTUserRoleById(Integer id);

    int addTUserRole(TUserRole record);

    TUserRole findTUserRoleById(Integer id);

    int updTUserRoleById(TUserRole record);

    List<UserRoleVO> getAll();

    List<TUserRole> findTUserRoleByU_Id(Integer u_id);
}