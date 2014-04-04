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
	
	public static void naiveSolution(Board board, String output) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(output, "UTF-8");
		
		List<String> actions = new ArrayList<String>();
		
		for (int w = 0; w < board.w; w++)
			for (int h = 0; h < board.h; h++)
				if (board.cells[w][h])
					actions.add("PAINTSQ " + h + " " + w + " 0");
		
		writer.println(actions.size());
		for (int i = 0;i < actions.size(); i++)
			writer.println(actions.get(i));
		
		writer.close();
	}
	
	public static void main(String[] args) {
		String input = "doodle.txt";
		
		try {
			Board board = loadBoard(input);
			naiveSolution(board, "output.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
