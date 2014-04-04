package com.hashcoders.noexception;

import java.util.ArrayList;
import java.util.List;

public class NaiveSolution extends Solution {

	@Override
	public List<Action> process(Board board) {
			
		List<Action> actions = new ArrayList<Action>();
		
		for (int w = 0; w < board.w; w++)
			for (int h = 0; h < board.h; h++)
				if (board.cells[w][h])
					actions.add(new PaintAction(w,h,0));
		
		return actions;
	}
		

}
