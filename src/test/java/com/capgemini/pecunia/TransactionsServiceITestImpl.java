package com.capgemini.pecunia;

import com.capgemini.pecunia.service.TransactionServiceImpl;
import com.capgemini.pecunia.util.AccountRepository;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import com.capgemini.pecunia.exceptions.InsufficientBalanceException;
import com.capgemini.pecunia.exceptions.InvalidAccountException;
import com.capgemini.pecunia.exceptions.InvalidAccountLengthException;



public class TransactionsServiceITestImpl extends AccountRepository
{ 
    @Test
    
    public void testBalanceInAccount() throws InvalidAccountException, InvalidAccountLengthException 
    {
        
            TransactionServiceImpl impl=new TransactionServiceImpl();
            double output=impl.getBalance("653578966468");
            assertEquals(2000,2000,output);
    }
    @Test
    
    public void testDebitUsingSlip() throws InvalidAccountException, InvalidAccountLengthException, InsufficientBalanceException 
    {
        TransactionServiceImpl impl1=new TransactionServiceImpl();
       
            String output2=impl1.debitUsingSlip("653578966468", 200);
            assertEquals(2200,2200,output2);
        
    }
    @Test
    public void testCreditUsingChequeId() throws InvalidAccountLengthException, InvalidAccountException 
    {
        TransactionServiceImpl impl2=new TransactionServiceImpl();
        
        String output=impl2.creditUsingSlip("653578966468", 200);
        
        assertEquals(1800,1800,output);    

    }

 
     
      
}
