package com.capgemini.pecunia.dao;
import java.util.List;
import java.util.Random;
import com.capgemini.pecunia.dto.*;
import com.capgemini.pecunia.util.*;
public class TransactionDAOImpl   implements TranactionDAO 
{
	public List<Slip> detailsList = AccountRepository.getDetailsList();
    public String getAccountById(String accountNo) {
     
            String id = detailsList.stream()
                     .filter(x -> accountNo.equals(x.getAccountNo()))
                     .map(Slip::getAccountNo)                     
                     .findAny()
                     .orElse("Not available");
              return id;
    }
    public double getBalance(String AccountId)
    {
    	  Double balance= detailsList.stream()
                  .filter(x -> AccountId.equals(x.getAccountNo()))
                  .map(Slip::getAmount)                     
                  .findAny()
                  .orElse(0.0);
           return balance;            
    }

	public Integer generateTransactionId(Integer accountNo) 
	{
		Random rand=new Random();
		int tid=rand.nextInt(999);
		return tid;
	}
	

}