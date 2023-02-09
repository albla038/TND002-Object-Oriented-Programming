package lab3;

import java.util.ArrayList;

public class Bank {
	public final String NAME;
	private ArrayList<Account> theAccounts = new ArrayList<Account>();
	
	public Bank(String name) {
		NAME = name;
		Account.setBank(this);
	}
	
	/*
	 * Find if customer has an account
	 */
	public CurrentAccount searchAccount(String customer) {
		for (Account a : theAccounts) {
			if (a.getCustomer().equals(customer) && a instanceof CurrentAccount) {
				return (CurrentAccount) a;
			}
		}
		
		return null;
	}
	
	public String createAccount(String customer, double currentBalance, double savingsBalance) {
		if (searchAccount(customer) == null) {
			CurrentAccount currentAccount = new CurrentAccount(customer, currentBalance, savingsBalance);
			theAccounts.add(currentAccount);
			theAccounts.add(currentAccount.otherAccount);
			
			return "Current and savings accounts created for " + customer;
		}
		
		return "Account(s) already exist for " + customer;
	}
	
	public String createAccount(String customer, double currentBalance) {
		if (searchAccount(customer) == null) {
			theAccounts.add(new CurrentAccount(customer, currentBalance));
			
			return "Current account created for " + customer;
		}
		
		return "Account(s) already exist for " + customer;
	}
	
	public void currentToSavings(String customer, double balance) {
		searchAccount(customer).savings(balance);
	}
	
	public String checkPerson(String customer) {
		String result = customer + "\n";
		CurrentAccount currentAccount = searchAccount(customer);
		
		if (currentAccount != null) {
			result += currentAccount.toString();
			if (currentAccount.otherAccount != null) {
				result += currentAccount.otherAccount.toString();
			}
		} else {
			result = "Person does not exist";
		}
		
		return result;
	}
	
	public String toString() {
		String result = "Bank: " + NAME + "\n";
		result += "Accounts: " + theAccounts.size() + "\n";
	
		double currentBalanceSum = 0;
		double savingsBalanceSum = 0;
		
		for (Account account : theAccounts) {
			
			if (account instanceof CurrentAccount) {
				currentBalanceSum += account.getBalance();
			} else {
				savingsBalanceSum += account.getBalance();
			}
		}
		
		return result + "Money in current / savings accounts: " + currentBalanceSum + " / " + savingsBalanceSum;
	}
}
