package com.OcProject.PayMyBuddy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OcProject.PayMyBuddy.dao.DatabaseConnection;
import com.OcProject.PayMyBuddy.model.Transaction;
import com.OcProject.PayMyBuddy.model.User;
import com.OcProject.PayMyBuddy.services.ServiceInterface.ITransactionService;

@Service
public class TransactionService implements ITransactionService {

	@Override
	public Transaction createANewTransaction(Transaction transaction) {
		return (Transaction) DatabaseConnection.persist(transaction);
	}

	@Override
	public Transaction findATransaction(long transactionId) {
		return DatabaseConnection.find(Transaction.class, transactionId);
	}

	@Override
	public Transaction updateATransaction(Transaction transaction) {
		return (Transaction) DatabaseConnection.merge(transaction);
	}

	@Override
	public boolean deleteATransaction(long transactionID) {
		Transaction transaction = new Transaction();
		transaction.setIdTransaction(transactionID);
		return DatabaseConnection.remove(transaction);
	}

	@Override
	public List<Transaction> getAllTransaction() {
		return DatabaseConnection.loadAll(Transaction.class);
	}

	@Override
	public List<Transaction> getAllTransactionForGivenUser(User user) {
		return null;
	}
}