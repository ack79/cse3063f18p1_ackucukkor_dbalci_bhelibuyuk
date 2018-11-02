package main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Monopoly monopoly = new Monopoly();
		System.out.println("---> Monopoly was created");
		
		File file = new File("src/main/sequare.txt");
		monopoly.getBoard().installBoard(file);
		System.out.println("---> Monopoly board was created");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("How many players do you want: ");
		int playerNumber = scan.nextInt();
		
		scan.nextLine();

		for(int i = 0; i < playerNumber; i++) {
			System.out.print("What is the name of the "+ (i+1) +" player: ");
			String name = scan.nextLine();
			monopoly.addPlayerToGame(new Player(name,new Money(3000)),i);
		}
		scan.close();
		
		System.out.print("\n\n");

		
		monopoly.setNumberOfIteration(150);
		
		for(int i = 1; i <= 150; i++) {
			
			System.out.println("Turn: " + i);
			System.out.print("\n");

			
			for(int j = 0; j < playerNumber; j++) {
				
				System.out.print((j+1) +". player "+ monopoly.getPlayers()[j].getName() +" is playing.");
				
				monopoly.getDie1().roll();
				int die1 = monopoly.getDie1().getValue();
				monopoly.getDie2().roll();
				int die2 = monopoly.getDie2().getValue();
				
				System.out.println("First die value: " + die1);
				System.out.println("Second die value: " + die2);
				System.out.println("Sum: " + (die1 + die2));
				
				System.out.println((j+1) +". player "+ monopoly.getPlayers()[j].getName() +" goes forward "+ (die1 + die2) +" sequares");
				
				System.out.print("\n");
			}
			System.out.print("\n\n\n");
			
		}
	}

}
