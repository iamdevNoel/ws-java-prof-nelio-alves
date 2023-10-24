package heranca_polimorfismo.src.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {
	
	private LocalDate manufactureDate;
	
	public UsedProduct(String name, double price, String date) {
		super(name, price);
		
		//Converte data personalizada (String) para LocalDate padrão ISO
		DateTimeFormatter dTFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.manufactureDate = LocalDate.parse(date, dTFormatter);
	}

	@Override
	public final String priceTag() {
		//Converter LocalDate padrão ISO para data personalizada
		DateTimeFormatter dTFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return name + " (used)"
				+ " R$ " + String.format("%.2f", price)
				+ " (Manufacture date: " + manufactureDate.format(dTFormatter) + ")";
	}
	
}
