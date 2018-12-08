package main;

public class Area extends Sequare {

	private Money cost;
	private Money rent;
	private Player owner;
	
	public Area(String name, Money cost, Money rent, int id) {
		super(name, id);
		
		setCost(cost);
		setRent(rent);


	}

	public Money getCost() {
		return cost;
	}

	public void setCost(Money cost) {
		this.cost = cost;
	}

	public Money getRent() {
		return rent;
	}

	public void setRent(Money rent) {
		this.rent = rent;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}






	


}
