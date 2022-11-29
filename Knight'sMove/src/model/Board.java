package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {
	private final int BOARD_SIZE = 8;
	private Squares[][] squares;// A list of all the squares that make up the board
	private ArrayList<Piece> pieces;// A list of all the pieces currently on the board.

	private static Board instance = null;
//constructor 

	public Board() {
		super();
		squares = new Squares[BOARD_SIZE][BOARD_SIZE];
		pieces = new ArrayList<Piece>();

	}

	// Get the only object available
	public static Board getInstance() {

		if (instance == null) {
			instance = new Board();
		}
		return instance;
	}

	public Squares[][] getSquares() {
		return squares;
	}

	public void setSquares(Squares[][] squares) {
		this.squares = squares;
	}

	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}

	public int getBOARD_SIZE() {
		return BOARD_SIZE;
	}

	// method initialized the board
	public void initBasicBoard() {
		for (int i = 0; i <= BOARD_SIZE; i++) {

		}
	}
	// method that return arraylist of locations
	//we will use them when we will indicate which of the squares will be special squares
	//the method will get an integer which is the amount of the location we need according to the level 
	public ArrayList<Location> possibleLocation(int i) {
		HashMap<Integer, Integer> pairs = new HashMap<Integer, Integer>();
		ArrayList<Location> locations = new ArrayList<Location>();
		;

		for (int j = 0; j < i; j++) {
			Integer index1 = (int) (Math.random() * BOARD_SIZE);
			Integer index2 = (int) (Math.random() * BOARD_SIZE);
			if (j != 1 && pairs.containsKey(index1) && pairs.containsValue(index2)) {
				index1 = (int) (Math.random() * BOARD_SIZE);
				index2 = (int) (Math.random() * BOARD_SIZE);
				pairs.put(index1, index2);
			} else {
				pairs.put(index1, index2);
			}
			locations.add(new Location(index1, index2));

		}
		return locations;
	}

}