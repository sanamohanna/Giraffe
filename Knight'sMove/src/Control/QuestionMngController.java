package Control;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import Enum.DifficultyLevel;
import model.Answer;
import model.Question;
import model.SysData;

public class QuestionMngController {
	private SysData sysData;
	private static QuestionMngController instance;
	//constructor
	public QuestionMngController() {

		// this.questionScreen = new ManageQuestions();
		this.sysData = SysData.getInstance();

	}

	// QuestionMngController Singleton Instance
	public static QuestionMngController getInstance() {
		if (instance == null) {
			instance = new QuestionMngController();
		}
		return instance;
	}

	//SysData Instance Getter
	 
	public SysData getSysData() {
		return sysData;
	}

	// Write Questions To File Including Updated Questions
	
	public void WriteQuestions() {

		JsonArray questions = new JsonArray();
		for (Question q : this.sysData.getQuestions()) {
			JsonObject question = new JsonObject();
			JsonArray answerArray = new JsonArray();
			int correct = 0;

			for (Answer a : q.getAnswers()) {

				if (a.isTrue())
					correct = a.getId();

				answerArray.add(a.getAnswerContext());

			}

			int difficulty = 0;
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
		this.getSysData().getQuestions().clear();

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
		
			int correct = ((JsonObject) element).get("correct_ans").getAsInt();
			int difficulty = ((JsonObject) element).get("level").getAsInt();
			String team = ((JsonObject) element).get("team").getAsString();

			if (!this.sysData.getQuestions().isEmpty()) {
				q = new Question(this.sysData.getQuestions().size(), context, new ArrayList<Answer>(), null, team);
				this.sysData.getQuestions().add(q);

			} else {
				q = new Question(0, context, new ArrayList<Answer>(), null, team);
				this.sysData.getQuestions().add(q);

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

			int correctAnswer_Checker = 0;

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

		this.getSysData().setQuestions(questions);
	
	}

	//Get Questions

	public ArrayList<Question> getQuestions() {
		return this.sysData.getQuestions();
	}

	// removes question that had give id
		public void removeQuestions(int id) {
		this.sysData.removeQuestion(id);
	}

	//Checks if question already exists

	public boolean quesAlreadyExists(String content) {

		for (Question q : this.getSysData().getQuestions()) {
			if (q.getContext().equals(content)) {
				return true;
			}
		}
		return false;
	}

}
