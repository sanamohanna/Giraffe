package model;

import java.util.ArrayList;

import Enum.Directions;

public class Knight extends Piece {
	private Location initialLocation;
	private boolean isKilled;
	
	public Knight(Location location, Location initialLocation, boolean isKilled) {
		super(location);
		this.initialLocation = new Location(0,0);
		this.isKilled = isKilled;
	}  

	public Location getInitialLocation() {
		return initialLocation;
	}


	public boolean isKilled() {
		return isKilled;
	}

	public void setKilled(boolean isKilled) {
		this.isKilled = isKilled;
	}
	public void level1Move( Directions direction1 , Directions direction2, Directions direction3){
		// the knight move two squares in one direction and then one square in a perpendicular direction .
		// checking if the knight's move is correct .
		if(direction1 == Directions.UP) {
			if(direction2 != Directions.UP || (direction3 == Directions.DOWN || direction3 == Directions.UP)) {
				System.out.println("somthing wrong!");
			}
			else {
				this.StrightMove(direction1);
				this.StrightMove(direction2);
				this.StrightMove(direction3);
			}
		}
		if(direction1 == Directions.DOWN) {
			if(direction2 != Directions.DOWN || (direction3 == Directions.DOWN || direction3 == Directions.UP)) {
				System.out.println("somthing wrong!");
			}
			else {
				this.StrightMove(direction1);
				this.StrightMove(direction2);
				this.StrightMove(direction3);
			}
		}
		if(direction1 == Directions.LEFT) {
			if(direction2 != Directions.LEFT || (direction3 == Directions.LEFT || direction3 == Directions.RIGHT)) {
				System.out.println("somthing wrong!");
			}
			else {
				this.StrightMove(direction1);
				this.StrightMove(direction2);
				this.StrightMove(direction3);
			}
		}
		if(direction1 == Directions.RIGHT) {
			if(direction2 != Directions.RIGHT || (direction3 == Directions.LEFT || direction3 == Directions.RIGHT)) {
				System.out.println("somthing wrong!");
			}
			else {
				this.StrightMove(direction1);
				this.StrightMove(direction2);
				this.StrightMove(direction3);
			}
		}
		
		
	}
	

	public void level2Move(Directions direction1 , Directions direction2 ,  Directions direction3 ) {
		/*in this level the knight can move two squares straight and one diagonally or two diagonally and one straight*/
		/*if the knight start with a straight square we check if the 
		 next square is straight and the last one is diagonally*/
		if(direction1 ==  Directions.DOWN || direction1 == Directions.UP 
				|| direction1 == Directions.RIGHT || direction1 == Directions.LEFT ) {
			if((direction2 !=  Directions.DOWN && direction2 != Directions.UP 
					&& direction2 != Directions.RIGHT && direction2 != Directions.LEFT)) {
				System.out.println("something wrong!!!");
			}
			else if((direction3 == Directions.DOWN || direction3 == Directions.UP 
					|| direction3 == Directions.RIGHT || direction3 == Directions.LEFT)) {
				System.out.println("somthing wrong!!!");
			} else {
				this.StrightMove(direction1);
				this.StrightMove(direction2);
				this.DiagonallyMove(direction3);
			}
		}
		/*and the same checking but if it start with diagonally*/
		if(direction1 == Directions.DOWN_LEFT || direction1 == Directions.DOWN_RIGHT 
				|| direction1 == Directions.UP_LEFT || direction1 == Directions.UP_RIGHT) {
			if((direction2 !=  Directions.DOWN_LEFT && direction2 != Directions.DOWN_RIGHT 
					&& direction2 != Directions.UP_LEFT && direction2 != Directions.UP_RIGHT)) {
				System.out.println("something wrong!!!");
			}
			else if((direction3 == Directions.DOWN_LEFT || direction3 == Directions.DOWN_RIGHT 
					|| direction3 == Directions.UP_LEFT|| direction3 == Directions.UP_RIGHT)) {
				System.out.println("somthing wrong!!!");
			} else {
				this.DiagonallyMove(direction1);
				this.DiagonallyMove(direction2);
				this.StrightMove(direction3);
			}
		}
		
	}
    public void level3and4Move(Directions dir){
    	switch(dir) {
    	case UP , DOWN , RIGHT , LEFT:{
			this.StrightMove(dir);
			break;
		}
		case UP_LEFT,UP_RIGHT , DOWN_LEFT,DOWN_RIGHT:{
			this.DiagonallyMove(dir);
			break;
		}
			
		}
	}
	}
