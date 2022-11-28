package model;

import java.util.ArrayList;

public class AdminPlayer extends Player {
	private String password;
	//constructor
	public AdminPlayer(String nickname, int points, Knight knight, ArrayList<Game> gamesHistory, String password) {
		super(nickname, points, knight, gamesHistory);
		this.password = password;
	}
    //getters setters
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
