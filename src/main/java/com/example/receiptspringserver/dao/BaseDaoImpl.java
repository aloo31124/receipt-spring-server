package com.example.receiptspringserver.dao;

import com.example.receiptspringserver.model.ModelManager;
import com.example.receiptspringserver.model.Receipt;
import com.example.receiptspringserver.model.ReceiptRowMapper;
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
    public <T> List<T> findAll(ModelManager<T> modelManager) {
        String sql = " SELECT "+ modelManager.getAllColumn(false) +" FROM " + modelManager.getTableName();
        Map<String,Object> map = new HashMap<>();
        List<T> result = namedParameterJdbcTemplate.query(sql,map, modelManager.getRowMappger());
        return result;
    }

    @Override
    public <T>  List<T> findByColumn(String columanName, Integer id,  ModelManager<T> modelManager) {
        String sql = " SELECT receiptId,receiptName FROM " + modelManager.getTableName() + " WHERE " +columanName+ "= :" +columanName+ " ";
        Map<String,Object> map = new HashMap<>();
        map.put(columanName,id);
        List<T> result = namedParameterJdbcTemplate.query(sql,map, modelManager.getRowMappger() );
        return result;
    }

    @Override
    public <T> int insertOne( Receipt receipt, ModelManager<T> modelManager){
        String sql = " INSERT Receipt ( receiptName ) VALUE ( " + modelManager.getAllColumn(true) + " ) ";
        Map<String, Object> map = new HashMap<>();
        //先寫死， 後續要修正 傳入 Ojbect 自動對應欄位。
        map.put("receiptName", receipt.getReceiptName());
        return namedParameterJdbcTemplate.update(sql, map);
    }

    public <T> int updateByColumn(Receipt receipt,Integer receiptId,ModelManager<T> modelManager){
        String sql = " UPDATE Receipt SET "+ modelManager.getTableName() +" = :receiptName  WHERE receiptId= :receiptId ";
        Map<String,Object> map = new HashMap<>();
        //先寫死， 後續要修正 傳入 Ojbect 自動對應欄位。
        map.put("receiptName", receipt.getReceiptName());
        map.put("receiptId", receiptId);
        return namedParameterJdbcTemplate.update(sql,map);
    }

    public <T> int deleteByColumn(Integer receiptId){
        String sql = " DELETE FROM Receipt WHERE receiptId= :receiptId ";
        Map<String,Object> map = new HashMap<>();
        map.put("receiptId", receiptId);
        return namedParameterJdbcTemplate.update(sql,map);
    }
}
