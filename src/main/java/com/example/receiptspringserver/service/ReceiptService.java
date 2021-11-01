package com.example.receiptspringserver.service;

import com.example.receiptspringserver.model.Receipt;

import java.util.List;

public interface ReceiptService {

    Receipt findReceiptById(Integer receiptId);

    List<Receipt> findReceiptAll();

    int insertReceipt(Receipt receipt);

    int updateRecieptById(Receipt receipt,Integer receiptId);

    int deleteReceiptById(Integer receiptId);

}
