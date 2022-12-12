package model;

import java.util.Objects;

public class Location {
	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}

	private Integer x ;
	private Integer y ;
	//constructor
	public Location(Integer x, Integer y) {
		super();
		this.x = x;
		this.y = y;
	}
	// getters setters
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

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return x == other.x && y == other.y;
	}
	
}
