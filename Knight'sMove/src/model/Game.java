package model;

import java.sql.Time;

import Enum.GameStatus;

public class Game {
	private Board board;
	private Player player;
	private Queen queen;
	private King king;
	private GameStatus gameStatus;
	private Time time;

	public Game(Board board, Player player, Queen queen, King king, GameStatus gameStatus, Time time) {
		super();
		this.board = board;
		this.player = player;
		this.queen = queen;
		this.king = king;
		this.gameStatus = gameStatus;
		this.time = time;
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

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
