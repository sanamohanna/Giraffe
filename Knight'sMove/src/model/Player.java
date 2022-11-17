package model;

import java.util.ArrayList;

public class Player {

	private String nickname;
	private int points;
	private Knight knight;
	private ArrayList<Game> gamesHistory;
	public Player(String nickname, int points, Knight knight, ArrayList<Game> gamesHistory) {
		super();
		this.nickname = nickname;
		this.points = points;
		this.knight = knight;
		this.gamesHistory = gamesHistory;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Knight getKnight() {
		return knight;
	}
	public void setKnight(Knight knight) {
		this.knight = knight;
	}
	public ArrayList<Game> getGamesHistory() {
		return gamesHistory;
	}
	public void setGamesHistory(ArrayList<Game> gamesHistory) {
		this.gamesHistory = gamesHistory;
	}
	
	
	
}
