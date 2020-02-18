package com.capgemini.pecunia.service;
import com.capgemini.pecunia.dao.TransactionDAOImpl;
import com.capgemini.pecunia.dto.Slip;
import com.capgemini.pecunia.exceptions.InsufficientBalanceException;
import com.capgemini.pecunia.exceptions.InvalidAccountException;
import com.capgemini.pecunia.exceptions.InvalidAccountLengthException;


public class TransactionServiceImpl  {
	
	
	TransactionDAOImpl trans=new TransactionDAOImpl();
	public double getBalance(String accountNo)
	{
		double balance=trans.getBalance(accountNo);
		return balance;
		
	}
	public String debitUsingSlip(String accountNo,double amountToDebit) throws InvalidAccountException,InvalidAccountLengthException, InsufficientBalanceException {
	
		TransactionDAOImpl ob=new TransactionDAOImpl();	
		String id=ob.getAccountById(accountNo);
		if(id=="Not available")
		{
			throw new InvalidAccountException("Account number invalid.\n Please try again.\n");
		}
		double balance=ob.getBalance(accountNo);
		
		if(id.length()!=12)
		{
			throw new InvalidAccountLengthException("Please ensure length of account number is 12 characters.");  
			
		}
		else if((balance<200 && balance>200000))
		{
			
			throw new InsufficientBalanceException("Balance should be in range of 200 to 200000.");
		
		}
		else if(amountToDebit>balance)
		{
			throw new InsufficientBalanceException("Insufficient Balance.");
			
		}
		else
		{		
		balance=balance-amountToDebit;
			
		Slip result =trans.detailsList.stream()                   	 
			.filter(x ->id.equals(x.getAccountNo()))   	 
			.findAny()                             	 
			.orElse(null);                             	 
			result.setAmount(balance);
		
			double finalBalance=result.getAmount();
			return "Amount debit done.\n Your current updated balance is "+String.valueOf(finalBalance);
		}
	}

	
	
	public String creditUsingSlip(String accountNo,double amountToCredit) throws InvalidAccountLengthException, InvalidAccountException
	{
            TransactionDAOImpl ob1=new TransactionDAOImpl();
		    String id =ob1.getAccountById(accountNo); 	
		    if(id=="Not available")
			{
				throw new InvalidAccountException("Account number invalid.\n Please try again.\n");
			}
			Double balance =ob1.getBalance(accountNo); 
			if(id.length()!=12)
			{
				throw new InvalidAccountLengthException("Please ensure length of account number is 12 characters.");  
				
			}
			else {
				
			Slip result =trans.detailsList.stream()                   	 
					.filter(x ->id.equals(x.getAccountNo()))   	 
					.findAny()                             	 
					.orElse(null);    
			balance=balance+amountToCredit;
			 result.setAmount(balance);					
			double finalBalance= result.getAmount();
			return "Amount Credit done.\n Your current updated balance is "+String.valueOf(finalBalance);
			}
	}
}

