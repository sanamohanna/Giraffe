    
    package model;

import java.util.ArrayList;

//import java.util.ArrayList;

import Enum.Directions;
import javafx.scene.control.skin.TextInputControlSkin.Direction;

/**
 * 
 * 
 * Class extends from abstract class -> for Template Design Pattern
 * 
 * 
 * **/

public class Queen extends Piece {


	//constructor
	public Queen() {
		super(new Location(7,0));
		
	}
	public double shortestDistance(Location loc1 ,Location loc2) {
		if(loc1.getX()==loc2.getX()) {
			if((loc2.getY()-loc1.getY())<0) {
				return (loc2.getY()-loc1.getY())*-1;
			}
			else {
				return loc2.getY()-loc1.getY();
			}
		}
		else if(loc1.getY()==loc2.getY()) {
			if((loc2.getX()-loc1.getX())<0) {
				return (loc2.getX()-loc1.getX())*-1;
			}
			else {
				return loc2.getX()-loc1.getX();
			}
		}
		else {
				double a ;
				double b;
				double c ;
				if((loc1.getX()-loc2.getX())<0) {
					a = (loc1.getX()-loc2.getX())*-1;
				}
				else {
					a = (loc1.getX()-loc2.getX());
				}
				if((loc1.getY()-loc2.getY())<0) {
					b = (loc1.getY()-loc2.getY())*-1;
				}
				else {
					b = (loc1.getY()-loc2.getY());
				}
				c = a*a + b*b;
				return Math.sqrt(c);
		}
	}
	//this method calculate the shortest distance between two location
	public int StrightMoveQueen(Directions dir) {
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
	public int DiagonallyMoveQueen(Directions dir) {
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

	
    /*this method receiving two parameters , one of the direction of the queen move , 
     and another Integer parameter which it is a number of the square that the queen need to move 
     to catch the knight*/
	public int queenMove(Integer moveNumber , Directions dir) {
		
		switch(dir) {
		case UP , DOWN , RIGHT , LEFT:{
			while(moveNumber !=0 ) {
				if(this.StrightMoveQueen(dir)==0) {
					return 0;
				}
				else {
				 moveNumber--;
				}
			}
		 
			break;
		}
		case UP_LEFT,UP_RIGHT , DOWN_LEFT,DOWN_RIGHT:{
			while(moveNumber !=0 ) {
				if(this.DiagonallyMoveQueen(dir)==0) {
					return 0;
				}
				else {
				 moveNumber--;
				}
			}
			break;
		}
		default:
			break;
			
		}
		return 1;
	}
	public ArrayList<Location> validMovesForQueen(Queen queen){
		ArrayList<Location> toReturn =new ArrayList<Location>();
		Location loc2 = new Location();
		int X = 0 , Y = 0 ;
		X = queen.getLocation().getX();
		Y = queen.getLocation().getY();
		for(int i= 1;i<=8 ; i++) {
			if(queenMove(i,Directions.LEFT)==1) {
				Location loc = new Location();
				for(int j=1;j<=i;j++) {
					X--;
					loc.setX(X);
					loc.setY(Y);
				}
				if(loc.getX() >= 0) {
				toReturn.add(loc);
				}
				X = queen.getLocation().getX();
			}
			if(queenMove(i,Directions.RIGHT)==1) {
				Location loc = new Location();
				for(int j=1;j<=i;j++) {
					X++;
					loc.setX(X);
					loc.setY(Y);
				}
				if(loc.getX() <= 7) {
				toReturn.add(loc);
				}
				X = queen.getLocation().getX();
			}
			if(queenMove(i,Directions.UP)==1) {
				Location loc = new Location();
				for(int j=1;j<=i;j++) {
					Y--;
					loc.setX(X);
					loc.setY(Y);
				}
				if(loc.getY() >= 0) {
				toReturn.add(loc);
				}
				Y = queen.getLocation().getY();
			}
			if(queenMove(i,Directions.DOWN)==1) {
				Location loc = new Location();
				for(int j=1;j<=i;j++) {
					Y++;
					loc.setX(X);
					loc.setY(Y);
				}
				if(loc.getY() <= 7) {
				toReturn.add(loc);
				}
				Y = queen.getLocation().getY();
			}
			if(queenMove(i,Directions.UP_LEFT)==1) {
				Location loc = new Location();
				for(int j=1;j<=i;j++) {
					Y--;
					X--;
					loc.setX(X);
					loc.setY(Y);
				}
				if(loc.getY() >= 0 && loc.getX() >= 0) {
				toReturn.add(loc);
				}
				Y = queen.getLocation().getY();
				X = queen.getLocation().getX();
			}
			if(queenMove(i,Directions.UP_RIGHT)==1) {
				Location loc = new Location();
				for(int j=1;j<=i;j++) {
					Y--;
					X++;
					loc.setX(X);
					loc.setY(Y);
				}
				if(loc.getY() >= 0 && loc.getX() <= 7) {
				toReturn.add(loc);
				}
				Y = queen.getLocation().getY();
				X = queen.getLocation().getX();
			}
			if(queenMove(i,Directions.DOWN_LEFT)==1) {
				Location loc = new Location();
				for(int j=1;j<=i;j++) {
					Y++;
					X--;
					loc.setX(X);
					loc.setY(Y);
				}
				if(loc.getY() <= 7 && loc.getX() >= 0) {
				toReturn.add(loc);
				}
				Y = queen.getLocation().getY();
				X = queen.getLocation().getX();
			}
			if(queenMove(i,Directions.DOWN_RIGHT)==1) {
				Location loc = new Location();
				for(int j=1;j<=i;j++) {
					Y++;
					X++;
					loc.setX(X);
					loc.setY(Y);
				}
				if(loc.getY() <= 7 && loc.getX() <= 7) {
				toReturn.add(loc);
				}
				Y = queen.getLocation().getY();
				X = queen.getLocation().getX();
			}
		}
		return toReturn;
	}
}

    

