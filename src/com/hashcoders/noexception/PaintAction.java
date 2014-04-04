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
}
