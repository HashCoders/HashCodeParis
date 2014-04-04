package com.hashcoders.noexception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class HashCodeTrial {

	public static class Board {
		boolean[][] cells;
		int w,h;
		
		public Board(int w, int h) {
			cells = new boolean[w][h];
			this.w = w;
			this.h = h;
		}
	}
	
	public static abstract class Action {
		public abstract String toString();
	}
	
	public static class PaintAction extends Action {

		int x;
		int y;
		int radius;
		
		public PaintAction(int x, int y, int radius) {
			this.x = x;
			this.y = y;
			this.radius = radius;
		}
		
		@Override
		public String toString() {
			return "PAINTSQ " + y + " " + x + " " + radius;
		}
	}
	
	public static Board loadBoard(String filename) throws IOException {
		
		//TODO : make it work
		BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
		String line;
		// First: size
		line = br.readLine();
		String[] size = line.split(" ");
		int w = Integer.parseInt(size[1]);
		int h = Integer.parseInt(size[0]);
		Board board = new Board(w, h);
		
		int j = 0;
		while ((line = br.readLine()) != null) {
		   for (int i = 0; i < line.length(); i++)
			   board.cells[i][j] = (line.charAt(i) == '#');
		   j++;
		}
		br.close();
		
		return board;
	}
	
	public static List<Action> naiveSolution(Board board) throws FileNotFoundException, UnsupportedEncodingException {
		
		List<Action> actions = new ArrayList<Action>();
		
		for (int w = 0; w < board.w; w++)
			for (int h = 0; h < board.h; h++)
				if (board.cells[w][h])
					actions.add(new PaintAction(w,h,0));
		
		return actions;
	}
	
	public static void main(String[] args) {
		String input = "doodle.txt";
		
		try {
			Board board = loadBoard(input);
			List<Action> actions = naiveSolution(board);
			PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
			writer.println(actions.size());
			for (int i = 0;i < actions.size(); i++)
				writer.println(actions.get(i));
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
