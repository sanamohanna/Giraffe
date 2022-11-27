package model;

import Enum.Color;

public class Squares {
	private Piece peice;
	private Integer x ;
	private Integer y ;
    private Color color;
	public Squares(Piece peice, Integer x, Integer y, Color color) {
		super();
		this.peice = peice;
		this.x = x;
		this.y = y;
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
