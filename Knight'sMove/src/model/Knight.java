package model;

import java.util.ArrayList;

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
	public void level1Move( String direction1 , String direction2){
		if(direction1 == "left" && direction2 == "up") {
			this.leftMove();
			this.upMove();
		}
		if(direction1 == "left" && direction2 == "down") {
			this.leftMove();
			this.downMove();
		}
        if(direction1 == "right" && direction2 == "up" ) {
			this.rightMove();
			this.upMove();
		}
        if(direction1 == "right" && direction2 == "down" ) {
			this.rightMove();
			this.downMove();
		}
        if(direction1 == "up" && direction2 == "left") {
			this.upMove();
			this.leftMove();
		}
        if(direction1 == "up" && direction2 == "right") {
			this.upMove();
			this.rightMove();
		}
        if(direction1 == "down" && direction2 == "left") {
			this.downMove();
			this.leftMove();
		} 
        if(direction1 == "down" && direction2 == "right") {
			this.downMove();
			this.rightMove();
		} 
		
	}
	public void level2Move() {
		
	}
    public void level3Move(){
		
	}
	public void level4Move() {
		
	}
}
