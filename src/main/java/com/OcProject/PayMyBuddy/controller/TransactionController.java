package com.OcProject.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.OcProject.PayMyBuddy.model.Transaction;
import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.services.TransactionService;




@RestController
public class TransactionController {

	@Autowired
    private TransactionService transactionService;


    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(path = "/transactions", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Transaction createANewTransaction(@RequestBody Transaction transaction) {
    	User u = new User();
    	u.setUserId(1);
    	transaction.setRecipient(u);
    	transaction.setSender(u);
        return transactionService.createANewTransaction(transaction);
    }
}
