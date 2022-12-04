package model;

import java.sql.Time;
import java.util.ArrayList;

import Enum.GameStatus;

public class Game {
	private static Game instance;
	
	private Board board;
	private Player player;
	private Queen queen;
	private King king;
	private GameStatus gameStatus;
	private TimerCount time;
	private ArrayList<Question> availableQuestions;
	private ArrayList<Question> unavailableQuestions;

	//constructor
	public Game(Board board, Player player, Queen queen, King king, GameStatus gameStatus, Time time) {
		super();
		this.board = Board.getInstance();
		//we have to start the board
		this.player = player;
		this.queen = queen;
		this.king = king;
		this.gameStatus = gameStatus;
		this.time = new TimerCount();
		availableQuestions = new ArrayList<>();
		availableQuestions.addAll(SysData.getInstance().getQuestions());
		unavailableQuestions=new ArrayList<Question>();

	}
	public Game() {
		super();
		
	}
	// Game Singleton Instance
	 
	public static Game getInstance() 
	{ 
		if (instance == null) 
		{ 
			instance = new Game(); 
		} 
		return instance; 
	}
	//getters setters
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Queen getQueen() {
		return queen;
	}

	public void setQueen(Queen queen) {
		this.queen = queen;
	}

	public King getKing() {
		return king;
	}

	public void setKing(King king) {
		this.king = king;
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

	public TimerCount getTime() {
		return time;
	}

	public void setTime(TimerCount time) {
		this.time = time;
	}

}
