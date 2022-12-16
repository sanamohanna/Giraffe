package model;

import java.util.ArrayList;

import Enum.Color;

<<<<<<< Updated upstream
public class Forgets  extends Squares{
	//constructor
	public Forgets(Location location) {
		super(location);
=======
public class Forgets extends Squares {
	// constructor
	public Forgets(Piece peice, Location location, Color color) {
		super(peice, location, color);
>>>>>>> Stashed changes
		// TODO Auto-generated constructor stub
	}

	public void handleLastThreeSteps(ArrayList<Squares> knightMoves) {
		for (int i = 0; i < knightMoves.size(); i++) {
			if (knightMoves.get(i).getClass().getName() == "Squares") {
				// צריך להפריד בין שני מקרים משבצת שביקר בה מקודם ומשבצת שלא

			} else if (knightMoves.get(i).getClass().getName() == "RandomJump") {

			}

		}
	}

}
