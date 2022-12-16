package model;

import Enum.Color;

public class Squares {
	private Location location;
	private boolean isVisited;
	private Color color;

	// constructor
	public Squares(Location location) {
		super();
		this.isVisited = false;
		this.location = location;
	}

	// constructor
	public Squares(Location location, Color color) {
		super();
		this.location = location;
		this.color = color;
	}
	// getters setters

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

}
