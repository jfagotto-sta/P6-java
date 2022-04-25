package com.OcProject.PayMyBuddy.services.ServiceInterface;

import java.util.List;

import com.OcProject.PayMyBuddy.model.Transaction;
import com.OcProject.PayMyBuddy.model.User;

public interface ITransactionService {

    public Transaction createANewTransaction (Transaction transaction);
    
    public Transaction findATransaction (long transactionId);
    
    public Transaction updateATransaction (Transaction transaction);
    
    public boolean deleteATransaction(long transactionID);
    
    public List<Transaction> getAllTransaction();
    
    public List<Transaction> getAllTransactionForGivenUser(User user);
}
