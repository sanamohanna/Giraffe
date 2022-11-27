package model;

import java.util.ArrayList;

import Enum.Directions;

public class Queen extends Piece {

	private Location initialLocation;

	public Queen(Location location, Location initialLocation) {
		super(location);
		this.initialLocation = new Location(7,0);
	}

	public Location getInitialLocation() {
		return initialLocation;
	}
	public void queenMove(int moveNumber , Directions dir) {
		switch(dir) {
		case UP:{
			while(moveNumber !=0 ) {
				this.upMove();
				 moveNumber--;
			}
			break;
		}
		case DOWN:{
			while(moveNumber !=0 ) {
				this.downMove();
				moveNumber--;
			}
			break;
		}
		case LEFT:{
			while(moveNumber !=0 ) {
				this.leftMove();
				 moveNumber--;
			}
			break;
		}
		case RIGHT:{
			while(moveNumber !=0 ) {
				this.rightMove();
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
			
		}

	}
}
