package entities;

public class BusinessAccount extends BankAccount {
	
	private Double loanLimit;
	
	public BusinessAccount() {
		super();
	}
	
	public BusinessAccount(String accountNumber, String accountHolder, double initialDeposit, Double loanLimit) {
		super(accountNumber, accountHolder, initialDeposit);
		this.loanLimit = loanLimit;
	}

	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}

	public void loan(Double amount) {
		if (amount <= loanLimit) {
			balance += amount - 10;
		}
	}
	
}
