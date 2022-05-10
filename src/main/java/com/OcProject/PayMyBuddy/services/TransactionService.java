package com.OcProject.PayMyBuddy.services;

import java.util.List;
import java.util.Optional;

import com.OcProject.PayMyBuddy.model.Contact;
import com.OcProject.PayMyBuddy.model.ContactId;
import com.OcProject.PayMyBuddy.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OcProject.PayMyBuddy.model.Transaction;
import com.OcProject.PayMyBuddy.model.User;


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
        return transactionRepo.save(transaction);
    }

    public void deleteById (Integer id){
        transactionRepo.deleteById(id);
    }

}