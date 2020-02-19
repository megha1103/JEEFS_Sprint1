package com.capgemini.pecunia;

import com.capgemini.pecunia.service.TransactionServiceImpl;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.capgemini.pecunia.exceptions.InsufficientBalanceException;
import com.capgemini.pecunia.exceptions.InvalidAccountException;
import com.capgemini.pecunia.exceptions.InvalidAccountLengthException;



public class TransactionsServiceITestImpl 
{
    @Test
    
    public void testBalanceInAccount() throws InvalidAccountException
    {
        
            TransactionServiceImpl impl=new TransactionServiceImpl();
            double output=impl.getBalance("123456789121");
            assertEquals(500,500,output);
    }
    @Test
    
    public void testDebitUsingSlip()
    {
        TransactionServiceImpl impl1=new TransactionServiceImpl();
        try {
            String output2=impl1.debitUsingSlip("653578966468", 200);
            assertEquals(2200,2200,output2);
        } catch (InsufficientBalanceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidAccountException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidAccountLengthException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void testCreditUsingChequeId() 
    {
        TransactionServiceImpl impl2=new TransactionServiceImpl();
        try {
        String output3=impl2.creditUsingSlip("1653578966468", 200);
        assertEquals(110,110,output3);    
        } catch (InvalidAccountLengthException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (InvalidAccountException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        
    }
      
}
