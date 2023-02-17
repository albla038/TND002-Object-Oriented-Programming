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
		
		if (this instanceof Programmer) {
			Programmer p = (Programmer) this;
			result += String.format("Bonus: %6.2f", p.computeBonus());
		}
		
		if (this instanceof ServiceWorker) {
			ServiceWorker s = (ServiceWorker) this;
			result += String.format("Bonus: %6.2f", s.computeBonus());
		}
		return result;
	}
}
