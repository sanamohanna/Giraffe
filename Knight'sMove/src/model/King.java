package model;

import java.util.ArrayList;

public class King extends Piece {

	private ArrayList<Integer> initialPlaceKing;
	private int speed;

	public King(ArrayList<Integer> place, ArrayList<Integer> initialPlaceKing, int speed) {
		super(place);
		this.initialPlaceKing = initialPlaceKing;
		this.speed = speed;
	}

	public ArrayList<Integer> getInitialPlaceKing() {
		return initialPlaceKing;
	}

	public void setInitialPlaceKing(ArrayList<Integer> initialPlaceKing) {
		this.initialPlaceKing = initialPlaceKing;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void DiagonallyMove() {
		
	}

}
