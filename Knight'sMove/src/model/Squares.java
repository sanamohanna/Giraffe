package model;

import Enum.Color;

public class Squares {
	private Location location;
	private boolean isVisited;
	private int numVisits; 

	

	// constructor
	public Squares() {
		super();
		this.isVisited = false;
		location=new Location();
		numVisits=0;
		//this.location = location;
	}

	// constructor
	public Squares(Location location) {
		super();
		//this.location = location;
		
	}
	// getters setters
	public int getNumVisits() {
		return numVisits;
	}

	public void setNumVisits(int numVisits) {
		this.numVisits = numVisits;
	}
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

	@Override
	public String toString() {
		return "Squares [location=" + location + ", isVisited=" + isVisited + "]\n";
	}
	
}
