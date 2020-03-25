package com.capgemini.pecunia.dao;

import java.util.List;

import com.capgemini.pecunia.dto.*;
import com.capgemini.pecunia.util.*;
public class TransactionDAOImpl implements TransactionDAO 
{
	    
	 ///constructor
	public TransactionDAOImpl()
	{
		new AccountRepository();
	}
	
	List<Slip> details=AccountRepository.getDetailsList();
	public List<Slip> detailsList() {
		// TODO Auto-generated method stub
		return details;
		}
	
	// This function is used to check and retrieve id from accountNo
    public String getAccountById(String accountNo) {
     
            String id = detailsList().stream()
                     .filter(x -> accountNo.equals(x.getAccountNo()))
                     .map(Slip::getAccountNo)                     
                     .findAny()
                     .orElse("Not available");
              return id;
    }
   // This function is used to check and retrieve balance from accountId
    public double getBalance(String AccountId)
    {
    	  Double balance= detailsList().stream()
                  .filter(x -> AccountId.equals(x.getAccountNo()))
                  .map(Slip::getAmount)                     
                  .findAny()
                  .orElse(-1.0);
           return balance;            
    }
  //This function is used to generate transactionId
/*	public Integer generateTransactionId(Integer accountNo) 
	{
		Random rand=new Random();
		int tid=rand.nextInt(999);
		return tid;
	}
	
*/

}