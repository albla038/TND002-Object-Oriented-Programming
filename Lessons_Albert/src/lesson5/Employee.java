package lesson5;

public abstract class Employee implements Comparable<Employee> {
	private String name;
	public static double hourlyRate = 130;
	protected int baseHours;
	
	public Employee(String inName) {
		name = inName;
	}
	
	public abstract void setBaseHours(int hours);
	
	public int compareTo(Employee arg) {
		return name.compareTo(arg.name);
	}
	
	public String toString() {
		String result = String.format("Name: %17s, "
				+ "Base salary: %6.2f, ", name, hourlyRate * baseHours);
		
		if (this instanceof ContractWork) {
			ContractWork temp = (ContractWork) this;
			result += String.format("Bonus: %6.2f", temp.computeBonus());
		}
		
		return result;
	}
}
