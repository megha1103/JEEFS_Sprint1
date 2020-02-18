package com.capgemini.pecunia.service;

public interface TransactionService {
	public double getBalance(String Account);
	public boolean updateBalance(String Account);
	public Integer creditUsingCheque(Integer Cheque);
	public Integer debitUsingCheque(Integer Cheque,double amountToDebit);
}
