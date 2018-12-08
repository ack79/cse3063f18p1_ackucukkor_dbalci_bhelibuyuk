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
	public Boolean deposit(Money money) {
		int newValue = this.money.getValue() + money.getValue();
		this.money.setValue(newValue);
		
		return true;
	}
	
	// The bank's money value is being decreased.
	public Boolean withdraw(Money money) {
		
		
		if(money.getValue() > getMoney().getValue()) {
			return false;
		}
		
		
		int newValue = this.money.getValue() - money.getValue();
		this.money.setValue(newValue);
		return true;
	}
}
