package entities;

public class Company extends TaxPayer {

	private Integer numberOfEmployees;

	public Company(String name, Double annualIncome, Integer numberOfEmployees) {
		super(name, annualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}
	
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}
	
	public String toString() {
		return getName() + ": R$ " + String.format("%.2f", tax());
	}

	@Override
	public double tax() {
		double tax;
		
		if (getNumberOfEmployees() > 10) {
			tax = getAnnualIncome() * 0.14;
		} else {
			tax = getAnnualIncome() * 0.16;
		}
		
		return tax;
	}
	
}
