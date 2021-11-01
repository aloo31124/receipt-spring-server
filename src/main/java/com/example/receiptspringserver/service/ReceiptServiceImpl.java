package com.example.receiptspringserver.service;

import com.example.receiptspringserver.model.Receipt;
import com.example.receiptspringserver.dao.ReceiptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptDao receiptDao;

    @Override
    public Receipt findReceiptById(Integer receiptId) {
        return receiptDao.findReceiptById(receiptId);
    }

    @Override
    public List<Receipt> findReceiptAll() {
        return receiptDao.findReceiptAll();
    }

    @Override
    public int insertReceipt(Receipt receipt) {
        return receiptDao.insertReceipt(receipt);
    }

    @Override
    public int updateRecieptById(Receipt receipt,Integer receiptId) {
        return receiptDao.updateRecieptById(receipt,receiptId);
    }

    @Override
    public int deleteReceiptById(Integer receiptId) {
        return receiptDao.deleteReceiptById(receiptId);
    }
}
