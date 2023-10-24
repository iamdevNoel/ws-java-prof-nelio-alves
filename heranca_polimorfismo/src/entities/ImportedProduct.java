package heranca_polimorfismo.src.entities;

public class ImportedProduct extends Product {
	
	private Double customsFee;
	
	public ImportedProduct(String name, double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public double totalPrice() {
		return price + customsFee;
	}
	
	@Override
	public String priceTag() {
		return name 
				+ " R$ " + String.format("%.2f", totalPrice())
				+ " (Customs fee: R$ " + String.format("%.2f", customsFee) + ")"; 
	}

}
