package lab5;

public class Apartment extends Building implements CityProperty{
	private double monthlyFee;
	private int bedrooms;
	
	public Apartment(String inAdress, double inPrice, int inSquareMeters, double inMonthlyFee, int inBedrooms) {
		super(inAdress, inPrice, inSquareMeters);
		monthlyFee = inMonthlyFee;
		bedrooms = inBedrooms;
	}
	
	public int getBedrooms() {
		return bedrooms;
	}
	
	public double maintenance() {
		return monthlyFee;
	}

	public double computePropertyTax() {
		return 10*squareMeters+50*bedrooms;
	}
	
}
