package model;

import java.util.ArrayList;

public class Queen extends Piece {

	private ArrayList<Integer> initialPlaceQueen;

	
	public Queen(Location location, ArrayList<Integer> initialPlaceQueen) {
		super(location);
		this.initialPlaceQueen = initialPlaceQueen;
	}

	public ArrayList<Integer> getInitialPlaceQueen() {
		return initialPlaceQueen;
	}

	public void setInitialPlaceQueen(ArrayList<Integer> initialPlaceQueen) {
		this.initialPlaceQueen = initialPlaceQueen;
	}

	public void DiagonallyMove() {

	}

}
