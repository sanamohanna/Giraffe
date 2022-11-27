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
	public void level1Move(){
		
	}
	public void level2Move() {
		
	}
    public void level3Move(){
		
	}
	public void level4Move() {
		
	}
}
