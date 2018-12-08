package main;

public class Player {
	private String name;
	private Money budget;
	private int position;
	
	public Player(String name, Money budget) {
		setName(name);
		setBudget(budget);
		setPosition(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Money getBudget() {
		return budget;
	}

	public void setBudget(Money budget) {
		this.budget = budget;
	}
	
	public boolean increaseBudget(Money money) {
		int newBudget = getBudget().getValue() + money.getValue();
		setBudget(new Money(newBudget));
		return true;
	}
	
	public boolean decreaseBudget(Money money) {
		
		if(budget.getValue() < money.getValue()) {
			setBudget(new Money(0));
			return false;
		}
		
		//TODO: If the user does not have enough money, the transaction cannot be made
		
		int newBudget = getBudget().getValue() - money.getValue();
		setBudget(new Money(newBudget));
		
		return true;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}
