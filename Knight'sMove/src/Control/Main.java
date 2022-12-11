package Control;

import java.util.ArrayList;
import java.util.Scanner;

import Enum.DifficultyLevel;
import View.MainScreen;
import javafx.application.Application;
import model.Answer;
import model.Question;
import model.SysData;

public class Main {

	public static void main(String[] args) {
		SysData Q = SysData.getInstance();
		Application.launch(MainScreen.class, args); 
		try (Scanner num = new Scanner(System.in)) {
			Integer number = num.nextInt();
		
		 if(number==2) {
				updateQustionFromUser(Q);
			}
			
		}

		
	}

	public static void updateQustionFromUser(SysData sys ) {
		System.out.println("please enter question's number");
		try (Scanner num = new Scanner(System.in)) {
			Integer id = num.nextInt();
			
			ArrayList<Answer> answers = new ArrayList<Answer>();
			try (Scanner s_name = new Scanner(System.in)) {
				System.out.println("please enter the updated question: ");
				String context = s_name.nextLine();
				System.out.print("1) ");
				String answer_1 = s_name.nextLine();
				Answer answer1 =new Answer(1,answer_1,false);
				answers.add(answer1);
				System.out.print("2) ");
				String answer_2 = s_name.nextLine();
				Answer answer2 =new Answer(2,answer_2,true);
				answers.add(answer2);
				System.out.print("3) ");
				String answer_3 = s_name.nextLine();
				Answer answer3 =new Answer(3,answer_3,false);
				answers.add(answer3);
				System.out.print("4) ");
				String answer_4 = s_name.nextLine();
				Answer answer4 =new Answer(4,answer_4,false);
				answers.add(answer4);
				System.out.print("please enter the DifficultyLevel");
				Integer difficultyLevel = s_name.nextInt();
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
				Question qUpdated = new Question(sys.getQuestions().size(), context, answers, dif, "animal");
				sys.LoadQuestions();
				sys.updateQuestion(id, qUpdated);
			}
		}
		sys.WriteQuestions();
	}
	
	
}
