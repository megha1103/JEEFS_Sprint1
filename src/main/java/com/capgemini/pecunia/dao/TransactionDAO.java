package com.capgemini.pecunia.dao;

import java.util.List;

import com.capgemini.pecunia.dto.Slip;

 
 
public interface TransactionDAO {
    	public List<Slip> detailsList();
		public String getAccountById(String AccountId);
		public double getBalance(String AccountId);
		//updateBalance(Account):boolean;
		//generateTransactionId(Transaction):Boolean;
		}

