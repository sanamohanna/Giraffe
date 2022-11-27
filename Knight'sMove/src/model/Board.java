package model;

public class Board {
	private char[][] gameBoard;

	public Board(char[][] boxes) {
		super();
		this.boxes = boxes;
	}

	public char[][] getBoxes() {
		return boxes;
	}

	public void setBoxes(char[][] boxes) {
		this.boxes = boxes;
	}

}
