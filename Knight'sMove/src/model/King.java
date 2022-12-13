package model;

//import java.util.ArrayList;

/**
 * 
 * 
 * Class extends from abstract class -> for Template Design Pattern
 * 
 * 
 * **/

public class King extends Piece {
	
	private Integer speed;
	
	//constructor
	public King(Integer speed) {
		super(new Location(7,0));
		this.speed = speed;
	}
	
	//getters and setters
	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((speed == null) ? 0 : speed.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		King other = (King) obj;
		if (speed == null) {
			if (other.speed != null)
				return false;
		} else if (!speed.equals(other.speed))
			return false;
		return true;
	}

	//method that  the king move
	public void kingMove() {
		
	}


}
