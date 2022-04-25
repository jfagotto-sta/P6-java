package com.OcProject.PayMyBuddy.controller;

import com.OcProject.PayMyBuddy.model.Transaction;
import com.OcProject.PayMyBuddy.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;




@Controller
public class TransactionController {

    private TransactionService transactionService;


    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(path = "/transactions", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Transaction createANewTransaction(@RequestBody Transaction transaction) {
        return transactionService.createANewTransaction(transaction);
    }
}
