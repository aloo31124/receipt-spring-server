package com.example.receiptspringserver.dao;

import com.example.receiptspringserver.model.Receipt;
import com.example.receiptspringserver.ReceiptRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ReceiptDaoImpl implements ReceiptDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Receipt findReceiptById(Integer receiptId) {
        String sql = " SELECT receiptId,receiptName FROM Receipt WHERE receiptId= :receiptId ";
        Map<String,Object> map = new HashMap<>();
        map.put("receiptId",receiptId);
        List<Receipt> result = namedParameterJdbcTemplate.query(sql,map, new ReceiptRowMapper());
        return result.get(0);
    }

    @Override
    public List<Receipt> findReceiptAll() {
        String sql = " SELECT receiptId,receiptName FROM Receipt ";
        Map<String,Object> map = new HashMap<>();
        List<Receipt> result = namedParameterJdbcTemplate.query(sql,map, new ReceiptRowMapper());
        return result;
    }

    @Override
    public int insertReceipt(Receipt receipt) {
        String sql = " INSERT Receipt ( receiptName ) VALUE ( :receiptName )";
        Map<String, Object> map = new HashMap<>();
        map.put("receiptName", receipt.getReceiptName());
        return namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public int updateRecieptById(Receipt receipt,Integer receiptId) {
        String sql = " UPDATE Receipt SET receiptName = :receiptName  WHERE receiptId= :receiptId ";
        Map<String,Object> map = new HashMap<>();
        map.put("receiptName", receipt.getReceiptName());
        map.put("receiptId", receiptId);
        return namedParameterJdbcTemplate.update(sql,map);
    }

    @Override
    public int deleteReceiptById(Integer receiptId) {
        String sql = " DELETE FROM Receipt WHERE receiptId= :receiptId ";
        Map<String,Object> map = new HashMap<>();
        map.put("receiptId", receiptId);
        return namedParameterJdbcTemplate.update(sql,map);
    }
}
