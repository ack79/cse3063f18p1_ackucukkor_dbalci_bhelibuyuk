package main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
				
		setDie1(new Die());
		setDie2(new Die());
	}
	
	public void play() throws IOException {
		
		File file = new File("src/main/sequare.txt");
		getBoard().installBoard(file);
		
		Scanner scan = new Scanner(System.in);
		System.out.print("How many players do you want (at least 2 player): ");
		int playerNumber = scan.nextInt();
		
		players = new Player[playerNumber];
		
		scan.nextLine();

		for(int i = 0; i < playerNumber; i++) {
			System.out.print("What is the name of the "+ (i+1) +" player: ");
			String name = scan.nextLine();
			addPlayerToGame(new Player(name,new Money(14000)),i);
		}
		scan.close();
		
		int i = 1;
		while(true) {
			
			System.out.println("Iteration: " + i + "\n");
			
			for(int j=0; j < players.length; j++) {
				
				System.out.println(players[j].getName() + " is playing. \n");
				System.out.println("Position before roll the dies:" + players[j].getPosition() + "\n");
				
				play(players[j]);
				
				System.out.println("Position after roll the dies:" + players[j].getPosition() + "\n");

			}
			
			if(checkEndGame() == false) {
				System.out.println("END GAME");
				break;
			}
			System.out.println("\n\n\n\n\n\n");
			i++;
		}
		
		
		
	}
	
	public void play(Player player) {
		
		getDie1().roll();
		int die1 = getDie1().getValue();
		getDie2().roll();
		int die2 = getDie2().getValue();
		int sum = die1 + die2;
		
		player.setPosition(player.getPosition() + sum);
		if(player.getPosition() >= 39) {
			player.setPosition(player.getPosition() % 39);
			player.increaseBudget(((StartingPoint)getBoard().getSequares()[0]).getBonus());
			System.out.println(player.getName() + " passed through the starting point.\n");
		}
		
		Sequare current = getBoard().getSequares()[player.getPosition()];
				
		if(current instanceof Prison) {
			player.decreaseBudget(((Prison) current).getBail());
			System.out.println(player.getName() + " paid prison bail.\n");
		}
		else if(current instanceof Luck) {
			player.increaseBudget(((Luck) current).getLuckCard());
			System.out.println(player.getName() + " took luck card.\n");

		}
		else if(current instanceof Goverment) {
			player.decreaseBudget(((Goverment) current).getTax());
			System.out.println(player.getName() + " paid tax. \n");

			
			if(((Goverment) current).getOwner() == null && player.getBudget().getValue() >= ((Goverment) current).getCost().getValue()) {
				((Goverment) current).setOwner(player);
				player.decreaseBudget(((Goverment) current).getCost());
				
				System.out.println(player.getName() + " buyed " + ((Goverment) current).getName() +"\n");

			}
			else if(((Goverment) current).getOwner() != null && ((Goverment) current).getOwner() != player) {
				((Goverment) current).getOwner().increaseBudget(((Goverment) current).getRent());
				player.decreaseBudget(((Goverment) current).getRent());
				System.out.println(player.getName() + " paid rent. \n");
				
			}
		}
		else if(current instanceof Area) {
			if(((Area) current).getOwner() == null && player.getBudget().getValue() > ((Area) current).getCost().getValue()) {
				((Area) current).setOwner(player);
				player.decreaseBudget(((Area) current).getCost());
				System.out.println(player.getName() + " buyed " + ((Area) current).getName() +"\n");

			}
			else if(((Area) current).getOwner() != null && ((Area) current).getOwner() != player) {
				((Area) current).getOwner().increaseBudget(((Area) current).getRent());
				player.decreaseBudget(((Area) current).getRent());
				System.out.println(player.getName() + " paid rent. \n");
			}
		}
		
	}
	
	public boolean checkEndGame() {
		
		for(int i = 0; i < players.length; i++) {
			if(players[i].getBudget().getValue() <= 0) {
				return false;
			}
		}
		
		return true;
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