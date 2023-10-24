package entities;

public class SavingsAccount extends BankAccount {

	private Double interestRate;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(String accountNumber, String accountHolder, double initialDeposit, Double interestRate) {
		super(accountNumber, accountHolder, initialDeposit);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void updateBalance() {
		balance *= 1 + interestRate / 100;
	}
	
	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}
}
