package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Board {
	
	public final int NUMBER_OF_SEQUARE = 40;
	private Sequare[] sequares;
	
	public Board() {
		this.sequares = new Sequare[NUMBER_OF_SEQUARE];
	}
	
	public Sequare[] getSequares() {
		return sequares;
	}
	
	public void installBoard(File file) throws IOException {
		
		FileReader fileReader = new FileReader(file);
		String line;

		BufferedReader br = new BufferedReader(fileReader);

		while ((line = br.readLine()) != null) {

		   String [] parts = line.split(" ");
		   
		   int id = Integer.parseInt(parts[0]); 
		   String name = parts[1];
		   this.sequares[id] = new Sequare(name, id);

		}

		br.close();
	}
	
}
