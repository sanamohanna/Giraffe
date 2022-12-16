package model;

import java.util.ArrayList;

import Enum.Color;

public class Forgets extends Squares {
	// constructor
	public Forgets(Location location) {
		super(location);
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
