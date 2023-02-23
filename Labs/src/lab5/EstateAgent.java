package lab5;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class EstateAgent {
	
	public static final int ALLBUILDINGS = 1, CITYBUILDINGS = 2, COTTAGES = 3;
	public final String NAME;
	
	private ArrayList<Building> theBuildings = new ArrayList<Building>();
	private ArrayList<CityProperty> theCityBuildings = new ArrayList<CityProperty>();
	private ArrayList<Cottage> theCottages = new ArrayList<Cottage>();
	
	public EstateAgent(String inName) {
		NAME = inName;
	}
	
	public String addBuilding(Building arg) {
		theBuildings.add(arg);
		
		if (arg instanceof Cottage) {
			theCottages.add((Cottage) arg);
			return "Added cottage";
		} else {
			theCityBuildings.add((CityProperty) arg);
			return "Added city building";
		}
	}
	
	public String sort(int arg) {
		String result = "Not sorted"; 
		
		String[] options = {"Price (1)", "Area (2)"};
		int option = JOptionPane.showOptionDialog(null, "Sort by price (1) or area (2)?", "Choose option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) + 1;
		//int option = Integer.valueOf(JOptionPane.showInputDialog("Sorting by price (1) or area (2)?"));
		
		if (option == 1 || option == 2) {
			Building.selection = option;
			
			if (arg == ALLBUILDINGS) {
				Collections.sort(theBuildings);
				updateLists();
			} else if (arg == COTTAGES) {
				Collections.sort(theCottages);
				updateLists(COTTAGES);
			} else if (arg == CITYBUILDINGS) {
				ArrayList<Building> temp = new ArrayList<Building>();
				
				for (CityProperty e : theCityBuildings) {
					temp.add((Building) e);
				}
				
				Collections.sort(temp);
				theCityBuildings.clear();
				
				for (Building e : temp) {
					theCityBuildings.add((CityProperty) e);
				}
				
				updateLists(CITYBUILDINGS);
			}
			
			if (option == 1) result = "Sorted by price";
			else result = "Sorted by area";
		}
		
		return result + "\n";
	}
	
	public void updateLists() { 
		Collections.sort(theCottages);
		
		// Sorts theCityBuildings using a deep copy
		ArrayList<Building> temp = new ArrayList<Building>();
		for (CityProperty e : theCityBuildings) {
			temp.add((Building) e);
		}
		
		Collections.sort(temp);
		theCityBuildings.clear();
		
		for (Building e : temp) {
			theCityBuildings.add((CityProperty) e);
		}
	}
	
	public void updateLists(int arg) {
		
		int counter = 0;
		
		if (arg == COTTAGES) { // Loop over allBuildings, sort only Cottages by order of theCottages
			for (int i = 0; i < theBuildings.size(); i++) {
				if (theBuildings.get(i) instanceof Cottage) {
					theBuildings.set(i, theCottages.get(counter));
					counter++;
				}
			}
		}
		if (arg == CITYBUILDINGS) { // Loop over allBuildings, sort only CityBuildings by order of theCityBuildings
			for (int i = 0; i < theBuildings.size(); i++) {
				if (theBuildings.get(i) instanceof CityProperty) {
					theBuildings.set(i, (Building) theCityBuildings.get(counter));
					counter++;
				}
			}
		}
	}
	
	public String toString() {
		String result = "Estate agent: " + NAME +" \n\nAll buildings \n";
		
		for (Building e : theBuildings) {
			result += e.toString();
		}
		
		result += "\n\nCottages\n";
		for (Cottage e : theCottages) {
			result += e.toString();
		}
		
		result += "\n\nVillas and apartments\n";
		for (CityProperty e : theCityBuildings) {
			result += e.toString();
		}
		
		return result;
	}
}
