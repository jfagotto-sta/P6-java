package com.OcProject.PayMyBuddy.utils;



public class TransactionUtils {


	private final static Double FEES_AMOUNT = 0.05;


	public static double calculateFess(double amount) {
		double fees = amount * FEES_AMOUNT;
		return fees;
	}



}
