package model;

import java.util.ArrayList;
import java.util.Objects;
import Enum.DifficultyLevel;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Question {

	private Integer Id;
	private String Context;
	private ArrayList<Answer> answers;
	private DifficultyLevel difficultyLevel;
	private String team;
	
	public Question() {
		super();
	}

	public Question(Integer id, String context, ArrayList<Answer> answers, DifficultyLevel level, String team) {
		super();
		this.Id = id;
		this.Context = context;
		this.answers = answers;
		this.difficultyLevel = level;
		this.team = team;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override 
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Id == other.Id;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		this.Id =id;
	}

	public String getContext() {
		return Context;
	}

	public void setContext(String context) {
		this.Context = context;
	}

	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}

	public DifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(DifficultyLevel level) {
		this.difficultyLevel = level;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	// update the answers
	public void updateAnswers(ArrayList<Answer> updatedAnswers) {
		this.answers = new ArrayList<Answer>();

		for (Answer a : updatedAnswers) {
			this.addAnswer(a);
		}
	}
	// return the true answer
	public Integer getCorrectAnswer() {
		for (int i = 0; i < answers.size(); i++) {
			if (answers.get(i).isTrue()) {
				return answers.get(i).getId();
			}
		}
		return -1;
	}
	// add answer
	public Boolean addAnswer(Answer answer) {
		if (answer != null) {
			return this.answers.add(answer);
		}
		return false;
	}
	// delete answer
	public Boolean removeAnswer(Answer answer) {
		if (answer != null) {
			return this.answers.remove(answer);
		}
		return false;

	}

	@Override
	public String toString() {
		return "Question [id=" + Id + ", Context=" + Context + ", answers=" + answers + ", difficultyLevel="
				+ difficultyLevel + ", team=" + team + "]";
	}

}
