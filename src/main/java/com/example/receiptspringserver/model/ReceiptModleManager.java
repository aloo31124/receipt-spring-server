package com.example.receiptspringserver.model;

import org.springframework.jdbc.core.RowMapper;

public class ReceiptModleManager implements ModelManager<Receipt>{

    public final String TABLE_NAME = "Receipt";

    public final String RECEIPT_ID = "receiptId";
    public final String RECEIPT_NAME = "receiptName";

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public String getAllColumn(boolean isInsert) {
        if(isInsert)
            return " :" + RECEIPT_NAME + " ";
        else
            return " " + RECEIPT_ID+ ", " + RECEIPT_NAME + " ";
    }

    @Override
    public RowMapper getRowMappger() {
        return new ReceiptRowMapper();
    }

}
