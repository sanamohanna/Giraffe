package model;

import java.util.ArrayList;

public class Knight extends Piece {
  
	private ArrayList<Integer> initialPlaceKnight;
	private boolean isKilled;
	
	
	public Knight(ArrayList<Integer> place, ArrayList<Integer> initialPlaceKnight, boolean isKilled) {
		super(place);
		this.initialPlaceKnight = initialPlaceKnight;
		this.isKilled = isKilled;
	}
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

	public void LeftMove(){
		
	}
	public void RightMove(){
		
	}
}
