package model;

import java.util.ArrayList;

//import java.util.ArrayList;

/**
 * 
 * 
 * Class extends from abstract class -> for Template Design Pattern
 * 
 * 
 * **/

import Enum.Directions;

public class Knight extends Piece {
	
	private boolean isKilled;
	
	//constructor
	public Knight(boolean isKilled) {
		super(new Location(0,0));
		this.isKilled = isKilled;
	}  
	public Knight(Location loc) {
		super(loc);
	}
	//getter and setter
	public boolean isKilled() {
		return isKilled;
	}

	public void setKilled(boolean isKilled) {
		this.isKilled = isKilled;
	}
	
	/**
	 * 
	 * levels moves
	 * 
	 * **/
	public Location level1Move(Directions direction1 , Directions direction2, Directions direction3 , String X , String Y) {
		// the knight move two squares in one direction and then one square in a perpendicular direction .
				// checking if the knight's move is correct .
		Location loc = new Location(Integer.parseInt(Y), Integer.parseInt(X));
		Knight knight1 = new Knight(loc);
		Location newLoc = new Location();
				if(direction1 == Directions.UP) {
					if(direction2 != Directions.UP || (direction3 == Directions.DOWN || direction3 == Directions.UP)) {
						throw new IllegalArgumentException("illegal Move");
					}
					else {
						knight1.StrightMove(direction1);
						knight1.StrightMove(direction2);
						knight1.StrightMove(direction3);
						newLoc = knight1.getLocation();
						return newLoc;
					}
				}
				else if(direction1 == Directions.DOWN) {
					if(direction2 != Directions.DOWN || (direction3 == Directions.DOWN || direction3 == Directions.UP)) {
						throw new IllegalArgumentException("illegal Move");
					}
					else {
						knight1.StrightMove(direction1);
						knight1.StrightMove(direction2);
						knight1.StrightMove(direction3);
						newLoc = knight1.getLocation();
						return newLoc;

					}
				}
				else if(direction1 == Directions.LEFT) {
					if(direction2 != Directions.LEFT || (direction3 == Directions.LEFT || direction3 == Directions.RIGHT)) {
						throw new IllegalArgumentException("illegal Move");
					}
					else {
						knight1.StrightMove(direction1);
						knight1.StrightMove(direction2);
						knight1.StrightMove(direction3);
						newLoc = knight1.getLocation();
						return newLoc;

					}
				}
				else if(direction1 == Directions.RIGHT) {
					if(direction2 != Directions.RIGHT || (direction3 == Directions.LEFT || direction3 == Directions.RIGHT)) {
						throw new IllegalArgumentException("illegal Move");
					}
					else {
						knight1.StrightMove(direction1);
						knight1.StrightMove(direction2);
						knight1.StrightMove(direction3);
						newLoc = knight1.getLocation();
						return newLoc;

					}
				}
				return null;
				
	}
	/*public void level1Move( Directions direction1 , Directions direction2, Directions direction3,Knight knight){
		// the knight move two squares in one direction and then one square in a perpendicular direction .
		// checking if the knight's move is correct .
		if(direction1 == Directions.UP) {
			if(direction2 != Directions.UP || (direction3 == Directions.DOWN || direction3 == Directions.UP)) {
				throw new IllegalArgumentException("illegal Move");
			}
			else {
				knight.StrightMove(direction1);
				knight.StrightMove(direction2);
				knight.StrightMove(direction3);
			}
		}
		else if(direction1 == Directions.DOWN) {
			if(direction2 != Directions.DOWN || (direction3 == Directions.DOWN || direction3 == Directions.UP)) {
				throw new IllegalArgumentException("illegal Move");
			}
			else {
				knight.StrightMove(direction1);
				knight.StrightMove(direction2);
				knight.StrightMove(direction3);
			}
		}
		else if(direction1 == Directions.LEFT) {
			if(direction2 != Directions.LEFT || (direction3 == Directions.LEFT || direction3 == Directions.RIGHT)) {
				throw new IllegalArgumentException("illegal Move");
			}
			else {
				knight.StrightMove(direction1);
				knight.StrightMove(direction2);
				knight.StrightMove(direction3);
			}
		}
		else if(direction1 == Directions.RIGHT) {
			if(direction2 != Directions.RIGHT || (direction3 == Directions.LEFT || direction3 == Directions.RIGHT)) {
				throw new IllegalArgumentException("illegal Move");
			}
			else {
				knight.StrightMove(direction1);
				knight.StrightMove(direction2);
				knight.StrightMove(direction3);
			}
		}
		
		
	}*/
	

