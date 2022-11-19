package Control;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



import org.json.*;

import org.json.simple.*;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.jn.easyjson.core.tree.JsonIOException;

import Enum.DifficultyLevel;
import model.Answer;
import model.Question;
import model.SysData;


public class QuestionMngController {
	private SysData sysData;
	private static QuestionMngController instance;
	
	public QuestionMngController() {
		
		//this.questionScreen = new ManageQuestions();
		this.sysData = SysData.getInstance();
		
		
	}
	

	/**
	 * Instance Getter Of QuestionMgmtController
	 * @return instance
	 */
	public static QuestionMngController getInstance() 
	{ 
		if (instance == null) 
		{ 
			instance = new QuestionMngController(); 
		} 
		return instance; 
	}
	/**
	 * SysData Instance Getter
	 */
	public SysData getSysData() {
		return sysData;
	}

	/**
	 * Write Questions To File Including Updated Questions
	 */
	public void WriteQuestions() {

		JSONArray questions = new JSONArray();

		for (Question q : this.sysData.getQuestions()) {

			JSONObject question = new JSONObject();

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
			Writer w = new FileWriter("question_data.json");
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
	
		/**
		 * Load Trivia Questions From JSON File
		 */
		public void LoadQuestions() {

			ArrayList<Question> questions = new ArrayList<Question>();
			if(this.getSysData().getQuestions()!= null)
				this.getSysData().getQuestions().clear();
			
			Gson gson = new Gson();
			JsonReader reader = null;
			try {
				reader = new JsonReader(new FileReader("src/QuestionsAndAnswers.json"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			JsonObject jsonObject = new JsonParser().parse(reader).getAsJsonObject();
			
			final JsonArray data = jsonObject.getAsJsonArray("questions");
			

			for (JsonElement element : data) {

				Question q;

				String context = ((JsonObject) element).get("question").getAsString();

				System.out.println(context);
				JsonArray answersArray = (((JsonObject) element).getAsJsonArray("answers"));
				
				
				ArrayList<String> answers = gson.fromJson(answersArray, ArrayList.class);
				for(String ans :answers ) {
					System.out.println(ans);
				}
				int difficulty = ((JsonObject) element).get("level").getAsInt();
				System.out.println(difficulty);
				int correct = ((JsonObject) element).get("correct_ans").getAsInt();
				System.out.println(correct);
				String team = ((JsonObject) element).get("team").getAsString();
				System.out.println(team);
				if(this.sysData.getQuestions()!=null) {
					System.out.println("x");
				if (  !this.sysData.getQuestions().isEmpty()) {
					System.out.println("y");
					q = new Question(this.sysData.getQuestions().size(), context,new ArrayList<Answer>(), null, team);
					this.sysData.getQuestions().add(q);
					System.out.println(q);	
					} else {
					q = new Question(0, context,  new ArrayList<Answer>(), null, team);
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
				
				
				if(answers.size() < 2) {
					continue;
				}
				
				boolean foundMatching = false;
				for(int i = 0; i < answers.size(); i ++) {
					
					for(int j = 0; j < answers.size(); j++) {
						if( i != j) {
							
							if(answers.get(i).equals(answers.get(j))) {
								
								foundMatching = true;
								break;
								
							}

						}
					
					}
					
					if(foundMatching == true) {
						break;
					}
					
					
				}
				
				if(foundMatching == true) {
					continue;
				}

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
			}
			
			this.getSysData().setQuestions(questions);
			
			

		}
		
		/**
		 * Get Questions
		 * @return - Questions From Model
		 */
		
		public ArrayList<Question> getQuestions(){
			return this.sysData.getQuestions();
		}
		
		/**
		 * removes question that had give id
		 * @param id - question id
		 */
		
		public void removeQuestions(int id){
			 this.sysData.removeQuestion(id);
		}
		
		/**
		 * Checks if question already exists
		 * @param content - question's content
		 * @return true/false
		 */
		
		public boolean quesAlreadyExists(String content) {
			
			for(Question q : this.getSysData().getQuestions()) {
				if(q.getContext().equals(content)) {
					return true;
				}
			}
			return false;
		}
		
	
	
	
}
