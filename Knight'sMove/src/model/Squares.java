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
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
  
    
}