	public void level2Move(Directions direction1 , Directions direction2 ,  Directions direction3 ) {
		/*in this level the knight can move two squares straight and one diagonally or two diagonally and one straight*/
		/*if the knight start with a straight square we check if the 
		 next square is straight and the last one is diagonally*/
		if(direction1 ==  Directions.DOWN || direction1 == Directions.UP 
				|| direction1 == Directions.RIGHT || direction1 == Directions.LEFT ) {
			if((direction2 !=  Directions.DOWN && direction2 != Directions.UP 
					&& direction2 != Directions.RIGHT && direction2 != Directions.LEFT)) {
				throw new IllegalArgumentException("illegal Move");
			}
			else if((direction3 == Directions.DOWN || direction3 == Directions.UP 
					|| direction3 == Directions.RIGHT || direction3 == Directions.LEFT)) {
				throw new IllegalArgumentException("illegal Move");
			} else {
				this.StrightMove(direction1);
				this.StrightMove(direction2);
				this.DiagonallyMove(direction3);
			}
		}
		/*and the same checking but if it start with diagonally*/
		if(direction1 == Directions.DOWN_LEFT || direction1 == Directions.DOWN_RIGHT 
				|| direction1 == Directions.UP_LEFT || direction1 == Directions.UP_RIGHT) {
			if((direction2 !=  Directions.DOWN_LEFT && direction2 != Directions.DOWN_RIGHT 
					&& direction2 != Directions.UP_LEFT && direction2 != Directions.UP_RIGHT)) {
				throw new IllegalArgumentException("illegal Move");
			}
			else if((direction3 == Directions.DOWN_LEFT || direction3 == Directions.DOWN_RIGHT 
					|| direction3 == Directions.UP_LEFT|| direction3 == Directions.UP_RIGHT)) {
				throw new IllegalArgumentException("illegal Move");
			} else {
				this.DiagonallyMove(direction1);
				this.DiagonallyMove(direction2);
				this.StrightMove(direction3);
			}
		}
		
	}
	public ArrayList<Location> allValidMovesLevel1(Knight knight){
		ArrayList<Location> toReturn =new ArrayList<Location>();
		//System.out.println(knight.getLocation());
		 Location KnightLocation = knight.getLocation();
		 String strX = KnightLocation.getX().toString();
		 String strY = KnightLocation.getY().toString();
		Location loc1 = new Location();
		//System.out.println(strX+" " + strY);
		loc1 = level1Move( Directions.DOWN, Directions.DOWN, Directions.LEFT,strX , strY);
		//System.out.println(loc1);
		//System.out.println(strX+" " + strY);

		toReturn.add(loc1);
		//System.out.println(toReturn);
		Location loc2 = new Location();
		loc2= level1Move( Directions.DOWN, Directions.DOWN, Directions.RIGHT,strX , strY);
		toReturn.add(loc2);
		//System.out.println(toReturn);
        //System.out.println(loc2);

		Location loc3 = new Location(); 
		loc3 = level1Move( Directions.UP, Directions.UP, Directions.LEFT,strX , strY);
		toReturn.add(loc3);
		//System.out.println(toReturn);
        //System.out.println(loc3);

		Location loc4 = new Location();
		loc4 = level1Move( Directions.UP, Directions.UP, Directions.RIGHT,strX , strY);
		toReturn.add(loc4);
		//System.out.println(toReturn);
        //System.out.println(loc4);

		Location loc5 = new Location();
		loc5 = level1Move( Directions.RIGHT, Directions.RIGHT, Directions.DOWN,strX , strY);
		toReturn.add(loc5);
		//System.out.println(toReturn);
        //System.out.println(loc5);

		Location loc6 = new Location();
		loc6 = level1Move( Directions.RIGHT, Directions.RIGHT, Directions.UP,strX , strY);
		toReturn.add(loc6);
		//System.out.println(toReturn);
        //System.out.println(loc6);

		Location loc7 = new Location();
		loc7 = level1Move( Directions.LEFT, Directions.LEFT, Directions.DOWN,strX , strY);
		toReturn.add(loc7);
		//System.out.println(toReturn);
        //System.out.println(loc7);

		Location loc8 = new Location();
		loc8 = level1Move( Directions.LEFT, Directions.LEFT, Directions.UP,strX , strY);
		toReturn.add(loc8);
		//System.out.println(toReturn);
        //System.out.println(loc8);

		return toReturn;
	}
	/*in this two levels the knight move how ever it wants , so
	  we check if the move is a straight move or a diagonally move
	  then we use the right method*/
    public void level3and4Move(Directions dir){
    	switch(dir) {
    	case UP , DOWN , RIGHT , LEFT:{
			this.StrightMove(dir);
			break;
		}
		case UP_LEFT,UP_RIGHT , DOWN_LEFT,DOWN_RIGHT:{
			this.DiagonallyMove(dir);
			break;
		}
			
		}
	}
	}
