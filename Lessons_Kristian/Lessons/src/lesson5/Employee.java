package lesson5;

public abstract class Employee implements Comparable<Employee> {
	private String name;
	public static double hourlyRate = 150.0;
	protected int baseHours;
	
	//italics means abstract
	
	public Employee(String arg) {
		name = arg;
	}
	
	public abstract void setBaseHours(int arg);
	
	public int compareTo(Employee arg) {
		return name.compareTo(arg.name); //subclasses of Employee, can read each others private variables
	} //were the things you want to compare are
	
	public String toString() {
		String result = String.format("Name: %17s, Base Salary: %6.2f", name, (baseHours*hourlyRate));
		
//		if (this instanceof ContractWork) {
//			Contractwork temp = (ContractWork) this
//			temp.
//		}
		
		//Can cast to interface, access classes that have it implemented
		
		if(!(this instanceof SalesPerson)) {
			double bonus = 0.0;
			
			if(this instanceof Programmer) {
				Programmer programmer = (Programmer)this;
				bonus = programmer.computeBonus();
			} else if (this instanceof ServiceWorker) {
				ServiceWorker serviceWorker = (ServiceWorker)this;
				bonus = serviceWorker.computeBonus();
			}
			
			result += String.format(", Bonus: %6.2f", bonus);
		}
		
		return result;
	}
}
