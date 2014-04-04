package com.hashcoders.noexception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class HashCodeTrial {
	

	



	
	public static void main(String[] args) {
		String input = "doodle.txt";
		
		try {
			Board board = Board.fromFile(input);
			// Solution solution = new SolutionWrapper(new NaiveSolution(), 5);
			Solution solution = new GloutonSolution();
			List<Action> actions = solution.process(board);
			PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
			writer.println(actions.size());
			for (int i = 0;i < actions.size(); i++)
				writer.println(actions.get(i));
			
			Board newBoard = Board.fromActions(actions, board.w, board.h);
			newBoard.toFile("board.txt");
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
