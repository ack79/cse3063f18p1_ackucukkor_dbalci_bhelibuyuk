package main;

public class Goverment extends Area {

	private Money tax;
	
	public Goverment(String name, Money cost, Money rent, int id, Money tax) {
		super(name, cost, rent, id);
		setTax(tax);
	}

	public Money getTax() {
		return tax;
	}

	public void setTax(Money tax) {
		this.tax = tax;
	}

}
