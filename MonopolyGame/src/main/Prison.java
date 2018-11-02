package main;

public class Prison extends Sequare {

	private Money bail;

	public Prison(String name, Money money, int id) {
		super(name,id);
		setBail(money);
		
	}

	public Money getBail() {
		return bail;
	}

	public void setBail(Money bail) {
		this.bail = bail;
	}

}
