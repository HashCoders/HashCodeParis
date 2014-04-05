package com.hashcoders.noexception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class HashCodeTrial {
	

	



	
	public static void main(String[] args) {
		String input = "doodle.txt";
		
		try {
			Board originalBoard = Board.fromFile(input);
			for (int blur = 1; blur < 10; blur++)
				for (int excess = 1; excess < (2*blur+1)*(2*blur+1); excess++)
				{				
					Board board = new Board(originalBoard);
					Solution solution = new SolutionWrapper(new GloutonSolution(), blur, excess);
					// Solution solution = new GloutonSolution();
					List<Action> actions = solution.process(board);
					System.out.println(actions.size() + " : " + blur + " " + excess);
					PrintWriter writer = new PrintWriter("output_"+blur+"_"+excess+".txt", "UTF-8");
					writer.println(actions.size());
					for (int i = 0;i < actions.size(); i++)
						writer.println(actions.get(i));
										
					writer.close();
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
