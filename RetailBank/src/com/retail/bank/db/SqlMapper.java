package com.retail.bank.db;

public interface SqlMapper {
	
	public static final String GET_ACCOUNT_DETAILS="SELECT account_number,account_balance,deposit,type FROM account WHERE account_number=?";
	public static final String DEPOSIT_BALANCE="UPDATE account SET account_balance=? WHERE account_number=?";
	public static final String MANAGE_ACCOUNT_HISTORY="INSERT INTO account_history (account_number,deposit,deposit_date,withdraw,withdraw_date) VALUES (?,?,?,?,?)";
	public static final String CREATE_NEW_ACCOUNT="INSERT INTO account(account_number,account_name,balance,created_date,updated_date,account_type) VALUES (?,?,?,?,?,?)";

}
