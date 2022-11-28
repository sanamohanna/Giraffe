package model;

import java.util.ArrayList;

public class King extends Piece {

	private Location initialLocation;
	private int speed;

	

	

	public King(Location location, Location initialLocation, int speed) {
		super(location);
		this.initialLocation = initialLocation;
		this.speed = speed;
	}

	public Location getInitialLocation() {
		return initialLocation;
	}

	public void setInitialLocation(Location initialLocation) {
		this.initialLocation = initialLocation;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void kingMove() {
		
	}


}
