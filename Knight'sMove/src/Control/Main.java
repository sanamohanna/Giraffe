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
		SysData Q = new SysData();
		Application.launch(MainScreen.class, args);
	
		System.out.println("please choose what do you want to do:"
				+ "\n1) delete question"
				+ "\n2) update question"
				+ "\n3) add question ");
		try (Scanner num = new Scanner(System.in)) {
			Integer number = num.nextInt();
			if(number==1) {
				deleteQuestionFromUser(Q);
			}
			else if(number==2) {
				updateQustionFromUser(Q);
			}
			else if(number==3) {
				addQustionFromUser( Q );
			}
		}

		
	}
	public static void deleteQuestionFromUser(SysData sys ) {
		System.out.println("please enter question's number");
		try (Scanner num = new Scanner(System.in)) {
			Integer id = num.nextInt();
			sys.LoadQuestions();
			sys.removeQuestion(id);
		}
		sys.WriteQuestions();
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
	public static void addQustionFromUser(SysData sys ) {
		ArrayList<Answer> answers = new ArrayList<Answer>();
		Scanner s_name = new Scanner(System.in);
		System.out.println("please enter the question: ");
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
		Question q = new Question(sys.getQuestions().size(), context, answers, dif, "animal");
		sys.LoadQuestions();
		sys.addQuestion(q);
		sys.WriteQuestions();
		for (int i = 0; i < sys.getQuestions().size(); i++) {
			System.out.println(sys.getQuestions().get(i));

		}
	}
	
}
