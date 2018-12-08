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
		   
		   if(id == 0) {
			   //starting point
			   String name = parts[1];
			   this.sequares[id] = new StartingPoint(name, new Money(Integer.parseInt(parts[2])), id);
			   
		   }
		   else if(id == 9) {
			   //prison
			   String name = parts[1];
			   this.sequares[id] = new Prison(name, new Money(Integer.parseInt(parts[2])), id);
		   }
		   else if(id == 15 || id == 27) {
			   //luck
			   String name = parts[1];
			   this.sequares[id] = new Luck(name, id);
		   }
		   else if(id == 14 || id == 22 || id == 36) {
			   //goverment
			   String name = parts[1];
			   this.sequares[id] = new Goverment(name, new Money(Integer.parseInt(parts[2])), new Money(Integer.parseInt(parts[3])), id, new Money(Integer.parseInt(parts[4])));
		   
		   }
		   else {
			   String name = parts[1];
			   this.sequares[id] = new Area(name, new Money(Integer.parseInt(parts[2])), new Money(Integer.parseInt(parts[3])), id);
		   }
		   
		   
		   
		   String name = parts[1];
		   this.sequares[id] = new Sequare(name, id);

		}

		br.close();
	}
	
}
