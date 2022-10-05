package com.OcProject.PayMyBuddy.ServicesTest;


import com.OcProject.PayMyBuddy.model.Transaction;
import com.OcProject.PayMyBuddy.model.TransactionBean;
import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.repository.TransactionRepository;
import com.OcProject.PayMyBuddy.repository.UserRepository;
import com.OcProject.PayMyBuddy.services.TransactionService;
import com.OcProject.PayMyBuddy.services.UserService;
import com.OcProject.PayMyBuddy.utils.TransactionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class TransactionServicesTest {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    public static TransactionBean createAtransaction(){
        User sender = new User("fag","goto","a@a.net","ab",50f);
        User recipient = new User("jeff","dup","b@b.net","ab",50f);

        TransactionBean transaction = new TransactionBean();
        transaction.setAmount(30f);
        transaction.setSender(sender.getMail());
        transaction.setRecipient(recipient.getMail());
        transaction.setFees(TransactionUtils.calculateFess(transaction.getAmount()));
        return transaction;
    }

    @BeforeEach
    public void initialize() {
        User sender = new User("fag","goto","a@a.net","ab",50f);
        User recipient = new User("jeff","dup","b@b.net","ab",50f);
        User admin = new User("admin","admin","admin@admin.fr","admin",5000d);

      transactionRepository.deleteAll();
       userRepository.deleteAll();
        userService.save(sender);
        userService.save(recipient);
        userService.save(admin);
        transactionService.makeATransaction(TransactionServicesTest.createAtransaction());
    }

    @Test
    public void getTransaction(){
        List<Transaction> listOfTransaction = (List<Transaction>)transactionService.getTransactions();
        assertTrue(listOfTransaction.size()==1);
    }

    @Test
    public void getTransactionWithMail(){
        List<TransactionBean> listOfTransaction = (List<TransactionBean>) transactionService.getTransactionList("a@a.net");
        assertTrue(listOfTransaction.size()==1);
    }

}
