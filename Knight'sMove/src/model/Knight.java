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
		Location loc = new Location(Integer.parseInt(X), Integer.parseInt(Y));
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


	public Location level2Move(Directions direction1 , Directions direction2 ,  Directions direction3 , String X , String Y) {
		/*in this level the knight can move two squares straight and one diagonally or two diagonally and one straight*/
		/*if the knight start with a straight square we check if the 
		 next square is straight and the last one is diagonally*/
		Location loc = new Location(Integer.parseInt(X), Integer.parseInt(Y));
		Knight knight1 = new Knight(loc);
		Location newLoc = new Location();
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
				knight1.StrightMove(direction1);
				knight1.StrightMove(direction2);
				knight1.DiagonallyMove(direction3);
				newLoc=knight1.getLocation();
				return newLoc;
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
				knight1.DiagonallyMove(direction1);
				knight1.DiagonallyMove(direction2);
				knight1.StrightMove(direction3);
				newLoc=knight1.getLocation();
				return newLoc;
			}
		}
		return newLoc;
		
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
    public ArrayList<Location> allValidMovesLevel1(Knight knight){
		ArrayList<Location> toReturn =new ArrayList<Location>();
		//System.out.println(knight.getLocation());
		 Location KnightLocation = knight.getLocation();
		 String strX = KnightLocation.getX().toString();
		 String strY = KnightLocation.getY().toString();
		Location loc1 = new Location();
		loc1 = level1Move( Directions.DOWN, Directions.DOWN, Directions.LEFT,strX , strY);
		toReturn.add(loc1);

		Location loc2 = new Location();
		loc2= level1Move( Directions.DOWN, Directions.DOWN, Directions.RIGHT,strX , strY);
		toReturn.add(loc2);

		Location loc3 = new Location(); 
		loc3 = level1Move( Directions.UP, Directions.UP, Directions.LEFT,strX , strY);
		toReturn.add(loc3);

		Location loc4 = new Location();
		loc4 = level1Move( Directions.UP, Directions.UP, Directions.RIGHT,strX , strY);
		toReturn.add(loc4);


		Location loc5 = new Location();
		loc5 = level1Move( Directions.RIGHT, Directions.RIGHT, Directions.DOWN,strX , strY);
		toReturn.add(loc5);

		Location loc6 = new Location();
		loc6 = level1Move( Directions.RIGHT, Directions.RIGHT, Directions.UP,strX , strY);
		toReturn.add(loc6);

		Location loc7 = new Location();
		loc7 = level1Move( Directions.LEFT, Directions.LEFT, Directions.DOWN,strX , strY);
		toReturn.add(loc7);

		Location loc8 = new Location();
		loc8 = level1Move( Directions.LEFT, Directions.LEFT, Directions.UP,strX , strY);
		toReturn.add(loc8);

		return toReturn;
	}
	public ArrayList<Location> allValidMovesLevel2(Knight knight){
		ArrayList<Location> toReturn =new ArrayList<Location>();
		//System.out.println(knight.getLocation());
		 Location KnightLocation = knight.getLocation();
		 String strX = KnightLocation.getX().toString();
		 String strY = KnightLocation.getY().toString();
		Location loc1 = new Location();
		loc1 = level2Move( Directions.DOWN, Directions.DOWN, Directions.DOWN_LEFT,strX , strY);
		toReturn.add(loc1);
		
		Location loc2 = new Location();
		loc2 = level2Move( Directions.DOWN, Directions.DOWN, Directions.DOWN_RIGHT,strX , strY);
		toReturn.add(loc2);
		
		Location loc3 = new Location();
		loc3 = level2Move( Directions.DOWN, Directions.DOWN, Directions.UP_RIGHT,strX , strY);
		toReturn.add(loc3);
		
		Location loc4 = new Location();
		loc4 = level2Move( Directions.DOWN, Directions.DOWN, Directions.UP_LEFT,strX , strY);
		toReturn.add(loc4);
		
		Location loc5 = new Location();
		loc5 = level2Move( Directions.UP, Directions.UP, Directions.DOWN_LEFT,strX , strY);
		toReturn.add(loc5);
		
		Location loc6 = new Location();
		loc6 = level2Move( Directions.UP, Directions.UP, Directions.DOWN_RIGHT,strX , strY);
		toReturn.add(loc6);
		
		Location loc7 = new Location();
		loc7 = level2Move( Directions.UP, Directions.UP, Directions.UP_RIGHT,strX , strY);
		toReturn.add(loc7);
		
		Location loc8 = new Location();
		loc8 = level2Move( Directions.UP, Directions.UP, Directions.UP_LEFT,strX , strY);
		toReturn.add(loc8);
		
		Location loc9 = new Location();
		loc9 = level2Move( Directions.LEFT, Directions.LEFT, Directions.DOWN_LEFT,strX , strY);
		toReturn.add(loc9);
		
		Location loc10 = new Location();
		loc10 = level2Move( Directions.LEFT, Directions.LEFT, Directions.DOWN_RIGHT,strX , strY);
		toReturn.add(loc10);
		
		Location loc11 = new Location();
		loc11 = level2Move( Directions.LEFT, Directions.LEFT, Directions.UP_RIGHT,strX , strY);
		//toReturn.add(loc11);
		
		Location loc12 = new Location();
		loc12 = level2Move( Directions.LEFT, Directions.LEFT, Directions.UP_LEFT,strX , strY);
		//toReturn.add(loc12);
		
		Location loc13 = new Location();
		loc13 = level2Move( Directions.RIGHT, Directions.RIGHT, Directions.DOWN_LEFT,strX , strY);
		toReturn.add(loc13);
		
		Location loc14 = new Location();
		loc14 = level2Move( Directions.RIGHT, Directions.RIGHT, Directions.DOWN_RIGHT,strX , strY);
		toReturn.add(loc14);
		
		Location loc15 = new Location();
		loc15 = level2Move( Directions.RIGHT, Directions.RIGHT, Directions.UP_RIGHT,strX , strY);
		//toReturn.add(loc15);
		
		Location loc16 = new Location();
		loc16 = level2Move( Directions.RIGHT, Directions.RIGHT, Directions.UP_LEFT,strX , strY);
		//toReturn.add(loc16);
		
		
		Location loc17 = new Location();
		loc17 = level2Move( Directions.DOWN_LEFT, Directions.DOWN_LEFT, Directions.LEFT,strX , strY);
		toReturn.add(loc17);
		
		Location loc18 = new Location();
		loc18 = level2Move( Directions.DOWN_LEFT, Directions.DOWN_LEFT, Directions.DOWN,strX , strY);
		toReturn.add(loc18);
		
		Location loc19 = new Location();
		loc19 = level2Move( Directions.DOWN_LEFT, Directions.DOWN_LEFT, Directions.RIGHT,strX , strY);
		toReturn.add(loc19);
		
		Location loc20 = new Location();
		loc20 = level2Move( Directions.DOWN_LEFT, Directions.DOWN_LEFT, Directions.UP,strX , strY);
		toReturn.add(loc20);
		
		Location loc21 = new Location();
		loc21 = level2Move( Directions.DOWN_RIGHT, Directions.DOWN_RIGHT, Directions.LEFT,strX , strY);
		toReturn.add(loc21);
		
		Location loc22 = new Location();
		loc22 = level2Move( Directions.DOWN_RIGHT, Directions.DOWN_RIGHT, Directions.DOWN,strX , strY);
		toReturn.add(loc22);
		
		Location loc23 = new Location();
		loc23 = level2Move( Directions.DOWN_RIGHT, Directions.DOWN_RIGHT, Directions.RIGHT,strX , strY);
		toReturn.add(loc23);
		
		Location loc24 = new Location();
		loc24 = level2Move( Directions.DOWN_RIGHT, Directions.DOWN_RIGHT, Directions.UP,strX , strY);
		toReturn.add(loc24);
		
		Location loc25 = new Location();
		loc25 = level2Move( Directions.UP_LEFT, Directions.UP_LEFT, Directions.LEFT,strX , strY);
		//toReturn.add(loc25);
		
		Location loc26 = new Location();
		loc26 = level2Move( Directions.UP_LEFT, Directions.UP_LEFT, Directions.DOWN,strX , strY);
		//toReturn.add(loc26);
		
		Location loc27 = new Location();
		loc27 = level2Move( Directions.UP_LEFT, Directions.UP_LEFT, Directions.RIGHT,strX , strY);
		//toReturn.add(loc27);
		
		Location loc28 = new Location();
		loc28 = level2Move( Directions.UP_LEFT, Directions.UP_LEFT, Directions.UP,strX , strY);
		//toReturn.add(loc28);
		
		Location loc29 = new Location();
		loc29 = level2Move( Directions.UP_RIGHT, Directions.UP_RIGHT, Directions.LEFT,strX , strY);
		//toReturn.add(loc29);
		
		Location loc30 = new Location();
		loc30 = level2Move( Directions.UP_RIGHT, Directions.UP_RIGHT, Directions.DOWN,strX , strY);
		//toReturn.add(loc30);
		
		Location loc31 = new Location();
		loc31 = level2Move( Directions.UP_RIGHT, Directions.UP_RIGHT, Directions.RIGHT,strX , strY);
		//toReturn.add(loc31);
		
		Location loc32 = new Location();
		loc32 = level2Move( Directions.UP_RIGHT, Directions.UP_RIGHT, Directions.UP,strX , strY);
		//toReturn.add(loc32);
		return toReturn;
	}
	}
