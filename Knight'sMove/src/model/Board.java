package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Board {
	private final int BOARD_SIZE = 8;
	private Squares[][] squares;// A list of all the squares that make up the board
	private ArrayList<Piece> pieces;// A list of all the pieces currently on the board.

	private static Board instance = null;
	
	// Get the only object available
		public static Board getInstance() {

			if (instance == null) {
				instance = new Board();
			}
			return instance;
		}
		//constructor 
	public Board() {
		super();
		squares = new Squares[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < squares.length; i++)
		    for (int j = 0; j < squares[i].length; j++)
		    {
		       Location loc = new Location(i,j);
		       squares[i][j].setVisited(false);
		       squares[i][j].setLocation(loc);
		    }
		pieces = new ArrayList<Piece>();

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
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + BOARD_SIZE;
		result = prime * result + ((pieces == null) ? 0 : pieces.hashCode());
		result = prime * result + Arrays.deepHashCode(squares);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (BOARD_SIZE != other.BOARD_SIZE)
			return false;
		if (pieces == null) {
			if (other.pieces != null)
				return false;
		} else if (!pieces.equals(other.pieces))
			return false;
		if (!Arrays.deepEquals(squares, other.squares))
			return false;
		return true;
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
