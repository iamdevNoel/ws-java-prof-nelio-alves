package entities;

public class BankAccount {
	private String number;
	private String holder;
	protected Double balance;
	private static final double FEE = 5.00;

	public BankAccount() {
	}
 	
	public BankAccount(String accountNumber, String accountHolder, double initialDeposit) {
		this.number = accountNumber;
		this.holder = accountHolder;
		deposit(initialDeposit);
	}

	public BankAccount(String accountNumber, String accountHolder) {
		this.number = accountNumber;
		this.holder = accountHolder;
	}

	public String getAccountHolder() {
		return holder;
	}

	public String getAccountNumber() {
		return number;
	}
	
	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		balance -= amount + FEE;
	}

	public String toString() {
		return "Account " + number + ", Holder: " + holder + ", Balance: $ " + String.format("%.2f", balance);
	}
}
