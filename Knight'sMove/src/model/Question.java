package model;

import java.util.ArrayList;

public class Question {

	private int id;
	private String Context;
	private ArrayList<Answer> answers;
	private int level;
	private String team;
	public Question(int id, String context, ArrayList<Answer> answers, int level, String team) {
		super();
		this.id = id;
		Context = context;
		this.answers = answers;
		this.level = level;
		this.team = team;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContext() {
		return Context;
	}
	public void setContext(String context) {
		Context = context;
	}
	public ArrayList<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	public int getCorrectAnswer() {
		for(int i= 0; i< answers.size();i++) {
			if(answers.get(i).isTrue()) {
				return answers.get(i).getId();
			}
		}
		return -1;
	}
	
	public Boolean addAnswer(Answer answer) {
		if(answer != null) {
			return this.answers.add(answer);
		}
		return false;
	}
	
	public Boolean removeAnswer(Answer answer) {
		if(answer != null) {
			return this.answers.remove(answer);
		}
		return false;

	}
}
