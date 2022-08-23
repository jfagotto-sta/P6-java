package com.OcProject.PayMyBuddy.utils;



public class TransactionUtils {



	private final static Double FEES_AMOUNT = 0.05;

	public static double calculateFess(double amount) {

		double fees = amount * FEES_AMOUNT;

		return fees;
	}

//	public static boolean applyFees(double amount) {
//
//	User admin = userService.findByMail("admin@admin.fr");
//	admin.setBalance((admin.getBalance())+(amount * FEES_AMOUNT));
//
//		return true;
//	}

}
