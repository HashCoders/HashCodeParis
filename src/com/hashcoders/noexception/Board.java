package com.hashcoders.noexception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Board {
	boolean[][] cells;
	int w,h;
	
	public Board(int w, int h) {
		cells = new boolean[w][h];
		this.w = w;
		this.h = h;
	}
	
	public static Board fromActions(List<Action> actions, int w, int h) {
		Board board = new Board(w, h);
		
		for (Action action : actions)
			action.act(board);

		return board;
	}
	
	public void toFile(String filename) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(filename, "UTF-8");
		writer.println(h + " " + w);
		for (int y = 0; y < h; ++y)
		{
			for (int x = 0; x < w; ++x)
				writer.print(cells[x][y] ? "#" : ".");
			writer.println();
		}
		writer.close();
	}
	
	public static Board fromFile(String filename) throws IOException {
		
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
}
