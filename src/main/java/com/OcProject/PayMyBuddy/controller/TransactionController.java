package com.OcProject.PayMyBuddy.controller;

import java.util.List;
import java.util.Optional;

import com.OcProject.PayMyBuddy.model.Transaction;

import com.OcProject.PayMyBuddy.model.TransactionBean;
import com.OcProject.PayMyBuddy.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.OcProject.PayMyBuddy.model.User;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TransactionController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping (path = "/transaction", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public TransactionBean newTransaction(@RequestBody TransactionBean transaction) {
        return transactionService.makeATransaction(transaction);
    }

    @GetMapping(path = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<Transaction> getAllTransactions () {
        return transactionService.getTransactions();
    }

    @GetMapping(path = "/transaction/id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Transaction> getUserByMail(@RequestParam int id) {
        return transactionService.getTransactionById(id);
    }

//    @DeleteMapping (path = "/transaction/id", consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(code = HttpStatus.OK)
//    public void deleteAUSer(@RequestParam int transactionId) {
//        transactionService.deleteById(transactionId);
//    }

}