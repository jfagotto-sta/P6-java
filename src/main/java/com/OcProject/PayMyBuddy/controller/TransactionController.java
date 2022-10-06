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
       logger.info("nouvelle transaction effectuée par l'utilsateur" +transaction.getSender() +"d'un montant de "+transaction.getAmount() +"au profit de "+transaction.getRecipient());
        return transactionService.makeATransaction(transaction);
    }

    @GetMapping(path = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
   public Iterable<Transaction> getAllTransactions () {

        logger.info("liste des transactions chargées");
        return transactionService.getTransactions();
    }

    @GetMapping(path = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<TransactionBean> getTransactionsByMail(@RequestParam String email) {
          logger.info("liste des transaction chargée pour l'utilisateur "+email);
            return transactionService.getTransactionList(email);
    }

    @GetMapping(path = "/transaction/id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Transaction> getUserByMail(@RequestParam int id) {
       logger.info("transaction n° "+id + "chargée");
        return transactionService.getTransactionById(id);
    }


}