package com.capgemini.pecunia.ui;
import java.util.Scanner;

import com.capgemini.pecunia.exceptions.InsufficientBalanceException;
import com.capgemini.pecunia.exceptions.InvalidAccountLengthException;
import com.capgemini.pecunia.service.*;
import com.capgemini.pecunia.util.AccountRepository;
public class Main  {
public static void main(String args[]) throws InvalidAccountLengthException, InsufficientBalanceException
{
         new AccountRepository();
	System.out.println("Functionality of debit and credit using slip");
	System.out.println("=============================================\n");	
	System.out.println();
	


 //System.out.println(obj.creditUsingSlip("653578966468",60));
 //System.out.println(obj.debitUsingSlip("767537807532",50));
	
	
	TransactionServiceImpl obj=new TransactionServiceImpl();
	
	int ans=0;
	Scanner sc=new Scanner(System.in);
	do {
		System.out.println("*Press 1 to check your balance.\n");
		System.out.println("*Press 2 to credit amount using slip. \n");
		System.out.println("*Press 3 to debit amount using slip.\n");
		System.out.println("*Press 0 to exit.\n");	
		ans=sc.nextInt();
		switch(ans)
		{
		case 1:
		{
			System.out.println("*\nEnter account number: ");
			String accountNo=sc.next();
			Double x=0.0;
			try
			{
			 x=obj.getBalance(accountNo);
			 System.out.println("Balance of account number "+accountNo+" is "+x);
			}catch(Exception ex){System.out.println(ex.getMessage());}  
			
			break;
		}
		case 2:
		{
			System.out.println("***Credit amount using slip***");
			
			System.out.println("*Enter account number: ");
			String accountNo=sc.next();
		  
			System.out.println("*Enter amount to credit: ");
			Double  accountToCredit=sc.nextDouble();
			String s="";
			try {
			 s=obj.creditUsingSlip(accountNo,accountToCredit);
			 System.out.println(s);
			}catch(Exception ex){System.out.println(ex.getMessage());} 
			
			break;
		}
		case 3:
		{
			System.out.println("***Debit amount using slip***\n\n");
			
			System.out.println("*Enter account number: ");
			String accountNo=sc.next();
		  
			System.out.println("*Enter amount to debit: \n");
			Double  accountToDebit=sc.nextDouble();
			String s="";
			try
			{
				s=obj.debitUsingSlip(accountNo,accountToDebit);
				System.out.println(s);
			}catch(Exception ex){System.out.println(ex.getMessage());} 
			
			break;
		}
		}
		
		
	   }while(ans!=0);
		sc.close();
	
	}
}
