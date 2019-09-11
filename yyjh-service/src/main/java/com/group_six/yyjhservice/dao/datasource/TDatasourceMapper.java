package com.group_six.yyjhservice.dao.datasource;

import com.group_six.yyjhservice.domain.datasource.TDatasource;
import org.springframework.stereotype.Repository;

@Repository
public interface TDatasourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TDatasource record);

    int insertSelective(TDatasource record);

    TDatasource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TDatasource record);

    int updateByPrimaryKey(TDatasource record);
}