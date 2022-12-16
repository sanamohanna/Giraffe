package model;

import java.time.LocalDate;
import java.util.ArrayList;


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
	private LocalDate date ;
	
	// constructor
	public Game(Board board, Player player, Queen queen, King king, GameStatus gameStatus) {
		super();
		this.board = Board.getInstance();
		// we have to start the board
		this.player = player;
		this.queen = queen;
		this.king = king;
		this.date =LocalDate.now();
		this.gameStatus = gameStatus;
		availableQuestions = new ArrayList<>();
		availableQuestions.addAll(SysData.getInstance().getQuestions());
		unavailableQuestions = new ArrayList<Question>();

	}
	public Game() {
		super();
		knight=new Knight(false);
		queen = new Queen();
	}


	// getters setters
	
	public Game(Player player, Integer points) {
		super();
		this.player = player;
		Points = points;
		this.date = LocalDate.now();
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + LOSE_POINT;
		result = prime * result + ((Points == null) ? 0 : Points.hashCode());
		result = prime * result + WIN_POINT;
		result = prime * result + ((availableQuestions == null) ? 0 : availableQuestions.hashCode());
		result = prime * result + ((board == null) ? 0 : board.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((gameStatus == null) ? 0 : gameStatus.hashCode());
		result = prime * result + ((king == null) ? 0 : king.hashCode());
		result = prime * result + ((knight == null) ? 0 : knight.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + ((queen == null) ? 0 : queen.hashCode());
		result = prime * result + ((unavailableQuestions == null) ? 0 : unavailableQuestions.hashCode());
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
		Game other = (Game) obj;
		if (LOSE_POINT != other.LOSE_POINT)
			return false;
		if (Points == null) {
			if (other.Points != null)
				return false;
		} else if (!Points.equals(other.Points))
			return false;
		if (WIN_POINT != other.WIN_POINT)
			return false;
		if (availableQuestions == null) {
			if (other.availableQuestions != null)
				return false;
		} else if (!availableQuestions.equals(other.availableQuestions))
			return false;
		if (board == null) {
			if (other.board != null)
				return false;
		} else if (!board.equals(other.board))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (gameStatus != other.gameStatus)
			return false;
		if (king == null) {
			if (other.king != null)
				return false;
		} else if (!king.equals(other.king))
			return false;
		if (knight == null) {
			if (other.knight != null)
				return false;
		} else if (!knight.equals(other.knight))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (queen == null) {
			if (other.queen != null)
				return false;
		} else if (!queen.equals(other.queen))
			return false;
		if (unavailableQuestions == null) {
			if (other.unavailableQuestions != null)
				return false;
		} else if (!unavailableQuestions.equals(other.unavailableQuestions))
			return false;
		return true;
	}
	
	


}
