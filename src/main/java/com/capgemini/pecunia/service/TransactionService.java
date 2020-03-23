package com.capgemini.pecunia.service;

public interface TransactionService {
	public double getBalance(String Account);	
	public String creditUsingSlip(String accountNo,double amountToCredit);
	public String debitUsingSlip(String accountNo,double amountToDebit);
	
	//updateBalance(Account):Boolean
	
}
