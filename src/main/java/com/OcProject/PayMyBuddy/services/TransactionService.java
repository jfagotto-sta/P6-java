package com.OcProject.PayMyBuddy.services;

import com.OcProject.PayMyBuddy.model.Transaction;
import com.OcProject.PayMyBuddy.repository.TransactionRepository;
import com.OcProject.PayMyBuddy.services.ServiceInterface.ITransactionService;


public class TransactionService implements ITransactionService {

    private TransactionRepository transactionRepository;

    @Override
    public Transaction createANewTransaction(Transaction transaction) {
        return transactionRepository.createANewTransaction(transaction);
    }
}
