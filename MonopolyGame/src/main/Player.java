package main;

public class Player {
	private String name;
	private int round;
	private Money budget;
	
	public Player(String name, Money budget) {
		setName(name);
		setRound(0);
		setBudget(budget);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public Money getBudget() {
		return budget;
	}

	public void setBudget(Money budget) {
		this.budget = budget;
	}
	
	public void increaseBudget(Money money) {
		int newBudget = getBudget().getValue() + money.getValue();
		setBudget(new Money(newBudget));
	}
	
	public void decreaseBudget(Money money) {
		
		//TODO: If the user does not have enough money, the transaction cannot be made
		
		int newBudget = getBudget().getValue() - money.getValue();
		setBudget(new Money(newBudget));
	}
}
