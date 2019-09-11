package com.group_six.yyjhservice.dao.user;

import com.group_six.yyjhservice.domain.user.TUser;
import org.springframework.stereotype.Repository;


@Repository
public interface TUserMapper {
    int delTUserById(Integer id);

    int addTUser(TUser record);

    TUser findTUserById(Integer id);

    int updTUser(TUser record);
}