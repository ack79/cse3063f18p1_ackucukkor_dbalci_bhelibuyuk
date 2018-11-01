package main;

public class StartingPoint extends Sequare {

	private Money bonus;
	
	public StartingPoint(String name, Money bonus) {
		super(name);
		setBonus(bonus);
	}

	public Money getBonus() {
		return bonus;
	}

	public void setBonus(Money bonus) {
		this.bonus = bonus;
	}

}
