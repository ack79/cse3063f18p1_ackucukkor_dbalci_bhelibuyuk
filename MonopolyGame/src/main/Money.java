package main;

public class Money {
	private int value;

	public Money() {
		this.value = 0;
	}
	
	public Money(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public boolean increase(Money money) {
		this.value = money.value;
		
		return true;
	}
	
	public boolean decrease(Money money) {
		
		if(this.value < money.getValue()) {
			return false;
		}
		
		setValue(this.value - money.getValue());
		return true;
	}
}
