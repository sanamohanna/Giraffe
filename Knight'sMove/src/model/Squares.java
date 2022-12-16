package model;

import Enum.Color;

public class Squares {
	private Location location;
	private boolean isVisited;
    //constructor
	public Squares( Location location) {
		super();
		this.isVisited=false;
		this.location= location;
	
	}
	// getters setters

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

}
