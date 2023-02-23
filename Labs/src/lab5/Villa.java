package lab5;

public class Villa extends Building implements CityProperty{
	private double electricity, heating;
	private int bedrooms;
	
	public Villa(String inAdress, double inPrice, int inSquareMeters, double inElectricity, double inHeating, int inBedrooms) {
		super(inAdress, inPrice, inSquareMeters);
		electricity = inElectricity;
		heating = inHeating;
		bedrooms = inBedrooms;
	}
	
	public int getBedrooms() {
		return bedrooms;
	}
	
	public double maintenance() {
		return electricity+heating;
	}

	public double computePropertyTax() {
		return 20*squareMeters+100*bedrooms;
	}
	
}
