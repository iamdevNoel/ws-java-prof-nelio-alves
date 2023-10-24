package heranca_polimorfismo.src.application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import heranca_polimorfismo.src.entities.ImportedProduct;
import heranca_polimorfismo.src.entities.Product;
import heranca_polimorfismo.src.entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		ArrayList<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int loop = sc.nextInt();
		sc.nextLine(); //Consumindo quebra de linha pendente
		
		Product product = new Product();
		for (int i = 0; i < loop; i++) {
			System.out.printf("Product #%d data:", i + 1);
			System.out.print("\nCommon, used or imported? (c/u/i) ");
			char typeOfProduct = sc.next().charAt(0);
			sc.nextLine(); //Consumindo quebra de linha pendente
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			sc.nextLine(); //Consumindo quebra de linha pendente
			
			if (typeOfProduct == 'c') {
				product = new Product(name, price);
			} else if (typeOfProduct == 'u') {
				System.out.print("Manufacture date (dd/mm/yyyy): ");
				String date = sc.nextLine();
				product = (Product) new UsedProduct(name, price, date);
			} else if (typeOfProduct == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				product = (Product) new ImportedProduct(name, price, customsFee);
			}
			
			products.add(product);
		}
		
		
		System.out.println("\nPRICE TAGS:");
		for (Product p : products) {
			System.out.println(p.priceTag());
		}
		
		sc.close();
		
	}

}
