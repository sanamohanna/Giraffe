package model;

import java.util.ArrayList;
import java.util.Objects;

public class AdminPlayer extends Player {
	private String password;
	//constructor
	public AdminPlayer(String nickname, String password) {
		super(nickname);
		this.password = password;
	}
    @Override
	public int hashCode() {
		return Objects.hash(password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminPlayer other = (AdminPlayer) obj;
		return Objects.equals(password, other.password);
	}
	//getters setters
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
