package com.example.receiptspringserver.dao;

import com.example.receiptspringserver.model.ModelManager;
import com.example.receiptspringserver.model.Receipt;
import org.springframework.jdbc.core.RowMapper;
import java.util.List;
import java.util.Map;

public interface BaseDao {

    <T> List<T> findAll(ModelManager<T> modelManager);

    <T>  List<T> findByColumn(String columanName,Integer id,  ModelManager<T> modelManager);

    <T> int insertOne(Receipt receipt, ModelManager<T> modelManager);

}
