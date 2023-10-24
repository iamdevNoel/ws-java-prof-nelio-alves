package entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;

	public Individual(String name, Double annualIncome, Double healthExpenditures) {
		super(name, annualIncome);
		this.healthExpenditures = healthExpenditures;
	}
	
	public double getHealthExpenditures() {
		return healthExpenditures;
	}
	
	public String toString() {
		return getName() + ": R$ " + String.format("%.2f", tax());
	}

	@Override
	public double tax() {
		double tax;
		
		if (getAnnualIncome() < 20000) {
			tax = getAnnualIncome() * 0.15 - getHealthExpenditures() * 0.50;  
		} else {
			tax = getAnnualIncome() * 0.25 - getHealthExpenditures() * 0.50;
		}
		
		return tax;
	}
	
}
