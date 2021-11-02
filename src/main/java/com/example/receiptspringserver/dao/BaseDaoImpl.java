package com.example.receiptspringserver.dao;

import com.example.receiptspringserver.ReceiptRowMapper;
import com.example.receiptspringserver.model.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.RowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public abstract class BaseDaoImpl implements BaseDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public <T> List<T> findAll(String tableName, RowMapper<T> rowMapper) {
        String sql = " SELECT receiptId,receiptName FROM " + tableName;
        Map<String,Object> map = new HashMap<>();
        List<T> result = namedParameterJdbcTemplate.query(sql,map, rowMapper);
        return result;
    }

    @Override
    public Object findByColumn(String tableName, Map ColumanMap, RowMapper rowMapper) {
        return null;
    }
}
