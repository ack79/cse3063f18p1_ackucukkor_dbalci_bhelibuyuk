package main;

import java.io.File;

public class Board {
	
	public final int NUMBER_OF_SEQUARE = 40;
	private Sequare[] sequares;
	
	public Board() {
		this.sequares = new Sequare[NUMBER_OF_SEQUARE];
	}
	
	public Sequare[] getSequares() {
		return sequares;
	}
	
	public void installBoard(File file) {
		//TODO: function's dteails
	}
	
}
