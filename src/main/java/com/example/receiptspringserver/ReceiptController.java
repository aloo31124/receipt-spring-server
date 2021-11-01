package com.example.receiptspringserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ReceiptController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping("/receipt")
    public String createReceipt(@RequestBody Receipt receipt){
        String sql = "INSERT Receipt ( receiptName ) VALUE ( :receiptName )";
        Map<String,Object> map = new HashMap<>();
        map.put("receiptName" ,receipt.getReceiptName());
        int result = namedParameterJdbcTemplate.update(sql,map);

        return "插入 receipt 資料, result: " + result;
    }

    @GetMapping("/receipt/all")
    public List<Receipt> findReceiptAll(){
        String sql = " SELECT receiptId,receiptName FROM Receipt ";
        Map<String,Object> map = new HashMap<>();
        List<Receipt> result = namedParameterJdbcTemplate.query(sql,map, new ReceiptRowMapper());
        return result;
    }

    @GetMapping("/receipt/{receiptId}")
    public Receipt findReceiptById(@PathVariable Integer receiptId){
        String sql = " SELECT receiptId,receiptName FROM Receipt WHERE receiptId= :receiptId ";
        Map<String,Object> map = new HashMap<>();
        map.put("receiptId",receiptId);
        List<Receipt> result = namedParameterJdbcTemplate.query(sql,map, new ReceiptRowMapper());
        return result.get(0);
    }

    @PutMapping("/receipt/{receiptId}")
    public String updateReceipt(@RequestBody Receipt receipt,@PathVariable Integer receiptId){
        String sql = " UPDATE Receipt SET receiptName = :receiptName  WHERE receiptId= :receiptId ";
        Map<String,Object> map = new HashMap<>();
        map.put("receiptName", receipt.getReceiptName());
        map.put("receiptId", receiptId);
        int result = namedParameterJdbcTemplate.update(sql,map);

        return "修改 receipt 資料成功 : " + result;
    }

    @DeleteMapping("/receipt/{receiptId}")
    public String DeleteReceipt(@PathVariable Integer receiptId){
        String sql = " DELETE FROM Receipt WHERE receiptId= :receiptId ";
        Map<String,Object> map = new HashMap<>();
        map.put("receiptId", receiptId);
        int result = namedParameterJdbcTemplate.update(sql,map);

        return "刪除 receipt 資料成功 , result : " + result;
    }

}
