package main;

public class Area extends Sequare {

	private Money cost;
	private Money rent;
	private Money priceForBuildHouses;
	private int buildedHouses;
	
	public Area(String name, Money cost, Money rent, Money priceForBuildHouses) {
		super(name);
		
		setCost(cost);
		setRent(rent);
		setPriceForBuildHouses(priceForBuildHouses);
		setBuildedHouses(0);  //default builded houses is zero on an area

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

	public Money getPriceForBuildHouses() {
		return priceForBuildHouses;
	}

	public void setPriceForBuildHouses(Money priceForBuildHouses) {
		this.priceForBuildHouses = priceForBuildHouses;
	}

	public int getBuildedHouses() {
		return buildedHouses;
	}

	public void setBuildedHouses(int buildedHouses) {
		this.buildedHouses = buildedHouses;
	}
	
	public int buildHouse(Player player) {
		
		//TODO: functions details
		
		return 1;
	}

}
