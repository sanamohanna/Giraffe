package Control;


import java.util.ArrayList;
import java.util.Scanner;

import Enum.DifficultyLevel;



import View.MainScreen;
import javafx.application.Application;
import model.Answer;
import model.Question;

public class Main {

	public static void main(String[] args) {
		ArrayList<Answer> answers = new ArrayList<Answer>();
		QuestionMngController Q = new QuestionMngController();
		Scanner s_name = new Scanner(System.in);
		System.out.println("please enter the question: ");
		String context = s_name.nextLine();
		System.out.print("1) ");
		String answer_1 = s_name.nextLine();
		Answer answer1 =new Answer(1,answer_1,false);
		System.out.print("2) ");
		String answer_2 = s_name.nextLine();
		Answer answer2 =new Answer(2,answer_2,true);
		System.out.print("3) ");
		String answer_3 = s_name.nextLine();
		Answer answer3 =new Answer(3,answer_3,false);
		System.out.print("4) ");
		String answer_4 = s_name.nextLine();
		Answer answer4 =new Answer(4,answer_4,false);
		answers.add(answer1);
		answers.add(answer3);
		answers.add(answer2);
		answers.add(answer4);
		System.out.print("please enter the DifficultyLevel");
		int difficultyLevel = s_name.nextInt();
		DifficultyLevel dif = null;
		if(difficultyLevel== 3) {
			 dif = DifficultyLevel.HARD;
		}
		else if(difficultyLevel== 1) {
			 dif = DifficultyLevel.EASY;
		}
		else if(difficultyLevel== 2)
		{
			 dif = DifficultyLevel.MEDIOCRE;
			
		}
		Question q = new Question(Q.getQuestions().size(), context, answers, dif, "animal");
		Q.LoadQuestions();
		Q.getSysData().addQuestion(q);
		Q.WriteQuestions();
		for (int i = 0; i < Q.getSysData().getQuestions().size(); i++) {
			System.out.println(Q.getSysData().getQuestions().get(i));

		}

		Application.launch(MainScreen.class, args);
	}

	

}
