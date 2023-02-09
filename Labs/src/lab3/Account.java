package lab3;

import java.util.ArrayList;

public class Account {
	private static int accountNumbers = 1;
	private String customer;
	private int thisAccountNumber;
	private double balance;
	protected static Bank theBank;
	protected Account otherAccount;
	protected ArrayList<String> transactions = new ArrayList<String>();
	
	public Account(String arg1, double arg2) {
		customer = arg1; balance = arg2;
		thisAccountNumber = accountNumbers++;
	}
	
	public Account(String arg1, double arg2, double arg3) {
		customer = arg1; balance = arg2;
		thisAccountNumber = accountNumbers++;
		otherAccount = new SavingsAccount(arg1, arg3);
		otherAccount.otherAccount = this;
	}
	
	public int getAccountNumber() {
		return thisAccountNumber;
	}
	
	public String getCustomer() {
		return customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public static void setBank(Bank arg1) {
		theBank = arg1;
	}
	
	public SavingsAccount getSavingsAccount() {
		if (otherAccount instanceof SavingsAccount) {
			return (SavingsAccount) otherAccount;
		}
		return null;
	}
	
	public String toString() {
		String result = "\n";
		
		if (this instanceof CurrentAccount) {
			result = "Current Account ";
		} else if (this instanceof SavingsAccount) {
			result = "Savings Account ";
		}
		
		result += "with account number " + thisAccountNumber + ": " + balance + "\n";
		
		for (String t : transactions) {
			result += t + "\n";
		}
		
		return result;
	}
	
}
