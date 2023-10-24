package aplication;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {
	
	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		ArrayList<TaxPayer> taxPayers = new ArrayList<>(); 
		
		System.out.print("Enter the number of tax payers: ");
		int loop = sc.nextInt(); 
		sc.nextLine();	//Consumindo quebra de linha pendente
		
		for (int i = 0; i < loop; i++) {
			System.out.printf("\nTax payer #%d data:\n", i + 1);
			System.out.print("Individual or Company? (i/c) ");
			char typeOfTaxPayer = sc.next().charAt(0);
			sc.nextLine(); //Consumindo quebra de linha pendente;
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();

			TaxPayer taxPayer = null;
			if (typeOfTaxPayer == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				
				taxPayer = new Individual(name, annualIncome, healthExpenditures);
				sc.nextLine(); //Consumindo quebra de linha pendente;
			} else if (typeOfTaxPayer == 'c') {
				System.out.print("Number of Employees: ");
				int numberOfEmployees = sc.nextInt();
				
				taxPayer = new Company(name, annualIncome, numberOfEmployees);
				sc.nextLine(); //Consumindo quebra de linha pendente;
			}
			taxPayers.add(taxPayer);
		}

		System.out.println("\nTAXES PAID:");
		double sum = 0;
		for (TaxPayer taxPayer : taxPayers) {
			System.out.println(taxPayer);
			sum += taxPayer.tax();
		}
		System.out.printf("\nTOTAL TAXES: R$ %.2f", sum);
		
		sc.close();
	}
	
}
