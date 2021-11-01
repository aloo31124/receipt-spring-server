package com.example.receiptspringserver.dao;

import com.example.receiptspringserver.model.Receipt;

import java.util.List;

public interface ReceiptDao {

    Receipt findReceiptById(Integer receiptId);

    List<Receipt> findReceiptAll();

    int insertReceipt(Receipt receipt);

    int updateRecieptById(Receipt receipt,Integer receiptId);

    int deleteReceiptById(Integer receiptId);

}
