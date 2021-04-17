package com.retail.bank.domain;

import java.sql.Date;

public class Account {

	private String accountHolder;
	private long accountNumber;
	private long accountBalance;
	private long deposit;
	private long withdraw;
	private String accountType;
	private Date depositDate;
	private Date withdrawDate;
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}
	public long getDeposit() {
		return deposit;
	}
	public void setDeposit(long deposit) {
		this.deposit = deposit;
	}
	public long getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(long withdraw) {
		this.withdraw = withdraw;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Date getDepositDate() {
		return depositDate;
	}
	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}
	public Date getWithdrawDate() {
		return withdrawDate;
	}
	public void setWithdrawDate(Date withdrawDate) {
		this.withdrawDate = withdrawDate;
	}
	
	
	@Override
	public String toString() {
		return "Account [accountHolder=" + accountHolder + ", accountNumber=" + accountNumber + ", accountBalance="
				+ accountBalance + ", deposit=" + deposit + ", withdraw=" + withdraw + ", accountType=" + accountType
				+ ", depositDate=" + depositDate + ", withdrawDate=" + withdrawDate + "]";
	}
	
	
}
