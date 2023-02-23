package lesson5;

public class Programmer extends Employee implements ContractWork {
	private int projectHours;
	
	public Programmer(String arg) {
		super(arg);
	}
	
	public void setBaseHours(int arg) {
		baseHours = arg;
	}
	
	public void setHours(int arg) {
		projectHours = arg;
	}
	
	public double computeBonus() {
		return projectHours*hourlyRate;
	}
}
