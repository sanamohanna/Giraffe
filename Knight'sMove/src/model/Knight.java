package model;

import java.util.ArrayList;

public class Knight extends Piece {

	

	public Knight(Location location, ArrayList<Integer> initialPlaceKnight, boolean isKilled) {
		super(location);
		this.initialPlaceKnight = initialPlaceKnight;
		this.isKilled = isKilled;
	}

	private ArrayList<Integer> initialPlaceKnight;
	private boolean isKilled;



	public ArrayList<Integer> getInitialPlaceKnight() {
		return initialPlaceKnight;
	}

	public void setInitialPlaceKnight(ArrayList<Integer> initialPlaceKnight) {
		this.initialPlaceKnight = initialPlaceKnight;
	}

	public boolean isKilled() {
		return isKilled;
	}

	public void setKilled(boolean isKilled) {
		this.isKilled = isKilled;
	}

	public void LeftMove() {

	}

	public void RightMove() {

	}
}
