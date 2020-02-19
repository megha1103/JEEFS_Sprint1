package com.capgemini.pecunia.dao;

public interface TranactionDAO {

		public String getAccountById(String AccountId);
		public double getBalance(String AccountId);
		
        public Integer generateTransactionId(Integer transaction);       
		}

