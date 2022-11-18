package model;

import java.util.ArrayList;

public class Queen extends Piece {

	private ArrayList<Integer> initialPlaceQueen;

	public Queen(ArrayList<Integer> place, ArrayList<Integer> initialPlaceQueen) {
		super(place);
		this.initialPlaceQueen = initialPlaceQueen;
	}

	public ArrayList<Integer> getInitialPlaceQueen() {
		return initialPlaceQueen;
	}

	public void setInitialPlaceQueen(ArrayList<Integer> initialPlaceQueen) {
		this.initialPlaceQueen = initialPlaceQueen;
	}
    
public void  DiagonallyMove() {
		
	}
	
	
}
