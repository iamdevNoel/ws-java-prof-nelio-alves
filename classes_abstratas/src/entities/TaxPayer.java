package entities;

public abstract class TaxPayer {

	private String name;
	private Double annualIncome;
	
	public TaxPayer(String name, Double anualIncome) {
		this.name = name;
		this.annualIncome = anualIncome;
	}
	
	public String getName() {
		return name;
	}
	
	public double getAnnualIncome() {
		return annualIncome;
	}
	
	public abstract double tax();
	
}
