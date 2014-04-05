package com.hashcoders.noexception;

import java.util.ArrayList;
import java.util.List;

public class SolutionWrapper extends Solution {

	Solution solution;
	int blur;
	int threshold;
	
	public static int countCells(Board board, int x, int y, int radius) {
		int result = 0;
		for (int px = x-radius; px <= x+radius; px++)
			if (px >= 0 && px < board.w)
				for (int py = y-radius; py <= y+radius; py++)
					if (py >= 0 && py < board.h)
						if (board.cells[px][py])
							result++;
		return result;
	}
	
	
	public SolutionWrapper(Solution solution, int blur, int excess) {
		this.solution = solution;
		this.blur = blur;
		this.threshold = (2*blur+1)*(2*blur+1) - excess;
	}
	
	@Override
	public List<Action> process(Board board) {			
		List<Action> backActions = new ArrayList<Action>();

		for (int x = 0; x < board.w; x++)
			for (int y = 0; y < board.h; y++)
			{
				if (!board.cells[x][y] && countCells(board, x, y, blur) >= threshold)
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
