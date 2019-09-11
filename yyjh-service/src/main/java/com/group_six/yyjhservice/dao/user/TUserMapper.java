package com.group_six.yyjhservice.dao.user;

import com.group_six.yyjhservice.domain.user.TUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}