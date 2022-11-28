package model;

import Enum.Color;

public class Squares {
	private Piece piece;
	private Location location;
    private Color color;
    private boolean isVisited;
	public Squares(Piece peice, Location location, Color color) {
		super();
		this.piece = peice;
		this.location= location;
		this.color = color;
	}
	public Piece getPeice() {
		return piece;
	}
	public void setPeice(Piece peice) {
		this.piece = peice;
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
	public boolean isvisited() {
		return (piece==null );
	}
}
