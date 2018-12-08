package main;

import java.util.Random;

public class Luck extends Sequare {

	private int luck;
	
	public Luck(String name, int id) {
		super(name, id);
		luck = 0;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}
	
	public Money goodLuck() {
		Random rand = new Random();
		return new Money(rand.nextInt(100) + 1);
	}
	public Money badLuck() {
		Random rand = new Random();
		return new Money(-(rand.nextInt(100) + 1));
	}
	public Money getLuckCard() {
		Random rand = new Random();
		setLuck(rand.nextInt(1) + 1);
		
		if(getLuck() % 2 == 0) {
			return goodLuck();
		}
		else {
			return badLuck();
		}
		
	}
	
}
