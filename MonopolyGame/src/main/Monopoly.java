package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
		printFile("--- Game Was Created ---");
		
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
		
		printFile("--- Players were Created ---");

		printFile("\n--- Game starts. ---\n\n");

		int i = 1;
		while(true) {
			
			printFile("Iteration: " + i + "\n");
			
			for(int j=0; j < players.length; j++) {
				
				printFile("\n" + players[j].getName() + " is playing.");
				printFile("Position before roll the dies:" + players[j].getPosition());
				
				play(players[j]);
				
				printFile("Position after roll the dies:" + players[j].getPosition() );

			}
			
			if(checkEndGame() == false) {
				System.out.println("END GAME");
				break;
			}
			printFile("\n\n\n");
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
			printFile(player.getName() + " passed through the starting point.");
		}
		
		Sequare current = getBoard().getSequares()[player.getPosition()];
				
		if(current instanceof Prison) {
			player.decreaseBudget(((Prison) current).getBail());
			printFile(player.getName() + " paid prison bail.");
		}
		else if(current instanceof Luck) {
			player.increaseBudget(((Luck) current).getLuckCard());
			printFile(player.getName() + " took luck card.");

		}
		else if(current instanceof Goverment) {
			player.decreaseBudget(((Goverment) current).getTax());
			printFile(player.getName() + " paid tax.");

			
			if(((Goverment) current).getOwner() == null && player.getBudget().getValue() >= ((Goverment) current).getCost().getValue()) {
				((Goverment) current).setOwner(player);
				player.decreaseBudget(((Goverment) current).getCost());
				
				printFile(player.getName() + " buyed " + ((Goverment) current).getName());

			}
			else if(((Goverment) current).getOwner() != null && ((Goverment) current).getOwner() != player) {
				((Goverment) current).getOwner().increaseBudget(((Goverment) current).getRent());
				player.decreaseBudget(((Goverment) current).getRent());
				printFile(player.getName() + " paid rent.");

			}
		}
		else if(current instanceof Area) {
			if(((Area) current).getOwner() == null && player.getBudget().getValue() > ((Area) current).getCost().getValue()) {
				((Area) current).setOwner(player);
				player.decreaseBudget(((Area) current).getCost());
				printFile(player.getName() + " buyed " + ((Area) current).getName());

			}
			else if(((Area) current).getOwner() != null && ((Area) current).getOwner() != player) {
				((Area) current).getOwner().increaseBudget(((Area) current).getRent());
				player.decreaseBudget(((Area) current).getRent());
				printFile(player.getName() + " paid rent.");

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
	
	public void printFile(String s) {
		try(FileWriter fw = new FileWriter("output.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw)){
			    
			out.println(s);

			    
			} catch (IOException e) {
			    System.out.println(e.getMessage());
			}
	}

}