package com.capgemini.pecunia.service;
import com.capgemini.pecunia.dao.TransactionDAO;
import com.capgemini.pecunia.dao.TransactionDAOImpl;
import com.capgemini.pecunia.dto.Slip;
import com.capgemini.pecunia.exceptions.InsufficientBalanceException;
import com.capgemini.pecunia.exceptions.InvalidAccountException;
import com.capgemini.pecunia.exceptions.InvalidAccountLengthException;


public class TransactionServiceImpl  {
	
	
	 
	
	TransactionDAO DaoObject;
	public TransactionServiceImpl()
	{
		DaoObject=new TransactionDAOImpl();
	}
	
	//Function to retrieve balance of a particular account number
	public double getBalance(String accountNo)throws InvalidAccountException, InvalidAccountLengthException
	{
		if(accountNo.length()!=12)
		{
			throw new InvalidAccountLengthException("Please ensure length of account number is 12 characters.");  
			
		}
		double balance=	DaoObject.getBalance(accountNo);
		
		 if(balance==-1.0)
		{
			throw new InvalidAccountException("Account number invalid. Please try again.");
		}
	
		return balance;
		
	}
	//to debit the amount using slip 
	public String debitUsingSlip(String accountNo,double amountToDebit) throws InvalidAccountException,InvalidAccountLengthException, InsufficientBalanceException {
	
		TransactionDAOImpl ob=new TransactionDAOImpl();	
		
		if(accountNo.length()!=12)
		{
			throw new InvalidAccountLengthException("Please ensure length of account number is 12 characters.");  
			
		}
		String id=ob.getAccountById(accountNo);
		double balance=ob.getBalance(accountNo);
		 if(balance==-1.0)
			{
				throw new InvalidAccountException("Account number invalid. Please try again.");
			}
		
		if((amountToDebit<200 && balance>amountToDebit))
		{
			
			throw new InsufficientBalanceException("Amount to debit should be in range of 200 to 200000.");
		
		}
		else if(amountToDebit>balance)
		{
			throw new InsufficientBalanceException("Insufficient Balance.");
			
		}
		else
		{		
		balance=balance-amountToDebit;
			
		Slip result =DaoObject.detailsList().stream()                   	 
			.filter(x ->id.equals(x.getAccountNo()))   	 
			.findAny()                             	 
			.orElse(null);                             	 
			result.setAmount(balance);
		
			double finalBalance=result.getAmount();
			return "Amount debit done.\n Your current updated balance is "+String.valueOf(finalBalance);
		}
	}
 
	//To credit the amount using slip
	
	public String creditUsingSlip(String accountNo,double amountToCredit) throws InvalidAccountLengthException, InvalidAccountException
	{
            TransactionDAOImpl ob1=new TransactionDAOImpl();
		    String id =ob1.getAccountById(accountNo); 	
		    if(accountNo.length()!=12)
			{
				throw new InvalidAccountLengthException("Please ensure length of account number is 12 characters.");  
				
			}
			Double balance =ob1.getBalance(accountNo); 
			 if(balance==-1.0)
				{
					throw new InvalidAccountException("Account number invalid. Please try again.");
				}
			
			else {
				
			Slip result =DaoObject.detailsList().stream()                   	 
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

