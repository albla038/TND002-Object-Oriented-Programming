package lab4;

import java.util.ArrayList;

public class Bank {
	public final String NAME;
	private ArrayList<Account> theAccounts = new ArrayList<Account>();
	private ArrayList<Loan> theLoans = new ArrayList<Loan>();
	
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
			
			for (Loan e : theLoans) {
				if (e.otherAccount == currentAccount) {
					result += e.toString();
				}
			}
			
		} else {
			result = "Person does not exist";
		}
		
		return result;
	}
	
	public void transfer(String arg1, String arg2, double arg3) {
		CurrentAccount sendAcc = searchAccount(arg1);
		CurrentAccount receiveAcc = searchAccount(arg2);
		
		if (sendAcc != null && receiveAcc != null) {
			sendAcc.send(arg3, receiveAcc);
		}
	}
	
	public void getLoan(CurrentAccount arg) {
		theLoans.add(new Loan(arg));
	}
	
	public void cashPayment(String arg1, double arg2) {
		CurrentAccount currentAccount = searchAccount(arg1);
		
		double balance = arg2;
		int counter = 0;

		for (Loan e : theLoans) {
			if (e.otherAccount == currentAccount) {
				balance = e.payOff(balance);
				if (balance > 0) {
					counter++;
				} else {
					break;
				}
			}
		}
		
		//for(int i = 0; i < theLoans.size(); i++) {
		//	if ()
		//}
		
		if (balance > 0) {
			currentAccount.receive("Cash payment", balance);
		}
		
//		ArrayList<Integer> emptyIndices = new ArrayList<Integer>();
//		
//		for (Loan e : theLoans) {
//			if (e.otherAccount == currentAccount) {
//				balance = e.payOff(balance);
//				if (balance > 0) {
//					emptyIndices.add(theLoans.indexOf(e));
//				} else {
//					break;
//				}
//			}
//		}
//		
//		for (int i : emptyIndices) {
//			theLoans.remove(i);
//		}
		
	}
	
	public void computeAnnualChange() {
		for (Account e : theAccounts) {
			e.annualChange();
		}
		
		for (Loan e : theLoans) {
			e.annualChange();
		}
	}
	
	public String toString() {
		String result = "Bank: " + NAME + "\n";
		result += "Accounts: " + theAccounts.size() + "\n";
		result += "Loans: " + theLoans.size() + "\n";
	
		double currentBalanceSum = 0;
		double savingsBalanceSum = 0;
		double loanBalanceSum = 0;
		
		for (Account account : theAccounts) {
			
			if (account instanceof CurrentAccount) {
				currentBalanceSum += account.getBalance();
			} else {
				savingsBalanceSum += account.getBalance();
			}
		}
		
		for (Loan loan : theLoans) {
			loanBalanceSum += loan.getBalance();
		}
		
		return result + "Money in current / savings accounts and debt: "
					+ currentBalanceSum + " / " + savingsBalanceSum + " / " + loanBalanceSum; 
	}
}
