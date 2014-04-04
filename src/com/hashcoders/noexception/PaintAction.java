package com.hashcoders.noexception;

public class PaintAction  extends Action {

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

	@Override
	public void act(Board board) {
		for (int px = x-radius; px <= x+radius; px++)
			for (int py = y-radius; py <= y+radius; py++)
				board.cells[px][py] = true;
	}
}
