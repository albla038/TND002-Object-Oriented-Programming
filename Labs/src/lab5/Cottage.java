package lab5;

public class Cottage extends Building {
	private double electricity;
	
	public Cottage(String inAdress, double inPrice, int inSquareMeters, double inElectricity) {
		super(inAdress, inPrice, inSquareMeters);
		electricity = inElectricity;
	}

	public double maintenance() {
		return electricity;
	}
}
