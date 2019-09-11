package com.group_six.yyjhservice.service.datasource;

import com.group_six.yyjhservice.domain.datasource.TDatasource;

import java.util.List;

public interface TDatasourceService {
    boolean delTDatasourceById(Integer id);

    boolean addTDatasource(TDatasource record);

    TDatasource findTDatasourceByid(Integer id);

    boolean updTDatasource(TDatasource record);

    List<TDatasource> getAll();
}
