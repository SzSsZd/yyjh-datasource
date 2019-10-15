package com.group_six.yyjhservice.service.dateForm;

import com.group_six.yyjhservice.dao.dateForm.TDateFormMapper;
import com.group_six.yyjhservice.domain.dateForm.TDateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class TDateFormServiceImpl implements TDateFormService {
    @Autowired
    TDateFormMapper tDateFormMapper;
    @Override
    public boolean delDateFormById(Integer id) {
        boolean flag = false;
        int count = tDateFormMapper.delDateFormById(id);
        if (count>0) flag = true;
        return flag;
    }

    @Override
    public boolean addDateForm(TDateForm record) {
        boolean flag = false;
        int count = tDateFormMapper.addDateForm(record);
        if (count>0) flag = true;
        return flag;
    }

    @Override
    public TDateForm findDateFormById(Integer id) {
        return tDateFormMapper.findDateFormById(id);
    }

    @Override
    public TDateForm findDateFormByState(Integer state) {
        return tDateFormMapper.findDateFormByState(state);
    }

    @Override
    public boolean updDateForm(TDateForm record) {
        boolean flag = false;
        int count = tDateFormMapper.updDateForm(record);
        if (count>0) flag = true;
        return flag;
    }
}
