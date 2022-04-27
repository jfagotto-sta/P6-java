package com.OcProject.PayMyBuddy.repository.IRepository;

import com.OcProject.PayMyBuddy.model.Transaction;
import com.OcProject.PayMyBuddy.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository {

    public Transaction createANewTransaction (Transaction transaction);

    Transaction findATransaction(long transactionID);

    boolean updateATransaction(Transaction transaction, long transactionID);

    boolean deleteATransaction(int transationId);
}
