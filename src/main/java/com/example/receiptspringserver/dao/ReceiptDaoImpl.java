package com.example.receiptspringserver.dao;

import com.example.receiptspringserver.model.Receipt;
import com.example.receiptspringserver.model.ReceiptModleManager;
import com.example.receiptspringserver.model.ReceiptRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ReceiptDaoImpl extends BaseDaoImpl implements ReceiptDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



    public List<Receipt> findReceiptAll() {
        return this.findAll(new ReceiptModleManager());
    }

    @Override
    public Receipt findReceiptById(Integer receiptId) {
        return this.findByColumn("receiptId" , receiptId,new ReceiptModleManager()).get(0);
    }

    @Override
    public int insertReceipt(Receipt receipt) {
        return this.insertOne(receipt, new ReceiptModleManager());
    }

    @Override
    public int updateRecieptById(Receipt receipt,Integer receiptId) {
        return this.updateByColumn(receipt, receiptId, new ReceiptModleManager());
    }

    @Override
    public int deleteReceiptById(Integer receiptId) {
        return this.deleteByColumn(receiptId);
    }
}
