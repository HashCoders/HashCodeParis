package com.hashcoders.noexception;


public class HashCodeTrial {

	public class Board {
		boolean[][] cells;
		int w,h;
		
		public Board(int w, int h) {
			cells = new boolean[w][h];
			this.w = w;
			this.h = h;
		}
	}
	
	public static Board loadBoard(String filename) {
		//TODO : make it work
	    
		return null;
	}
	
	public static void naiveSolution(Board board) {
		for (int w = 0; w < board.w; w++)
			for (int h = 0; h < board.h; h++)
				if (board.cells[w][h])
					System.out.println("PAINTSQ " + w + " " + h + " 0");
		
	}
	
	public static void main(String[] args) {
		String input = "doodle.txt";
		Board board = loadBoard(input);
		
		naiveSolution(board);
	}

}
