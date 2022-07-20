package com.OcProject.PayMyBuddy.utils;

import com.OcProject.PayMyBuddy.model.Transaction;

public class TransactionUtils {

	private final static Double FEES_AMOUNT = 5d;
	
	public static double calculateFess(Transaction transaction) {
		return transaction.getAmount() * FEES_AMOUNT / 100;
	}
	
}
