package com.group_six.yyjhservice.dao.datasource;

import com.group_six.yyjhservice.domain.datasource.TDatasource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TDatasourceMapper {
    int delTDatasourceById(Integer id);

    int addTDatasource(TDatasource record);

    TDatasource findTDatasourceByid(Integer id);

    int updTDatasource(TDatasource record);

    List<TDatasource> getAll();
}