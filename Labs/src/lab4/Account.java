package lab4;

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
	
	// Sets arg to otherAccount (other acc to loan)
	public Account(CurrentAccount arg) {
		otherAccount = arg;
		balance = arg.getBalance();						// Sets loan to negative balance of currentAccount
		thisAccountNumber = arg.getAccountNumber();		
		customer = arg.getCustomer();
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
	
	
	// Adds interest rate to account (depending on account type)
	public void annualChange() {
		if (this instanceof SavingsAccount) {
			balance *= 1.01;
		} else if (this instanceof Loan) {
			balance *= 1.05;
		} else { //Otherwise is a normal account (currentAccount)
			balance -= 10;
			if (balance < 0) { //Create new loan if balance < 0
				theBank.getLoan((CurrentAccount) this); 
				balance = 0;
			}
		}
	}
	
	public String toString() {
		String result = "\n";
		
		if (this instanceof CurrentAccount) {
			result += "Current Account";
		} else if (this instanceof SavingsAccount) {
			result += "Savings Account";
		} else if (this instanceof Loan) {
			result += "Loan";
		}
		
		//result += "with account number " + thisAccountNumber;
		result += ": " + balance + "\n";
		
		for (String t : transactions) {
			result += t + "\n";
		}
		
		return result;
	}
	
}
