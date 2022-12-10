package model;

import java.util.ArrayList;
import java.util.Objects;

public class Player {

	private String nickname;
	private Integer points;
	private ArrayList<Game> gamesHistory;
	//constructor
	public Player(String nickname) {
		super();
		this.nickname = nickname;
		this.gamesHistory = new ArrayList<Game>();
	}
	@Override
	public int hashCode() {
		return Objects.hash(nickname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(nickname, other.nickname);
	}
	//getters setters
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}


	public ArrayList<Game> getGamesHistory() {
		return gamesHistory;
	}

	public void setGamesHistory(ArrayList<Game> gamesHistory) {
		this.gamesHistory = gamesHistory;
	}

}
