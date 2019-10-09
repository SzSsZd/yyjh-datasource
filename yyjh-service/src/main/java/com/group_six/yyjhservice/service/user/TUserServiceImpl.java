package com.group_six.yyjhservice.service.user;

import com.group_six.yyjhservice.dao.user.TUserMapper;
import com.group_six.yyjhservice.domain.user.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class TUserServiceImpl implements TUserService {
    @Autowired
    TUserMapper tUserMapper;
    @Override
    public boolean delTUserById(Integer id) {
        boolean flag = false;
        int count = tUserMapper.delTUserById(id);
        if (count>0) flag = true;
        return flag;
    }

    @Override
    public boolean addTUser(TUser record) {
        boolean flag = false;
        int count = tUserMapper.addTUser(record);
        if (count>0) flag = true;
        return flag;
    }

    @Override
    public TUser findTUserById(Integer id) {
        return tUserMapper.findTUserById(id);
    }

    @Override
    public boolean updTUser(TUser record) {
        boolean flag = false;
        int count = tUserMapper.updTUser(record);
        if (count>0) flag = true;
        return flag;
    }

    public TUser findTUserByLogid(String logid){return tUserMapper.findTUserByLogid(logid);}

    @Override
    public TUser findTUserByParam(String param) {
        TUser user = tUserMapper.findTUserByLogid(param);
        if (user==null) user = tUserMapper.findTUserByTel(param);
        if (user==null) user = tUserMapper.findUserByEmail(param);
        return user;
    }
}
