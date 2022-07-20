package com.OcProject.PayMyBuddy.services;

import java.util.Optional;

import com.OcProject.PayMyBuddy.repository.TransactionRepository;
import com.OcProject.PayMyBuddy.utils.TransactionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OcProject.PayMyBuddy.model.Transaction;


@Service
public class TransactionService   {

    @Autowired
    private TransactionRepository transactionRepo;

    public Iterable<Transaction> getTransactions() {
        return transactionRepo.findAll();
    }

    public Optional<Transaction> getTransactionById(Integer id) {
        return transactionRepo.findById(id);
    }

    public Transaction newTransaction(Transaction transaction){
    	//transaction quand elle arrive, les fees ne sont pas encore calculés
    	transaction.setFees(TransactionUtils.calculateFess(transaction));
        return transactionRepo.save(transaction);
    }

//    public Optional<Transaction> deleteById (Integer id){
//
//      Optional<Transaction> transaction = Optional.of(new Transaction());
//       transaction = transactionRepo.findById(id);
//       transactionRepo.deleteById(id);
//        return transaction;
//    }

}