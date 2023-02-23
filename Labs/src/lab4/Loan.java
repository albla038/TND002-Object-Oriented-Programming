package lab4;

public class Loan extends Account {
	// Calls single arg. Account constructor. Sets the otherAccount of the loan to currentAccount (arg)
	// Sets loan balance to the negative balance value of currentAccount
	public Loan(CurrentAccount arg) {
		super(arg);
	}
	
	// Pays off loan with balance of arg and adds to transactions list. Returns remaining loan balance. 
	public double payOff(double arg) {
		setBalance(getBalance() + arg);
		transactions.add("Paid off: " + arg);
		return getBalance();
	}
}
