package Control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

//import org.json.JSONObject;

import View.MainScreen;
import javafx.application.Application;
import model.Answer;
import model.Question;

public class Main {

	public static void main(String[] args) {
		QuestionMngController Q = new QuestionMngController();
		//Q.LoadQuestions();
		Q.WriteQuestions();

		//Application.launch(MainScreen.class, args);
	}

}
