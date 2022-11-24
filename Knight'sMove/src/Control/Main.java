package Control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Enum.DifficultyLevel;

//import org.json.JSONObject;

import View.MainScreen;
import javafx.application.Application;
import model.Answer;
import model.Question;

public class Main {

	public static void main(String[] args) {
		ArrayList<Answer> answers = new ArrayList<Answer>();
		QuestionMngController Q = new QuestionMngController();
		Answer answer1 =new Answer(1,"1234",false);
		Answer answer2 =new Answer(2,"1234",true);
		Answer answer3 =new Answer(3,"1234",false);
		Answer answer4 =new Answer(4,"1234",false);
		answers.add(answer1);
		answers.add(answer3);
		answers.add(answer2);
		answers.add(answer4);
		Question q = new Question(Q.getQuestions().size(), "what is the ? ", answers, DifficultyLevel.HARD, "animal");
		Q.LoadQuestions();
		Q.getSysData().addQuestion(q);
		Q.WriteQuestions();
		for (int i = 0; i < Q.getSysData().getQuestions().size(); i++) {
			System.out.println(Q.getSysData().getQuestions().get(i));

		}

		//Application.launch(MainScreen.class, args);
	}

	

}
