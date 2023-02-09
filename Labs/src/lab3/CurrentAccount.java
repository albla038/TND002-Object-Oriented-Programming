package lab3;

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
				arg = Math.abs(arg);
				if(arg <= otherAccount.getBalance()) {
					otherAccount.setBalance(otherAccount.getBalance() - arg);
				} else {
					arg = otherAccount.getBalance();
					otherAccount.setBalance(0);
				}
				setBalance(getBalance() + arg);
				otherAccount.transactions.add("To current account: " + arg);
				transactions.add("From savings account: " + arg);
			}
		}
	}
}
