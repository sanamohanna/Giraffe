package model;

//import java.util.ArrayList;

import Enum.Directions;

public class Queen extends Piece {


	public Queen() {
		super(new Location(7,0));
		
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
