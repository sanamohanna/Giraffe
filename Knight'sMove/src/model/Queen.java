//    package model;
//
////import java.util.ArrayList;
//
//import Enum.Directions;
//import javafx.scene.control.Alert.AlertType;
//
///**
// * 
// * 
// * Class extends from abstract class -> for Template Design Pattern
// * 
// * 
// * **/
//
//public class Queen extends Piece {
//
//
//	//constructor
//	public Queen() {
//		super(new Location(7,0));
//		
//	}
//	
//	//this method calculate the shortest distance between two location
//	public int shortestDistance(Location loc1 ,Location loc2) {
//		if(loc1.getX()==loc2.getX()) {
//			if((loc2.getY()-loc1.getY())<0) {
//				return (loc2.getY()-loc1.getY())*-1;
//			}
//			else {
//				return loc2.getY()-loc1.getY();
//			}
//			}
//		else if(loc1.getY()==loc2.getY()) {
//			if((loc2.getX()-loc1.getX())<0) {
//				return (loc2.getX()-loc1.getX())*-1;
//			}
//			else {
//				return loc2.getX()-loc1.getX();
//			}
//		}
//		else {
//				int a ;
//				int b;
//				int c ;
//				if((loc1.getX()-loc2.getX())<0) {
//					a = (loc1.getX()-loc2.getX())*-1;
//				}
//				else {
//					a = (loc1.getX()-loc2.getX());
//				}
//				if((loc1.getY()-loc2.getY())<0) {
//					b = (loc1.getY()-loc2.getY())*-1;
//				}
//				else {
//					b = (loc1.getY()-loc2.getY());
//				}
//				c = a*a + b*b;
//				return (int) Math.sqrt(c);
//			}
//		
//	}
//	
//	public int StrightMove(Directions dir) {
//	switch (dir) {
//	/* here is the location changes in case the piece moved up */
//	/*
//	* in case the piece is on the last square of the board sides , return 0;
//	*/
//		case UP: {
//			if (this.getLocation().getY() == 0) {
//				return 0;
//			}
//			break;
//			}
//		/* here is the location changes in case the piece moved down */
//		case DOWN: {
//			if (this.getLocation().getY() == 7) {
//				return 0;
//			}
//			break;
//		}
//		/* here is the location changes in case the piece moved right */
//		case RIGHT: {
//			if (this.getLocation().getX() == 7) {
//				return 0;
//			} 
//			break;
//		}
//		/* here is the location changes in case the piece moved left */
//		case LEFT: {
//			if (this.getLocation().getX() == 0) {
//				return 0;
//			} 
//			break;
//		}
//		default:
//			break;
//		}
//		return 1;
//	}
//	public int DiagonallyMove(Directions dir) {
//	/* the different cases it's about the direction that the slant goes */
//	/*
//	* in case the piece is on the last square of the board sides , it goes to the
//	* first square in the same line
//	*/
//		try {
//			switch (dir) {
//			case UP_LEFT: {
//				if (this.getLocation().getX() == 0 && this.getLocation().getY() > 0) {
//					return 0; 
//				} else if (this.getLocation().getY() == 0) {
//					return 0;
//				} 
//				break;
//			}
//			case UP_RIGHT: {
//				if (this.getLocation().getX() == 7 && this.getLocation().getY() > 0) {
//					return 0; 
//				} 
//				else if (this.getLocation().getY() == 0) {
//					return 0; 
//				}
//				break;
//			}
//			// ?????
//			case DOWN_LEFT: {
//				if (this.getLocation().getX() == 0 && this.getLocation().getY() < 7) {
//					return 0;
//				} 
//				else if (this.getLocation().getY() == 7) {	
//					return 0;
//				}
//				break;
//			}
//			case DOWN_RIGHT: {
//				if (this.getLocation().getX() == 7 && this.getLocation().getY() < 7) {
//					return 0;
//				} 	
//				else if (this.getLocation().getY() == 7) {
//					return 0;
//				} 
//				break;
//			}
//			default:
//				break;
//			}
//		}
//		catch(IllegalArgumentException e){
//			a.setAlertType(AlertType.ERROR);//if the user not enter data 
//			a.setContentText("please enter all data!");
//			a.show(); 
//		}
//		return 1;
//	}
//	/*this method receiving two parameters , one of the direction of the queen move , 
//	and another Integer parameter which it is a number of the square that the queen need to move 
//	to catch the knight*/
//	public int queenMove(Integer moveNumber , Directions dir) {
//		switch(dir) {
//			case UP :{
//				while(moveNumber !=0 ) {
//					if(this.StrightMove(dir)==1) {
//						this.getLocation().setY(this.getLocation().getY() - 1);
//						moveNumber--;
//					}
//					else {
//						return 0 ; 
//					}
//				}
//				break;
//			}
//			case DOWN:{
//				while(moveNumber !=0 ) {
//					if(this.StrightMove(dir)==1) {
//						this.getLocation().setY(this.getLocation().getY() + 1);
//						moveNumber--;
//					}
//					else {
//						return 0 ; 
//					}
//					}
//				break;
//			}
//			case RIGHT:{
//				while(moveNumber !=0 ) {
//					if(this.StrightMove(dir)==1) {
//						this.getLocation().setX(this.getLocation().getX() + 1);
//						moveNumber--;
//					}
//					else {
//						return 0 ; 
//					}
//				}
//				break;
//			}
//			case LEFT:{
//				while(moveNumber !=0 ) {
//					if(this.StrightMove(dir)==1) {
//						this.getLocation().setX(this.getLocation().getX() - 1); 
//						moveNumber--;
//					}
//					else {
//						return 0 ; 
//					}
//				}
//				break;
//			}
//			case UP_LEFT:{
//				while(moveNumber !=0 ) {
//					if(this.DiagonallyMove(dir)==1) {
//						this.getLocation().setX(this.getLocation().getX() - 1);
//						this.getLocation().setY((this.getLocation().getY()) - 1);
//						moveNumber--;
//					}
//				}
//				break;
//			}
//			case UP_RIGHT:{
//				while(moveNumber !=0 ) {
//					if(this.DiagonallyMove(dir)==1) {
//						this.getLocation().setX(this.getLocation().getX() + 1);
//						this.getLocation().setY((this.getLocation().getY()) - 1);
//						moveNumber--;
//					}
//			}
//			break;
//			}
//			case DOWN_LEFT:{
//				while(moveNumber !=0 ) {
//					if(this.DiagonallyMove(dir)==1) {
//						this.getLocation().setX(this.getLocation().getX() - 1);
//						this.getLocation().setY((this.getLocation().getY()) + 1);
//						moveNumber--;
//					}
//				}
//				break;
//			}
//			case DOWN_RIGHT:{
//				while(moveNumber !=0 ) {
//					if(this.DiagonallyMove(dir)==1) {
//						this.getLocation().setX(this.getLocation().getX() + 1);
//						this.getLocation().setY((this.getLocation().getY()) + 1);
//						moveNumber--;
//					}
//				}
//				break;
//			}
//			default:
//				break;
//		}
//		return 1;
//	}
//
//	//this method return the "favorite" location to the queen 
//	public Location queenMove2(Location location) {
//		Location toReturn = null;
//		Location locQueen =new Location(7,0);
//		int shortestDistance =12;
//		for(int i = 1; i <= 7;i++) {
//			this.setLocation(locQueen);
//		//	System.out.println(i);
////			System.out.println(this.getLocation().getX());
////			System.out.println(this.getLocation().getY());
//			if(queenMove(i,Directions.DOWN)!=0) {
////				System.out.println(this.getLocation().getX());
////				System.out.println(this.getLocation().getY());
//				if(location.equals(this.getLocation())) {
//					return this.getLocation();
//				}
//				if(shortestDistance(location,this.getLocation())<shortestDistance) {
//					shortestDistance=shortestDistance(location,this.getLocation());
//					toReturn = this.getLocation();
//					System.out.println(shortestDistance);
//				}
//			}
//		}
//		this.setLocation(locQueen);
////		for(int i = 1; i <= 8;i++) {
////			if(queenMove(i,Directions.LEFT)!=0) {
////				if(location.equals(this.getLocation())) {
////					return this.getLocation();
////				}
////				if(shortestDistance(location,this.getLocation())<shortestDistance) {
////					shortestDistance=shortestDistance(location,this.getLocation());
////					toReturn = this.getLocation();
////					//System.out.println(shortestDistance);
////				}
////				
////			}
////			
////			this.setLocation(locQueen);
////		}
////			if(queenMove(i,Directions.RIGHT)!=0) {
////				if(location.equals(this.getLocation())) {
////					return this.getLocation();
////				}
////				if(shortestDistance(location,this.getLocation())<shortestDistance) {
////					shortestDistance=shortestDistance(location,this.getLocation());
////					toReturn = this.getLocation();
////				}
////				this.setLocation(locQueen);
////			}
////			this.setLocation(locQueen);
////			if(queenMove(i,Directions.UP)!=0) {
////				if(location.equals(this.getLocation())) {
////					return this.getLocation();
////				}
////				if(shortestDistance(location,this.getLocation())<shortestDistance) {
////					shortestDistance=shortestDistance(location,this.getLocation());
////					toReturn = this.getLocation();
////				}
////				this.setLocation(locQueen);
////			}
////			this.setLocation(locQueen);
////			if(queenMove(i,Directions.UP_LEFT)!=0) {
////				if(location.equals(this.getLocation())) {
////					return this.getLocation();
////				}
////				if(shortestDistance(location,this.getLocation())<shortestDistance) {
////					shortestDistance=shortestDistance(location,this.getLocation());
////					toReturn = this.getLocation();
////				}
////				this.setLocation(locQueen);
////			}
////			this.setLocation(locQueen);
////			if(queenMove(i,Directions.DOWN_LEFT)!=0) {
////				if(location.equals(this.getLocation())) {
////					return this.getLocation();
////				}
////				if(shortestDistance(location,this.getLocation())<shortestDistance) {
////					shortestDistance=shortestDistance(location,this.getLocation());
////					toReturn = this.getLocation();
////				}
////				this.setLocation(locQueen);
////			}
////			this.setLocation(locQueen);
////			if(queenMove(i,Directions.UP_RIGHT)!=0) {
////				if(location.equals(this.getLocation())) {
////					return this.getLocation();
////				}
////				if(shortestDistance(location,this.getLocation())<shortestDistance) {
////					shortestDistance=shortestDistance(location,this.getLocation());
////					toReturn = this.getLocation();
////				}
////				this.setLocation(locQueen);
////			}
////			this.setLocation(locQueen);
////			if(queenMove(i,Directions.DOWN_RIGHT)!=0) {
////				if(location.equals(this.getLocation())) {
////					return this.getLocation();
////				}
////				if(shortestDistance(location,this.getLocation())<shortestDistance) {
////					shortestDistance=shortestDistance(location,this.getLocation());
////					toReturn = this.getLocation();
////				}
////				this.setLocation(locQueen);
////			}
////			this.setLocation(locQueen);
//		
//		return toReturn;
//	}
//	
//
//
//}
//
//    
    package model;

//import java.util.ArrayList;

import Enum.Directions;

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
	public int shortestDistance(Location loc1 ,Location loc2) {
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
				int a ;
				int b;
				int c ;
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
				return (int) Math.sqrt(c);
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

	
    /*this method receiving two parameters , one of the direction of the queen move , 
     and another Integer parameter which it is a number of the square that the queen need to move 
     to catch the knight*/
	public void queenMove(Integer moveNumber , Directions dir) {
		switch(dir) {
		case UP , DOWN , RIGHT , LEFT:{
			while(moveNumber !=0 ) {
				this.StrightMove(dir);
				 moveNumber--;
			}
			break;
		}
		case UP_LEFT,UP_RIGHT , DOWN_LEFT,DOWN_RIGHT:{
			while(moveNumber !=0 ) {
				this.DiagonallyMove(dir);
				 moveNumber--;
			}
			break;
		}
		default:
			throw new IllegalArgumentException("illegal Move");
			
		}

	}
}

    

