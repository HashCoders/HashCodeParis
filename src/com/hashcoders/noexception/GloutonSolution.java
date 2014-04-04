package com.hashcoders.noexception;

import java.util.ArrayList;
import java.util.List;

import com.hashcoders.noexception.HashCodeTrial.Board;

public class GloutonSolution extends Solution {

	public int getBestSquare(Board board, int x, int y) {
		for (int radius = 0; radius < board.w; radius++) {
			int size = 2*radius;
			if (x+size > board.w || y+size > board.h)
				return radius-1;
			for (int i = 0; i < size; i++)
			{
				if (!board.cells[x+i][y+size])
					return radius-1;
				if (!board.cells[x+size][y+i])
					return radius-1;
			}
		}
		
		return 0;
	}
	
	public void clearSquare(Board board, int x, int y, int radius) {
		for (int px = x - radius; px < x+radius; px++)
			for (int py = y-radius; py < y+radius; py++)
				board.cells[px][py] = false;
	}
	
	@Override
	public List<Action> process(Board board) {
		List<Action> actions = new ArrayList<Action>();
		for (int x = 0; x < board.w; x++)
			for (int y = 0; y < board.h; y++)
			{
				// Get best square from here
				int radius = getBestSquare(board, x, y);
				actions.add(new PaintAction(x+radius, y+radius, radius));
				clearSquare(board, x, y, radius);
			}
		
		return actions;
	}

}
