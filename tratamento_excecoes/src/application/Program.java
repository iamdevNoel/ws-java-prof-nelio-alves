package tratamento_excecoes.src.application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.WithdrawException;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.println("Enter account data");
		System.out.print("Account number: ");
		int accountNumber = input.nextInt();
		input.nextLine(); // Consumindo quebra de linha pendente
		System.out.print("Account holder: ");
		String accountHolder = input.nextLine();
		System.out.print("Initial balance: R$ ");
		double balance = input.nextDouble();
		System.out.print("Withdraw limit: R$ ");
		double withdrawLimit = input.nextDouble();
		Account account = new Account(accountNumber, accountHolder, balance, withdrawLimit);

		System.out.print("\nEnter the amount for a withdraw: ");
		double amount = input.nextDouble();
		try {
			account.withdraw(amount);
		} catch (WithdrawException exception) {
			System.out.println(exception.getMessage());
		}
		System.out.printf("Updated balance: R$ %.2f", account.getBalance());

		input.close();
	}

}
