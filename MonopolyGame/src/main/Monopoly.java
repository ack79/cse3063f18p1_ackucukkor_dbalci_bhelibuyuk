package main;

public class Monopoly {
	private Player[] players;
	private Board board;
	private int order;
	private int numberOfIteration;
	private Die die1;
	private Die die2;
	
	public Monopoly() {
		
		setBoard(new Board());
		
		setNumberOfIteration(0); // default iteration is zero at the beginning.
		
		players = new Player[8];
		
		setDie1(new Die());
		setDie2(new Die());
	}
	
	public void play() {
		
	}
	
	public void play(Player player) {
	
	}
	
	public void addPlayerToGame(Player player, int order) {
			players[order] = player;

	}
	
	public String printState(Player player) {
		String state = "Player: " + player.getName() + "\n";
		state += "Position: " + player.getPosition() + "\n";
		state += "Budget: " + player.getBudget().getValue() + "\n";
		return state;
	}

	public int getNumberOfIteration() {
		return numberOfIteration;
	}

	public void setNumberOfIteration(int numberOfIteration) {
		this.numberOfIteration = numberOfIteration;
	}

	public Die getDie2() {
		return die2;
	}

	public void setDie2(Die die2) {
		this.die2 = die2;
	}

	public Die getDie1() {
		return die1;
	}

	public void setDie1(Die die1) {
		this.die1 = die1;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	

}