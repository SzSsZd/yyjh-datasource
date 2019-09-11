package com.group_six.yyjhservice.service.datasource;

import com.group_six.yyjhservice.dao.datasource.TDatasourceMapper;
import com.group_six.yyjhservice.domain.datasource.TDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
@Transactional
public class TDatasourceServiceImpl implements TDatasourceService{

    @Autowired
    TDatasourceMapper tDatasourceMapper;

    @Override
    public boolean delTDatasourceById(Integer id) {
        boolean flag = false;
        int count = tDatasourceMapper.delTDatasourceById(id);
        if (count>0) flag = true;
        return flag;
    }

    @Override
    public boolean addTDatasource(TDatasource record) {
        boolean flag = false;
        int count = tDatasourceMapper.addTDatasource(record);
        if (count>0) flag = true;
        return flag;
    }

    @Override
    public TDatasource findTDatasourceByid(Integer id) {
        return tDatasourceMapper.findTDatasourceByid(id);
    }

    @Override
    public boolean updTDatasource(TDatasource record) {
        boolean flag = false;
        int count = tDatasourceMapper.updTDatasource(record);
        if (count>0) flag = true;
        return flag;
    }

    @Override
    public List<TDatasource> getAll() {
        return tDatasourceMapper.getAll();
    }
}
