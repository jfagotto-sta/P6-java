package com.OcProject.PayMyBuddy.utils;

import com.OcProject.PayMyBuddy.model.Transaction;

public class TransactionUtils {

	private final static Double FEES_AMOUNT = 0.05;
	
	public static double calculateFess(double amount) {

		return amount * FEES_AMOUNT;
	}
	
}
