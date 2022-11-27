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
	/*NOT SURE !!!!!!!!*/
	/*WE WILL USE THIS METHOD JUST IN CASE THE KNIGHT CAN MOVE DIANOGALLY !!!! WE NEED TO ASK NAREED*/
	public void level1Move( Directions direction1 , Directions direction2 ,  Directions direction3){
		if(direction3 == null) {
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
		}else {
			this.DiagonallyMove(direction3);
		}
		
	}
	
	
	public void level2Move() {
		
	}
    public void level3Move(){
		
	}
	public void level4Move() {
		
	}
}
