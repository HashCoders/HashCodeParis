package com.hashcoders.noexception;

public class EraseAction extends Action {

	int x, y;
	
	public EraseAction(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "ERASECELL " + y + " " + x;
	}
	
}