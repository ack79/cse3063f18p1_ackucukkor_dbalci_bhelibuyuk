package main;

public class Bank {
	private Money money;
	
	public Bank() {
		setMoney(new Money(100000)); // The bank's initial value is 100000
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}
	
	// The bank's money value is being increased.
	public void deposit(Money money) {
		int newValue = this.money.getValue() + money.getValue();
		this.money.setValue(newValue);
	}
	
	// The bank's money value is being decreased.
	public void withdraw(Money money) {
		
		//TODO: If the bank does not have enough money, the transaction cannot be made
		
		int newValue = this.money.getValue() - money.getValue();
		this.money.setValue(newValue);
	}
}
