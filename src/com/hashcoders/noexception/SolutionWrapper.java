package com.hashcoders.noexception;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.hashcoders.noexception.HashCodeTrial.Board;

public class SolutionWrapper extends Solution {

	Solution solution;
	int blur;
	
	
	public static int countCells(Board board, int x, int y, int radius) {
		int result = 0;
		for (int px = x-radius; px < x+radius; px++)
			if (px >= 0 && px < board.w)
				for (int py = y-radius; py < y+radius; py++)
					if (py >= 0 && py < board.h)
						if (board.cells[px][py])
							result++;
		return result;
	}
	
	
	public SolutionWrapper(Solution solution, int blur) {
		this.solution = solution;
		this.blur = blur;
	}
	
	@Override
	public List<Action> process(Board board) {			
		List<Action> backActions = new ArrayList<Action>();

		
		int threshold = (blur+1)*(blur+1) / 2;
		for (int x = 0; x < board.w; x++)
			for (int y = 0; y < board.h; y++)
			{
				if (board.cells[x][y] && countCells(board, x, y, blur) < threshold)
				{
					board.cells[x][y] = true;
					backActions.add(new EraseAction(x, y));
				}
			}
		
		List<Action> actions = solution.process(board);
		actions.addAll(backActions);
		
		return actions;
	}
}
