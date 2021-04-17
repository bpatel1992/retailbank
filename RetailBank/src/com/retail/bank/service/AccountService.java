package com.retail.bank.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

import com.retail.bank.db.DatabaseConnection;
import com.retail.bank.db.SqlMapper;
import com.retail.bank.domain.Account;
import com.retail.bank.domain.AccountHistory;
import com.retail.bank.util.DateUtil;

public class AccountService {
	
	public long openAccount(String accountHolder,long initialAmmount,String accountType) throws SQLException {
		long accountNumber = this.generateAccountNumber();
		Connection connection = null;
		try {
		connection = DatabaseConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(SqlMapper.CREATE_NEW_ACCOUNT);
		statement.setLong(1, accountNumber);
		statement.setString(2, accountHolder);
		statement.setLong(3, initialAmmount);
		statement.setDate(4, DateUtil.getCurrentDate());
		statement.setDate(5, DateUtil.getCurrentDate());
		statement.setString(6, accountType);
	    int result = statement.executeUpdate();
	    if(result != 0) {
	       System.out.println("New account created");
	    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	return accountNumber;
		
	}
	
	public long generateAccountNumber() {
		 return ThreadLocalRandom.current().nextLong();
	}
	
	public Account getAccountDetails(long accountNumber) throws SQLException {
		Account account = null;
		Connection connection = null;
		try {
		connection = DatabaseConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(SqlMapper.GET_ACCOUNT_DETAILS);
		statement.setLong(1, accountNumber);
	    ResultSet result = statement.executeQuery();
	    while(result.next()) {
	    	account = new Account();
	    	account.setAccountNumber(accountNumber);
	    	account.setAccountNumber(result.getLong(1));
	    	account.setAccountBalance(result.getLong(2));
	    	account.setDeposit(result.getLong(3));
	    	account.setAccountType(result.getString(4));
	    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return account;
	}
	
	
	public long depositmoney(long accountNumber,long depositAmmount) throws SQLException {
		Connection connection = null;
		long totalBalance = 0;
		try {
		connection = DatabaseConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(SqlMapper.GET_ACCOUNT_DETAILS);
		statement.setLong(1, accountNumber);
	    ResultSet result = statement.executeQuery();
	    while(result.next()) {
	    	totalBalance = result.getLong(4);
	    }
	    PreparedStatement depositAmt = connection.prepareStatement(SqlMapper.DEPOSIT_BALANCE);
	    depositAmt.setLong(1, totalBalance+depositAmmount);
	    depositAmt.setLong(2, accountNumber);
	    int i =  depositAmt.executeUpdate();
	    if(i != 0) {
	    	totalBalance=totalBalance+depositAmmount;
	    	AccountHistory history = new AccountHistory();
	    	history.setAccount_number(accountNumber);
	    	history.setDeposit(depositAmmount);
	    	history.setDepositDate(DateUtil.getCurrentDate());
	    	history.setWithdraw(0);
	    	history.setWithdrawDate(null);
	    	this.manageHistory(history);
	    	
	    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return totalBalance;
	}
	
	public long withdrawAmmount(long accountNumber,long withdrawAmount) throws SQLException {
		Connection connection = null;
		long totalBalance = 0;
		try {
		connection = DatabaseConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(SqlMapper.GET_ACCOUNT_DETAILS);
		statement.setLong(1, accountNumber);
	    ResultSet result = statement.executeQuery();
	    while(result.next()) {
	    	totalBalance = result.getLong(2);
	    }
	    if(withdrawAmount > totalBalance) {
	    	totalBalance = withdrawAmount;
	    } else {
	    	PreparedStatement withdraw = connection.prepareStatement(SqlMapper.DEPOSIT_BALANCE);
		    withdraw.setLong(1, totalBalance-withdrawAmount);
		    withdraw.setLong(2, accountNumber);
		    int i =  withdraw.executeUpdate();
		    if(i != 0) {
		    	AccountHistory history = new AccountHistory();
		    	history.setAccount_number(accountNumber);
		    	history.setDeposit(0);
		    	history.setDepositDate(null);
		    	history.setWithdraw(withdrawAmount);
		    	history.setWithdrawDate(DateUtil.getCurrentDate());
		    	this.manageHistory(history);
		    	totalBalance=totalBalance-withdrawAmount;
		    }
	    }
	    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return totalBalance;
	}

	
	public String manageHistory(AccountHistory history) throws SQLException {
		String status = "";
		Connection connection = null;
		try {
		connection = DatabaseConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(SqlMapper.MANAGE_ACCOUNT_HISTORY);
		statement.setLong(1, history.getAccount_number());
		statement.setLong(2, history.getDeposit());
		statement.setDate(3, history.getDepositDate());
		statement.setLong(4, history.getWithdraw());
		statement.setDate(5, history.getWithdrawDate());
	    int i = statement.executeUpdate();
	    if(i !=0 ) {
	    	status = "Error";
	    } else {
	    	status = "Success";
	    }
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
			connection.close();
		}
		return status;
	}
	
}
