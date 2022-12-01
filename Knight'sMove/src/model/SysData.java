package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import Enum.DifficultyLevel;

public class SysData {
	private static SysData instance = null;
	private ArrayList<Game> gamesHistory = new ArrayList<Game>();;
	private ArrayList<Question> questions = new ArrayList<Question>();

	
	// SysData Singleton Instance
	public static SysData getInstance() {
		if (instance == null) {
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
	//update question from questions arrayList 
	public void updateQuestion(Integer id, Question updated_question) {
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
	//add question from questions arrayList 
	public void addQuestion(Question q) {

		if (q != null) {
			this.getQuestions().add(q);
		}

	}
    // remove question from questions arrayList 
	public void removeQuestion(Integer id) {
		Integer i = -1;
		Integer iterator = 0;

		for (Question q : this.getQuestions()) {

			if (q.getId() == id) {

				i = iterator;
				break;
			}

			iterator++;
		}

		if (i == -1) {
			return;
		}
		//change the id for all the question after the removed one
		for (int c = i + 1; c < this.getQuestions().size(); c++) {
			this.getQuestions().get(c).setId(id);
			id++;

		}
		if (i != -1) {
			this.questions.remove(i);
		}

	}
	//add game to dame history
	public void addGameHistory(Game game) {
		if (game != null) {
			this.getGamesHistory().add(game);
		}
	}

	// Write Questions To File Including Updated Questions
	
	public void WriteQuestions() {

		JsonArray questions = new JsonArray();
		for (Question q : this.getQuestions()) {
			JsonObject question = new JsonObject();
			JsonArray answerArray = new JsonArray();
			Integer correct = 0;

			for (Answer a : q.getAnswers()) {

				if (a.isTrue())
					correct = a.getId();

				answerArray.add(a.getAnswerContext());

			}

			Integer difficulty = 0;
			if (q.getDifficultyLevel().equals(DifficultyLevel.EASY)) {
				difficulty = 1;
			} else if (q.getDifficultyLevel().equals(DifficultyLevel.MEDIOCRE)) {
				difficulty = 2;
			} else if (q.getDifficultyLevel().equals(DifficultyLevel.HARD)) {
				difficulty = 3;
			}

			question.addProperty("question", q.getContext());
			question.add("answers", answerArray);
			question.addProperty("correct_ans", String.valueOf(correct));

			question.addProperty("level", String.valueOf(difficulty));
			question.addProperty("team", "animal");

			questions.add(question);

		}

		JsonObject root = new JsonObject();
		root.add("questions", questions);

		// write to file

		try {
			Writer w = new FileWriter("src/QuestionsAndAnswers.json");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(root, w);
			w.flush();
			w.close();
			System.out.println("Success");
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Load  Questions From JSON File
	 
	public void LoadQuestions() {

		ArrayList<Question> questions = new ArrayList<Question>();
		this.getQuestions().clear();

		Gson gson = new Gson();
		JsonReader reader = null;
		try {
			reader = new JsonReader(new FileReader("src/QuestionsAndAnswers.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		@SuppressWarnings("deprecation")
		JsonObject jsonObject = new JsonParser().parse(reader).getAsJsonObject();

		final JsonArray data = jsonObject.getAsJsonArray("questions");

		for (JsonElement element : data) {

			Question q;

			String context = ((JsonObject) element).get("question").getAsString();

			JsonArray answersArray = (((JsonObject) element).getAsJsonArray("answers"));

			@SuppressWarnings("unchecked")
			ArrayList<String> answers = gson.fromJson(answersArray, ArrayList.class);
		
			Integer correct = ((JsonObject) element).get("correct_ans").getAsInt();
			Integer difficulty = ((JsonObject) element).get("level").getAsInt();
			String team = ((JsonObject) element).get("team").getAsString();

			if (!this.getQuestions().isEmpty()) {
				q = new Question(this.getQuestions().size(), context, new ArrayList<Answer>(), null, team);
				this.getQuestions().add(q);

			} else {
				q = new Question(0, context, new ArrayList<Answer>(), null, team);
				this.getQuestions().add(q);

			}

			DifficultyLevel diff_level;
			if (difficulty == 1) {
				diff_level = DifficultyLevel.EASY;
			} else if (difficulty == 2) {
				diff_level = DifficultyLevel.MEDIOCRE;
			} else {
				diff_level = DifficultyLevel.HARD;
			}

			q.setDifficultyLevel(diff_level);

			Integer correctAnswer_Checker = 0;

			if (answers.size() < 2) {
				continue;
			}

			boolean MatchingAnswers = false;
			// check if there is two matching answers 
			for (int i = 0; i < answers.size(); i++) {

				for (int j = 0; j < answers.size(); j++) {
					if (i != j) {

						if (answers.get(i).equals(answers.get(j))) {

							MatchingAnswers = true;
							break;

						}

					}

				}

				if (MatchingAnswers == true) {
					break;
				}

			}

			if (MatchingAnswers == true) {
				continue;
			}
			//construct all the answers and indicate the true answers
			for (String s : answers) {
				correctAnswer_Checker++;
				Answer a = null;

				if (correctAnswer_Checker == correct) {
					a = new Answer(correctAnswer_Checker, s, true);
				} else {
					a = new Answer(correctAnswer_Checker, s, false);
				}
				q.addAnswer(a);

			}

			questions.add(q);

		}

		this.setQuestions(questions);
	
	}


	// removes question that had give id
		public void removeQuestions(Integer id) {
		this.removeQuestion(id);
	}

	//Checks if question already exists

	public boolean quesAlreadyExists(String content) {

		for (Question q : this.getQuestions()) {
			if (q.getContext().equals(content)) {
				return true;
			}
		}
		return false;
	}
}
