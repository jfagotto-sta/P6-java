package com.OcProject.PayMyBuddy.services;

import java.util.Optional;


import com.OcProject.PayMyBuddy.exceptions.TransactionException;
import com.OcProject.PayMyBuddy.model.TransactionBean;
import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.repository.TransactionRepository;
import com.OcProject.PayMyBuddy.repository.UserRepository;
import com.OcProject.PayMyBuddy.utils.TransactionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OcProject.PayMyBuddy.model.Transaction;



@Service
public class TransactionService {

    @Autowired
    private UserService userService;


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


    public TransactionBean makeATransaction(TransactionBean transactionBean) {


        User user1 = userService.findByMail(transactionBean.getMail1());
        User user2 = userService.findByMail(transactionBean.getMail2());

        double User1Balance = user1.getBalance();
        double User2Balance = user2.getBalance();


        if (User1Balance > transactionBean.getAmount()) {
            user1.setBalance(User1Balance - (transactionBean.getAmount() + TransactionUtils.calculateFess(transactionBean.getAmount())));
            user2.setBalance(User2Balance + transactionBean.getAmount());

            User admin = userService.findByMail("admin@admin.fr");
            admin.setBalance(admin.getBalance()+TransactionUtils.calculateFess(transactionBean.getAmount()));
        } else {
            TransactionException.notEnoughMoneyException("You have not enough money on your account to operate the trasanction.");
        }

        return transactionBean;
    }
}