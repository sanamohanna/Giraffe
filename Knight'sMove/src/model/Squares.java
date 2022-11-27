package model;

import Enum.Color;

public class Squares {
	private Piece peice;
	private Location location ;
    private Color color;
	public Squares(Piece peice, Location location, Color color) {
		super();
		this.peice = peice;
		this.location= location;
		this.color = color;
	}
	public Piece getPeice() {
		return peice;
	}
	public void setPeice(Piece peice) {
		this.peice = peice;
	}
	
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
  
    
}
