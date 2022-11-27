package model;

public class Board {
	private Squares[][] boxes;
	private static Board instance=null;
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



}
