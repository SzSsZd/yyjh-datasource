package com.group_six.yyjhservice.dao.datasource;

import com.group_six.yyjhservice.domain.datasource.TDatasource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TDatasourceMapper {
    int delTDataSourceById(Integer id);

    int addTDataSource(TDatasource record);

    TDatasource findTDataSourceById(Integer id);

    int updTDataSourceById(TDatasource record);

    List<TDatasource> getAll();

    Integer getTotal();

    List<TDatasource> getTDatasourceListPage(TDatasource record);

    int batchDeleteById(List<Integer> idsList);
}