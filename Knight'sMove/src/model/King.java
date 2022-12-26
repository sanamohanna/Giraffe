package model;

import java.util.ArrayList;

import Enum.Directions;

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
    public Integer KingStrightMove(Directions dir) {
    	switch (dir) {
    	/* here is the location changes in case the piece moved up */
		/*
		* in case the piece is on the last square of the board sides , return 0;
		*/
    case UP: {
		if (this.getLocation().getY() == 0) {
			return 0;
		}
		break;
	}
	/* here is the location changes in case the piece moved down */
	case DOWN: {
		if (this.getLocation().getY() == 7) {
			return 0;
		}
		break;
	}
	/* here is the location changes in case the piece moved right */
	case RIGHT: {
		if (this.getLocation().getX() == 7) {
			return 0;
		} 
		break;
		}
		/* here is the location changes in case the piece moved left */
	case LEFT: {
		if (this.getLocation().getX() == 0) {
			return 0;
		} 
		break;
	}
	default:
		break;
}
    
return 1;    
}
    public int KingDiagonallyMove(Directions dir) {
		/* the different cases it's about the direction that the slant goes */
		/*
		* in case the piece is on the last square of the board sides , it goes to the
		* first square in the same line
		*/
		
		switch (dir) {
			case UP_LEFT: {
				if (this.getLocation().getX() == 0 && this.getLocation().getY() > 0) {
					return 0; 
				} else if (this.getLocation().getY() == 0) {
					return 0;
				} 
				break;
			}
			case UP_RIGHT: {
				if (this.getLocation().getX() == 7 && this.getLocation().getY() > 0) {
					return 0; 
				} 
				else if (this.getLocation().getY() == 0) {
					return 0; 
				}
				break;
			}
			// ?????
			case DOWN_LEFT: {
				if (this.getLocation().getX() == 0 && this.getLocation().getY() < 7) {
					return 0;
				} 
				else if (this.getLocation().getY() == 7) { 
					return 0;
				}
				break;
			}
			case DOWN_RIGHT: {
				if (this.getLocation().getX() == 7 && this.getLocation().getY() < 7) {
					return 0;
				} 
				else if (this.getLocation().getY() == 7) {
					return 0;
				} 
				break;
			}
			default:
				break;
		}
		
		return 1;
	}

	//method that  the king move
	public Integer kingMove(Directions dir) {
		switch(dir) {
		case  UP , DOWN , RIGHT , LEFT:{
			if(this.KingStrightMove(dir)==0) {
				return 0;
			}
		}
		case UP_LEFT,UP_RIGHT , DOWN_LEFT,DOWN_RIGHT :{
			if(this.KingDiagonallyMove(dir)==0) {
				return 0;
			}
		}
		}
		return 1;
	}
	public ArrayList<Location> validMovesForKing(Queen queen){
		ArrayList<Location> toReturn =new ArrayList<Location>();
		Location loc2 = new Location();
		int X = 0 , Y = 0 ;
	//	loc2 = queen.getLocation();
		System.out.println(queen.getLocation()+" queen class");
		X = queen.getLocation().getX();
		Y = queen.getLocation().getY();
			if(kingMove(Directions.LEFT)==1) {
				Location loc = new Location();
					X--;
					loc.setX(X);
					loc.setY(Y);
				
				if(loc.getX() >= 0) {
				toReturn.add(loc);
				}
				X = queen.getLocation().getX();
			}
			if(kingMove(Directions.RIGHT)==1) {
				Location loc = new Location();
					X++;
					loc.setX(X);
					loc.setY(Y);
				
				if(loc.getX() <= 7) {
				toReturn.add(loc);
				}
				X = queen.getLocation().getX();
			}
			if(kingMove(Directions.UP)==1) {
				Location loc = new Location();
					Y--;
					loc.setX(X);
					loc.setY(Y);
				
				if(loc.getY() >= 0) {
				toReturn.add(loc);
				}
				Y = queen.getLocation().getY();
			}
			if(kingMove(Directions.DOWN)==1) {
				Location loc = new Location();
					Y++;
					loc.setX(X);
					loc.setY(Y);
				
				if(loc.getY() <= 7) {
				toReturn.add(loc);
				}
				Y = queen.getLocation().getY();
			}
			if(kingMove(Directions.UP_LEFT)==1) {
				Location loc = new Location();
					Y--;
					X--;
					loc.setX(X);
					loc.setY(Y);
				
				if(loc.getY() >= 0 && loc.getX() >= 0) {
				toReturn.add(loc);
				}
				Y = queen.getLocation().getY();
				X = queen.getLocation().getX();
			}
			if(kingMove(Directions.UP_RIGHT)==1) {
				Location loc = new Location();
					Y--;
					X++;
					loc.setX(X);
					loc.setY(Y);
				
				if(loc.getY() >= 0 && loc.getX() <= 7) {
				toReturn.add(loc);
				}
				Y = queen.getLocation().getY();
				X = queen.getLocation().getX();
			}
			if(kingMove(Directions.DOWN_LEFT)==1) {
				Location loc = new Location();
					Y++;
					X--;
					loc.setX(X);
					loc.setY(Y);
				
				if(loc.getY() <= 7 && loc.getX() >= 0) {
				toReturn.add(loc);
				}
				Y = queen.getLocation().getY();
				X = queen.getLocation().getX();
			}
			if(kingMove(Directions.DOWN_RIGHT)==1) {
				Location loc = new Location();
					Y++;
					X++;
					loc.setX(X);
					loc.setY(Y);
				
				if(loc.getY() <= 7 && loc.getX() <= 7) {
				toReturn.add(loc);
				}
				Y = queen.getLocation().getY();
				X = queen.getLocation().getX();
			
			}
		return toReturn;
	}


}
