package main;

public class Goverment extends Area {

	private Money tax;
	
	public Goverment(String name, Money cost, Money rent, Money priceForBuildHouses, int id) {
		super(name, cost, rent, priceForBuildHouses, id);
		
	}

	public Money getTax() {
		return tax;
	}

	public void setTax(Money tax) {
		this.tax = tax;
	}

}
