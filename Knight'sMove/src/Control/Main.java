package Control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

//import org.json.JSONObject;
import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import View.MainScreen;
import javafx.application.Application;
import model.Answer;
import model.Question;

public class Main {

	public static void main(String[] args) {
		QuestionMngController Q = new QuestionMngController();
		Q.LoadQuestions();

		Application.launch(MainScreen.class, args);
	}

}
