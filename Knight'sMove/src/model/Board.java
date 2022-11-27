package model;

public class Board {
	private Squares[][] boxes;

	public Board(Squares[][] boxes) {
		super();
		this.boxes = boxes;
	}

	public Squares[][] getBoxes() {
		return boxes;
	}

	public void setBoxes(Squares[][] boxes) {
		this.boxes = boxes;
	}



}
