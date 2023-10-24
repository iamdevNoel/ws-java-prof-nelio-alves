package heranca_polimorfismo.src.entities;

public class Product {

	protected String name;
	protected Double price;
	
	public Product() {
	}
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String priceTag() {
		return name	+ " R$ " + String.format("%.2f", price);
	}
	
}
