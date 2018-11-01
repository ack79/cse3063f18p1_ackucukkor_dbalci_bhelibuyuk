package main;

public class Prison extends Sequare {

	private Money bail;

	public Prison(String name, Money money) {
		super(name);
		setBail(money);
		
	}

	public Money getBail() {
		return bail;
	}

	public void setBail(Money bail) {
		this.bail = bail;
	}

}
