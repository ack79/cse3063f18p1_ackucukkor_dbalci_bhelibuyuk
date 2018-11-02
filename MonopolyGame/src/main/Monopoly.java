package main;

public class Monopoly {
	private Player[] players;
	private Board board;
	private Player currentPlayer;
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
	
	public void play(Player player) {
	}
	
	public void addPlayerToGame(Player player, int order) {
		//TODO funtion's details.
		players[order] = player;

	}
	
	public void printState(Player player) {
		//TODO funtion's details.
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

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
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
	

}