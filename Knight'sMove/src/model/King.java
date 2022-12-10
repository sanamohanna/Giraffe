package model;

//import java.util.ArrayList;

public class King extends Piece {

	private Location initialLocation;
	private Integer speed;


	public King(Location location, Location initialLocation, Integer speed) {
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

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	public void kingMove() {
		
	}


}
