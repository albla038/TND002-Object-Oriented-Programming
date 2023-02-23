package lesson5;
import java.util.ArrayList;
import java.util.Collections;

public class Company {
	private ArrayList<Employee> theStaff = new ArrayList<Employee>();
	
	public void addEmployee(Employee arg) {
		theStaff.add(arg);
	}
	
	public void sortEmployee() {
		Collections.sort(theStaff);
	} //where the comparison is made
	
	public String toString() {
		String result = "List:\n";
		
		for (Employee e : theStaff) {
			result += e.toString() + "\n";
		}
		//for(int i = 0; i < theStaff.size(); i++) {
		//	result = result + theStaff.get(i) + "\n";
		//}
		
		return result;
	}
}
