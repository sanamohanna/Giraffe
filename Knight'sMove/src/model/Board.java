package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {
	private Squares[][] boxes;// A list of all the squares that create the board
	private ArrayList<Piece> pieces;// A list of all the pieces currently on the board.
	private static Board instance=null;
	private final int BOARD_SIZE = 8;

	public Board(Squares[][] boxes) {
		super();
		this.boxes = boxes;
	}
	public Board() {
		super();
	}
	//Get the only object available
		public static Board getInstance(){
			
			if (instance == null) 
			{ 
				instance = new Board(); 
			} 
			return instance; 
		}
		public Squares[][] getBoxes() {
			return boxes;
		}
		public void setBoxes(Squares[][] boxes) {
			this.boxes = boxes;
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

/*package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {

//constructor 

	public Board() {
		super();
		squares = new Squares[BOARD_SIZE][BOARD_SIZE];
		pieces = new ArrayList<Piece>();

	}

	







}*/
