package com.group_six.yyjhservice.service.auth;

import com.group_six.yyjhservice.domain.auth.TRole;

import java.util.List;

public interface TRoleService {
    public List<TRole> findTRoleByLogid(String logid);
}
