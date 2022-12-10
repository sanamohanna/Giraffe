package model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import Enum.GameStatus;

public class Game {
	private static Game instance;

	private Board board;
	private Player player;
	private Knight knight;
	private Queen queen;
	private King king;
	private GameStatus gameStatus;
	private ArrayList<Question> availableQuestions;
	private ArrayList<Question> unavailableQuestions;
	private Integer Points;
	final int WIN_POINT = 1;
	final int LOSE_POINT = 1;
	private Date date ;
	// Game Singleton Instance

	public static Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		return instance;
	}
	// constructor
	public Game(Board board, Player player, Queen queen, King king, GameStatus gameStatus) {
		super();
		this.board = Board.getInstance();
		// we have to start the board
		this.player = player;
		this.queen = queen;
		this.king = king;
		this.date = new Date();
		this.gameStatus = gameStatus;
		availableQuestions = new ArrayList<>();
		availableQuestions.addAll(SysData.getInstance().getQuestions());
		unavailableQuestions = new ArrayList<Question>();

	}
	public Game() {
		super();

	}


	// getters setters
	
	public Game(Player player, Integer points, Date date) {
		super();
		this.player = player;
		Points = points;
		this.date = date;
	}
	public Knight getKnight() {
		return knight;
	}

	public Integer getPoints() {
		return Points;
	}
	public void setPoints(Integer points) {
		Points = points;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setKnight(Knight knight) {
		this.knight = knight;
	}
	public ArrayList<Question> getUnavailableQuestions() {
		return unavailableQuestions;
	}

	public void setUnavailableQuestions(ArrayList<Question> unavailableQuestions) {
		this.unavailableQuestions = unavailableQuestions;
	}
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


}
