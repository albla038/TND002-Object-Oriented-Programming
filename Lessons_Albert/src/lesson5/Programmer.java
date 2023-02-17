package lesson5;

public class Programmer extends Employee implements ContractWork {
	private int projectHours;
	
	public Programmer(String inName) {
		super(inName);
	}
	
	public void setBaseHours(int hours) {
		baseHours = hours;
	}
	
	public void setHours(int hours) {
		projectHours = hours;
	}
	
	public double computeBonus() {
		return projectHours * hourlyRate;
	}
}
