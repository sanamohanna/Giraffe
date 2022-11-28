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
	public void level1Move( Directions direction1 , Directions direction2){
		if(direction1 ==  Directions.LEFT && direction2 ==  Directions.UP) {
			this.leftMove();
			this.upMove();
		}
		if(direction1 == Directions.LEFT && direction2 ==  Directions.DOWN) {
			this.leftMove();
			this.downMove();
		}
        if(direction1 ==  Directions.RIGHT && direction2 ==  Directions.UP) {
			this.rightMove();
			this.upMove();
		}
        if(direction1 == Directions.RIGHT && direction2 ==  Directions.DOWN ) {
			this.rightMove();
			this.downMove();
		}
        if(direction1 == Directions.UP && direction2 ==  Directions.LEFT) {
			this.upMove();
			this.leftMove();
		}
        if(direction1 ==  Directions.UP && direction2 ==  Directions.RIGHT) {
			this.upMove();
			this.rightMove();
		}
        if(direction1 ==  Directions.DOWN && direction2 ==  Directions.LEFT) {
			this.downMove();
			this.leftMove();
		} 
        if(direction1 == Directions.DOWN && direction2 ==  Directions.RIGHT) {
			this.downMove();
			this.rightMove();
		} 
		
	}
	
	
	public void level2Move() {
		
	}
    public void level3and4Move(Directions dir){
    	switch(dir) {
		case UP:{
			this.upMove();
			break;
		}
		case DOWN:{
			this.downMove();
			break;
		}
		case LEFT:{
			this.leftMove();
			break;
		}
		case RIGHT:{
			this.rightMove();
			break;
		}
		case UP_LEFT,UP_RIGHT , DOWN_LEFT,DOWN_RIGHT:{
			this.DiagonallyMove(dir);
			break;
		}
			
		}
	}
	}
