package com.example.receiptspringserver;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptRowMapper implements RowMapper<Receipt> {

    @Override
    public Receipt mapRow(ResultSet rs, int rowNum) throws SQLException {
        Receipt receipt = new Receipt();
        receipt.setReceiptId(rs.getInt("receiptId"));
        receipt.setReceiptName(rs.getString("receiptName"));
        return receipt;
    }
}
