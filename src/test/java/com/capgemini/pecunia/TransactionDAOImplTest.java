package com.capgemini.pecunia;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.pecunia.dao.TransactionDAOImpl;
import com.capgemini.pecunia.util.AccountRepository;

public class TransactionDAOImplTest extends AccountRepository
{
    @Test
    public void testAccountNo()
    {
        
            TransactionDAOImpl impl=new TransactionDAOImpl();
            String output=impl.getAccountById("653578966468");
            assertEquals("653578966468",output);
    }
   
  
    @Test
   
    public void testgetBalance()
    {
        TransactionDAOImpl impl3=new TransactionDAOImpl();
        double output3=impl3.getBalance("653578966468");
        assertEquals(2000,2000,output3);
    }
}
