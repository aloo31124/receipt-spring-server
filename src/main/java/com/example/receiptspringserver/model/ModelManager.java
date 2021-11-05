package com.example.receiptspringserver.model;

import org.springframework.jdbc.core.RowMapper;

public interface ModelManager<T> {

    String getTableName();

    String getAllColumn(boolean isInsert);

    RowMapper getRowMappger();

}
