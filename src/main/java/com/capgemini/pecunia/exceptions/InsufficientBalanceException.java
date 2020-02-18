package com.capgemini.pecunia.exceptions;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception{
	public InsufficientBalanceException(String s){  
	     super(s);  
	    }  
}