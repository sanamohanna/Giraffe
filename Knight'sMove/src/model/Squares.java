package model;

import Enum.Color;

public class Squares {
	private Location location;
<<<<<<< Updated upstream
	private boolean isVisited;
    //constructor
	public Squares( Location location) {
		super();
		this.isVisited=false;
		this.location= location;
	
=======
	private Color color;
	private boolean isVisited;

	// constructor
	public Squares(Piece peice, Location location, Color color) {
		super();
		this.piece = peice;
		this.location = location;
		this.color = color;
>>>>>>> Stashed changes
	}

	// getters setters
<<<<<<< Updated upstream
=======
	public Piece getPeice() {
		return piece;
	}

	public void setPeice(Piece peice) {
		this.piece = peice;
	}
>>>>>>> Stashed changes

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
<<<<<<< Updated upstream
	
	
=======

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

>>>>>>> Stashed changes
	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

}
