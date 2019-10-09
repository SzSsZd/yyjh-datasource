package com.group_six.yyjhservice.service.auth;

import com.group_six.yyjhservice.domain.auth.TPermission;

import java.util.List;

public interface TPermissionService {
    List<TPermission> findTPermissionByRoleid(Integer id);
}
