package com.example.receiptspringserver.controller;

import com.example.receiptspringserver.model.Receipt;
import com.example.receiptspringserver.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @GetMapping("/receipt/all")
    public List<Receipt> findReceiptAll(){
        return receiptService.findReceiptAll();
    }

    @GetMapping("/receipt/{receiptId}")
    public Receipt findReceiptById(@PathVariable Integer receiptId){
        return receiptService.findReceiptById(receiptId);
    }

    @PostMapping("/receipt")
    public int insertReceipt(@RequestBody Receipt receipt){
        return receiptService.insertReceipt(receipt);
    }

    @PutMapping("/receipt/{receiptId}")
    public int updateReceipt(@RequestBody Receipt receipt,@PathVariable Integer receiptId){
        return receiptService.updateRecieptById(receipt,receiptId);
    }

    @DeleteMapping("/receipt/{receiptId}")
    public int DeleteReceipt(@PathVariable Integer receiptId){
        return receiptService.deleteReceiptById(receiptId);
    }

}
