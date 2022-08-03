package com.OcProject.PayMyBuddy.services;

import java.util.Optional;

import com.OcProject.PayMyBuddy.exceptions.TransactionException;
import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.repository.TransactionRepository;
import com.OcProject.PayMyBuddy.repository.UserRepository;
import com.OcProject.PayMyBuddy.utils.TransactionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OcProject.PayMyBuddy.model.Transaction;



@Service
public class TransactionService   {

    @Autowired
    private UserService userService;

    @Autowired
    private BankService bankService;


    @Autowired
    private TransactionRepository transactionRepo;

    public TransactionService() {
    }

    public Iterable<Transaction> getTransactions() {
        return transactionRepo.findAll();
    }

    public Optional<Transaction> getTransactionById(Integer id) {
        return transactionRepo.findById(id);
    }

//    public Transaction newTransaction(Transaction transaction){
//    	//transaction quand elle arrive, les fees ne sont pas encore calculés
//    	transaction.setFees(TransactionUtils.calculateFess(transaction));
//        return transactionRepo.save(transaction);
//    }

//    public Optional<Transaction> deleteById (Integer id){
//
//      Optional<Transaction> transaction = Optional.of(new Transaction());
//       transaction = transactionRepo.findById(id);
//       transactionRepo.deleteById(id);
//        return transaction;
//    }



    public void makeATransaction(double amount, User user1, User user2) {

        double User1Balance = user1.getBalance();
        double User2Balance = user2.getBalance();


        if(User1Balance>amount) {
            user1.setBalance(User1Balance - (amount + TransactionUtils.calculateFess(amount)));
            user2.setBalance(User2Balance + amount);
            bankService.updateBankFeesAmount(TransactionUtils.calculateFess(amount));
        }else {
            TransactionException.notEnoughMoneyException("You have not enough money on your account to operate the trasanction.");
        }

        }
    }