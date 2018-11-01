package main;

public class Die {
	private int value;
	
	public Die() {
		//
	}

	public int getValue() {
		//TODO: A value cannot be returned if it has not been discarded after the dice has been created.
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void roll() {
		int random = (int )(Math.random() * 6 + 1); // Genareting random number between 1 and 6.
		setValue(random);
	}
}
