package com.group_six.yyjhservice.service.user;

import com.group_six.yyjhservice.domain.user.TUser;

import java.util.List;

public interface TUserService {
    boolean delTUserById(Integer id);

    boolean addTUser(TUser record);

    TUser findTUserById(Integer id);

    boolean updTUser(TUser record);

    TUser findTUserByLogid(String logid);

    TUser findTUserByParam(String param);

    List<TUser> getAll();
}
