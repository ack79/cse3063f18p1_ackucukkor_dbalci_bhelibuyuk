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
}
