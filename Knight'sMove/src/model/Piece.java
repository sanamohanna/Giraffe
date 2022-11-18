package model;

import java.util.ArrayList;

public class Piece {

	private ArrayList<Integer> place;
	
	
	public Piece(ArrayList<Integer> place) {
		super();
		this.place = place;
	}


	public ArrayList<Integer> getPlace() {
		return place;
	}


	public void setPlace(ArrayList<Integer> place) {
		this.place = place;
	}


	public void straightMove() {
	}
	
}
