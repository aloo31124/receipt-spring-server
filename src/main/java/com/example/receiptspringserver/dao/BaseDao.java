package com.example.receiptspringserver.dao;

import org.springframework.jdbc.core.RowMapper;
import java.util.List;
import java.util.Map;

public interface BaseDao {

    <T> List<T> findAll(String tableName , RowMapper<T> rowMapper);

    Object findByColumn(String tableName, Map ColumanMap , RowMapper rowMapper);

}
