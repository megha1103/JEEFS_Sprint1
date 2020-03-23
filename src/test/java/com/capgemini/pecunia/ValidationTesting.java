package com.capgemini.pecunia;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.pecunia.dto.Slip;
import com.capgemini.pecunia.exceptions.InsufficientBalanceException;
import com.capgemini.pecunia.exceptions.InvalidAccountException;
import com.capgemini.pecunia.exceptions.InvalidAccountLengthException;
import com.capgemini.pecunia.service.TransactionServiceImpl;
import com.capgemini.pecunia.util.AccountRepository;

class ValidationTesting  extends AccountRepository {

	TransactionServiceImpl ob;
	Slip obj;
	@Test
	void TransactionServiceObjectTest() throws InvalidAccountLengthException {
		ob=new TransactionServiceImpl();	
		obj=new Slip();
		obj.setAccountNo("123453216789");
		obj.setAmount(9000);
		obj.getAccountNo();
		obj.getAmount();
		
	}
	@Test
	void InvalidAccountExceptionThrowTest() 
	{
		String accountNo="123456789123";
		double amountToDebit=500.0;
		Throwable exception=assertThrows(InvalidAccountException.class,()->{
		TransactionServiceImpl s=new TransactionServiceImpl();
			  s.creditUsingSlip(accountNo,amountToDebit) ;
		} 
		    );
		assertEquals("Account number invalid. Please try again.",exception.getMessage());
	}
	
	@Test
	void  InvalidAccountLengthExceptionThrowTest()
	{
		String accountNo="1235326";
		double amountToDebit=500.0;
		Throwable exception=assertThrows(InvalidAccountLengthException.class,()->{
		TransactionServiceImpl s=new TransactionServiceImpl();
			  s.debitUsingSlip(accountNo,amountToDebit) ;
		}
		    );
		assertEquals("Please ensure length of account number is 12 characters.",exception.getMessage());
	}

    @Test
	public void  InsufficientBalanceExceptionThrowTest()
	{
		String accountNo="154750006323";
		double amountToDebit=900.0;
		Throwable exception=assertThrows(InsufficientBalanceException.class,()->{
		TransactionServiceImpl s=new TransactionServiceImpl();
			  s.debitUsingSlip(accountNo,amountToDebit) ;
		}
		    );
		assertEquals("Insufficient Balance.",exception.getMessage());
	}
 
   
    @Test
   	public void  InvalidAccountLengthExceptionThrowTest2()
   	{
   		String accountNo="1547";
   		
   		Throwable exception=assertThrows(InvalidAccountLengthException.class,()->{
   		TransactionServiceImpl s=new TransactionServiceImpl();
   			  s.getBalance(accountNo) ;
   		}
   		    );
   		assertEquals("Please ensure length of account number is 12 characters.",exception.getMessage());
   	}
	@Test
	void InvalidAccountExceptionThrowTest2() 
	{
		String accountNo="000000000111";
		
		Throwable exception=assertThrows(InvalidAccountException.class,()->{
		TransactionServiceImpl s=new TransactionServiceImpl();
		s.getBalance(accountNo) ;
		}
		    );
		assertEquals("Account number invalid. Please try again.",exception.getMessage());
	}
	@Test
	void InvalidAccountExceptionThrowTest3() 
	{
		String accountNo="000111000111";
		double amountToDebit=500.0;
		Throwable exception=assertThrows(InvalidAccountException.class,()->{
		TransactionServiceImpl s=new TransactionServiceImpl();
			  s.debitUsingSlip(accountNo,amountToDebit) ;
		}
		    );
		assertEquals("Account number invalid. Please try again.",exception.getMessage());
	}
	@Test
	void  InvalidAccountLengthExceptionThrowTest3()
	{
		String accountNo="1235326";
		double amountToDebit=500.0;
		Throwable exception=assertThrows(InvalidAccountLengthException.class,()->{
		TransactionServiceImpl s=new TransactionServiceImpl();
			  s.creditUsingSlip(accountNo,amountToDebit) ;
		}
		    );
		assertEquals("Please ensure length of account number is 12 characters.",exception.getMessage());
	}

	


@Test
public void  InsufficientBalanceExceptionThrowTest2()
{
	String accountNo="645382024465";
	double amountToDebit=100;
	Throwable exception=assertThrows(InsufficientBalanceException.class,()->{
	TransactionServiceImpl s=new TransactionServiceImpl();
		  s.debitUsingSlip(accountNo,amountToDebit) ;
	}
	    );
	assertEquals("Amount to debit should be in range of 200 to 200000.",exception.getMessage());
}
}

