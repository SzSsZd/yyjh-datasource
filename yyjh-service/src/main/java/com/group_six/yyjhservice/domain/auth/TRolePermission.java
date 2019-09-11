package com.group_six.yyjhservice.domain.auth;

import lombok.Data;

@Data
public class TRolePermission {
    private Integer id;

    private Integer roleId;

    private Integer permissionId;

}