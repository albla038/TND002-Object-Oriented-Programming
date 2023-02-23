package lab4;

public class CurrentAccount extends Account {
	public CurrentAccount(String customer, double balance) {
		super(customer, balance);
		otherAccount = null;
	}
	
	public CurrentAccount(String customer, double currentBalance, double savingsBalance) {
		super(customer, currentBalance, savingsBalance);
	}
	
	public void savings(double arg) {
		
		if (otherAccount != null) {
			
			if (arg > 0) {
				if(arg <= getBalance()) {
					setBalance(getBalance() - arg);
				} else {
					arg = getBalance();
					setBalance(0);
				}
				otherAccount.setBalance(otherAccount.getBalance() + arg);
				transactions.add("To savings account: " + arg);
				otherAccount.transactions.add("From current account: " + arg);
			} else if (arg <= 0) {
				if (otherAccount.getBalance() != 0) { //added
				arg = Math.abs(arg);
				if(arg < otherAccount.getBalance()) {
					otherAccount.setBalance(otherAccount.getBalance() - arg);
				} else {
					arg = otherAccount.getBalance(); //problem if otherAccount.getBalance() is already 0
					otherAccount.setBalance(0);
				}
				setBalance(getBalance() + arg);
				otherAccount.transactions.add("To current account: " + arg);
				transactions.add("From savings account: " + arg);
				} //added
			}
		}
	}
	
	// Send money from calling object to arg2, (arg1 = amount)
	public void send(double arg1, CurrentAccount arg2) {
		transactions.add("Sent to account of " + arg2.getCustomer() + ": " + arg1);
		setBalance(getBalance() - arg1);
		arg2.receive(getCustomer(), arg1);			// Send money
		if (getBalance() < 0) {						// If amount sent is larger than balance of currentAccount
			savings(getBalance());					// Retrieve money from savings account
			if (getBalance() < 0) {					// Take loan if not enough savings
				theBank.getLoan(this);
				transactions.add("Covered by a loan: " + Math.abs(getBalance()));
				setBalance(0);
			}
		}
	}
	
	public void receive(String arg1, double arg2) {
		setBalance(getBalance() + arg2);				// Increment value with arg2
		if(arg1.equals("Cash payment")) {
			transactions.add("Cash payment: " + arg2);
		} else {
			transactions.add("Received from account of " + arg1 + ": " + arg2);
		}
	}
}
