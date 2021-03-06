package com.group_six.yyjhservice.service.auth;

import com.group_six.yyjhservice.domain.auth.TUserRole;
import com.group_six.yyjhservice.vo.UserRoleVO;

import java.util.List;

public interface TUserRoleService {
    boolean delTUserRoleById(Integer id);

    boolean addTUserRole(TUserRole record);

    TUserRole findTUserRoleById(Integer id);

    boolean updTUserRoleById(TUserRole record);

    List<UserRoleVO> getAll();

    List<TUserRole> findTUserRoleByU_Id(Integer u_id);
}
