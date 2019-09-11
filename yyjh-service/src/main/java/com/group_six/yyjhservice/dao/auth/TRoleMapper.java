package com.group_six.yyjhservice.dao.auth;

import com.group_six.yyjhservice.domain.auth.TRole;
import org.springframework.stereotype.Repository;

@Repository
public interface TRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TRole record);

    int insertSelective(TRole record);

    TRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);
}