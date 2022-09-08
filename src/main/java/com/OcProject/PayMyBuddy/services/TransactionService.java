package com.OcProject.PayMyBuddy.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import com.OcProject.PayMyBuddy.exceptions.TransactionException;
import com.OcProject.PayMyBuddy.model.TransactionBean;
import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.repository.TransactionRepository;
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

    public Iterable<TransactionBean> getTransactionList(String mail){
        List<Transaction> transactions = transactionRepo.findTransactionByMail(mail);
        List<TransactionBean> beans = new ArrayList<>();
        for (Transaction t:transactions) {
            TransactionBean tb = new TransactionBean();
            tb.setSender(t.getSender().getMail());
            tb.setRecipient(t.getRecipient().getMail());
            tb.setAmount(t.getAmount());
            tb.setFees(t.getFees());
            beans.add(tb);

        }
        return beans;
    }

    public TransactionBean makeATransaction(TransactionBean transactionBean) {

        User user1 = userService.findByMail(transactionBean.getSender());
        User user2 = userService.findByMail(transactionBean.getRecipient());

        double User1Balance = user1.getBalance();
        double User2Balance = user2.getBalance();



        if (User1Balance > transactionBean.getAmount()+TransactionUtils.calculateFess(transactionBean.getAmount())) {
            double fees = TransactionUtils.calculateFess(transactionBean.getAmount());
            user1.setBalance(User1Balance - (transactionBean.getAmount() + fees));
            user2.setBalance(User2Balance + transactionBean.getAmount());

            User admin = userService.findByMail("admin@admin.fr");
            admin.setBalance(admin.getBalance()+fees);
            userService.save(admin);

            Transaction transaction = new Transaction();
            transaction.setDateOfTransaction(new Date());
            transaction.setRecipient(user2);
            transaction.setSender(user1);
            transaction.setAmount(transactionBean.getAmount());
            transaction.setFees(fees);
            transactionRepo.save(transaction);

        } else {
            TransactionException.notEnoughMoneyException("You have not enough money on your account to operate the trasanction.");
        }

        return transactionBean;
    }

}