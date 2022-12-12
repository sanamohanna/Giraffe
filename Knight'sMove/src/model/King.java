package model;

//import java.util.ArrayList;

public class King extends Piece {
	
	private Integer speed;


	public King(Integer speed) {
		super(new Location(7,0));
		this.speed = speed;
	}


	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	public void kingMove() {
		
	}


}
