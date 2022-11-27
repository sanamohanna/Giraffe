package model;

import java.util.ArrayList;
import java.util.Objects;

import Enum.Directions;

public class Piece {

	private Location location;

	
	public Piece(Location location) {
		super();
		this.location = location;
	}
	

	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(location);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		return Objects.equals(location, other.location);
	}


	public void leftMove() {
		int currentX=this.location.getX();
		if(this.getLocation().getX()==0) {
			this.getLocation().setX(7);
		}
		else
		{
			this.getLocation().setX(currentX-1);
		}
	}

	public void rightMove() {
		int currentX=this.location.getX();
		if(this.getLocation().getX()==7) {
			this.getLocation().setX(0);
		}
		else
		{
			this.getLocation().setY(currentX+1);
		}
	}
	
	public void downMove() {
		int currentY=this.location.getY();
		if(this.getLocation().getY()==7) {
			this.getLocation().setY(0);
		}
		else
		{
			this.getLocation().setY(currentY+1);
		}
	}
	
	public void upMove() {
		int currentY=this.location.getY();
		if(this.getLocation().getY()==0) {
			this.getLocation().setY(7);
		}
		else
		{
			this.getLocation().setY(currentY-1);
		}
	}
	
	public void DiagonallyMove(Directions dir) {
		switch(dir) {
		case UP_LEFT: {
			if(this.location.getX()==0 && this.location.getY()>0) {
				this.location.setX(7);
				this.location.setY((this.location.getY())-1);
			}
			else if( this.location.getY()==0) {
				throw new IllegalArgumentException("illegal Move");
			}
			else {
				this.location.setX(this.location.getX()-1);
				this.location.setY((this.location.getY())-1);
			}
			break;

		}
		case UP_RIGHT:{
			if(this.location.getX()==7 && this.location.getY()>0) {
				this.location.setX(0);
				this.location.setY((this.location.getY())-1);
			}
			else if( this.location.getY()==0) {
				throw new IllegalArgumentException("illegal Move");
			}
			else {
				this.location.setX(this.location.getX()+1);
				this.location.setY((this.location.getY())-1);
			}
			break;
		}
		//?????
		case DOWN_LEFT:{
			if(this.location.getX()==0 && this.location.getY()<7) {
				this.location.setX(7);
				this.location.setY((this.location.getY())+1);
			}
			else if( this.location.getY()==7) {
				throw new IllegalArgumentException("illegal Move");
			}
			else {
				this.location.setX(this.location.getX()-1);
				this.location.setY((this.location.getY())+1);
			}
			break;
		}
		case DOWN_RIGHT:{
			if(this.location.getX()==7 && this.location.getY()<7) {
				this.location.setX(0);
				this.location.setY((this.location.getY())+1);
			}
			else if( this.location.getY()==7) {
				throw new IllegalArgumentException("illegal Move");
			}
			else {
				this.location.setX(this.location.getX()+1);
				this.location.setY((this.location.getY())+1);
			}
			break;
		}
		default:
			
 
		}
	}

}
