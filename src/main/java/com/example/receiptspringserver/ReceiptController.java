package com.example.receiptspringserver;

import org.springframework.web.bind.annotation.*;

@RestController
public class ReceiptController {

    @PostMapping("/receipt")
    public String createReceipt(@RequestBody Receipt receipt){
        System.out.println(" post receipt id : " + receipt.getReceiptId());
        System.out.println(" post receipt name : " + receipt.getReceiptName());
        return "插入 receipt 資料";
    }

    @GetMapping("/receipt/{receiptId}")
    public String searchReceipt(@PathVariable Integer receiptId){
        System.out.println(" get receipt id " + receiptId);
        return "搜尋 receipt 資料";
    }

    @PutMapping("/receipt/{receiptId}")
    public String updateReceipt(@RequestBody Receipt receipt,@PathVariable Integer receiptId){
        System.out.println(" put receipt id : " + receiptId );
        System.out.println(" put receipt name : " + receipt.getReceiptName());
        return "修改 receipt 資料";
    }

    @DeleteMapping("/receipt/{receiptId}")
    public String DeleteReceipt(@PathVariable Integer receiptId){
        System.out.println(" delete receipt id " + receiptId);
        return "刪除 receipt 資料";
    }

}
