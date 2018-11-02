package main;

public class StartingPoint extends Sequare {

	private Money bonus;
	
	public StartingPoint(String name, Money bonus, int id) {
		super(name, id);
		setBonus(bonus);
	}

	public Money getBonus() {
		return bonus;
	}

	public void setBonus(Money bonus) {
		this.bonus = bonus;
	}

}
