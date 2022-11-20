package model;

import java.util.ArrayList;

public class AdminPlayer extends Player {
	private String password;

	public AdminPlayer(String nickname, int points, Knight knight, ArrayList<Game> gamesHistory, String password) {
		super(nickname, points, knight, gamesHistory);
		this.password = password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
