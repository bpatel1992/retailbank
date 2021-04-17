package com.retail.bank.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.retail.bank.domain.Account;
import com.retail.bank.service.AccountService;

public class AccountController {
	
	public static void main(String[] args) throws SQLException {
		int user_choice = 2;
		Scanner s = new Scanner(System.in);
		AccountService service = new AccountService();
		 System.out.println();
	        System.out.println("1) Open a new bank account");
	        System.out.println("2) Deposit to a bank account");
	        System.out.println("3) Withdraw to bank account");
	        System.out.println("4) Print account balance");
	        System.out.println("5) Quit");
	        System.out.println();
	        System.out.print("Enter choice [1-5]: ");
	        user_choice = s.nextInt();
	        switch (user_choice) {
            case 1: 
            	 System.out.println("Enter a account holder name");
                 String cn = s.next();
                 System.out.println("Enter a opening balance");
                 long d = s.nextLong();
                 System.out.println("Enter a type of account saving or current");
                 String type = s.next();
                 System.out.println("Account was created and it has the following number: " + service.openAccount(cn, d, type) );
                 break;
            case 2: 
				System.out.println("Enter a account number");
				int an = s.nextInt();
				System.out.println("Enter a deposit amount");
				long da = s.nextLong();
				service.depositmoney(an, da);
                break;
            case 3:
            	System.out.println("Enter a account number");
				int acc = s.nextInt();
				System.out.println("Enter a withdraw amount");
				long withdraw = s.nextLong();
				if(service.withdrawAmmount(acc, withdraw) == withdraw) {
					System.out.println("You have insufficient balance.");
				} else {
					System.out.println("Successfully withdraw from your account "+acc+" and your current balance is "+service.withdrawAmmount(acc, withdraw));					
				}
                break;
           case 4: 
        	  System.out.println("Enter a account number");
              int anum = s.nextInt();
              Account account =  service.getAccountDetails(anum);
              System.out.println("|Account Holder   |  Account Number  |  Current balance |  Account Type |");
              System.out.println("|-----------------------------------------------------------------------|");
              System.out.println("|" +account.getAccountHolder()+"|"+account.getAccountNumber()+"|"+account.getAccountBalance()+"|"+account.getAccountType()+"|");
              System.out.println("-------------------------------------------------------------------------");
              break;
	        }
	}

}
