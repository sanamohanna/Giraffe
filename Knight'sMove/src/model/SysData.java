package model;


import java.util.ArrayList;

public class SysData {
	private static SysData instance = null;
	private ArrayList<Game> gamesHistory;
	private ArrayList<Question> questions;
	public static SysData getInstance() {
		if (instance == null) 
		{ 
			instance = new SysData(); 
		}
		return instance;
	}


	public ArrayList<Game> getGamesHistory() {
		return gamesHistory;
	}





	public void setGames(ArrayList<Game> games) {
		this.gamesHistory.clear();
		this.gamesHistory = games;
	}





	public ArrayList<Question> getQuestions() {
		return questions;
	}





	public void setQuestions(ArrayList<Question> questions) {
		this.questions.clear();
		this.questions.addAll(questions);
	}

	
	public void	updateQuestion(int id , Question updated_question ) {
		for (Question q : this.getQuestions()) {

			if (q.getId() == id) {
				q.setId(id);
				q.setContext(updated_question.getContext());
				q.setDifficultyLevel(updated_question.getDifficultyLevel());
				q.setTeam(updated_question.getTeam());
				q.updateAnswers(updated_question.getAnswers());
			}
		}

	}
	public void addQuestion(Question q) {

		if (q != null) {
			this.getQuestions().add(q);
		}

	}
	public void	removeQuestion (int id) {
		int i = -1;
		int iterator = 0;

		for (Question q : this.getQuestions()) {

			if (q.getId() == id) {

				i = iterator;
				break;
			}

			iterator++;
		}

		if(i == -1) {
			return;
		}
		for(int c = i + 1 ; c <  this.getQuestions().size(); c++) {
			this.getQuestions().get(c).setId(id);
			id++;

		}
		if (i != -1) {
			this.questions.remove(i);
		}

	}
	public void addGameHistory(Game game){
		if(game!= null) {
			this.getGamesHistory().add(game);
		}
	}
}
