package lesson5;

public class ServiceWorker extends Employee implements ContractWork {
	private int travel;
	public static double hourlyRate = Employee.hourlyRate * 1.2;
	
	public ServiceWorker(String inName) {
		super(inName);
	}
	
	public void setBaseHours(int hours) {
		baseHours = hours;
	}
	
	public void setHours(int hours) {
		travel = hours;
	}
	
	public double computeBonus() {
		return travel * hourlyRate;
	}
}
