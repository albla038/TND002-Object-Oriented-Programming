package lesson5;

public class ServiceWorker extends Employee implements ContractWork {
	private int travel;
	public static double hourlyRate = Employee.hourlyRate*1.2; 
	//Called hourlyRate of the superclass by static variable of the Employee class
	//Class variables can't be accessed with super
	
	public ServiceWorker(String arg) {
		super(arg);
	}
	
	public void setBaseHours(int arg) {
		baseHours = arg;
	}
	
	public void setHours(int arg) {
		travel = arg;
	}
	
	public double computeBonus() {
		return travel*hourlyRate;
	}
}
