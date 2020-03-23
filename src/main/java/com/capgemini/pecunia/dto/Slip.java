package com.capgemini.pecunia.dto;

import com.capgemini.pecunia.exceptions.InvalidAccountLengthException;

public class Slip {
private String accountNo;
private double amount;
private Integer transactionId;
public Slip()
{
	super();
}
public Slip(String accountNo,double amount)
{
	this.accountNo=accountNo;
	this.amount=amount;
}
public String getAccountNo() {
	return accountNo;
}
public void setAccountNo(String accountNo) throws InvalidAccountLengthException {
	
	this.accountNo = accountNo;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}

public Integer getTransactionId() {
	return transactionId;
}
public void setTransactionId(Integer transactionId) {
	this.transactionId = transactionId;
}
@Override
public String toString() {

    return "Account No "+ this.accountNo +" |amount "+ this.amount;
}

}
