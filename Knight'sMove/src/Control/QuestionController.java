package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Random;
import java.util.ResourceBundle;

import Enum.DifficultyLevel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Question;
import model.SysData;

public class QuestionController implements Initializable{
	@FXML
	private Text context;
	@FXML
	private Text level;
	@FXML
	private RadioButton answer1,answer2,answer3,answer4;
	
	@FXML
	private Button sub;
	@FXML 
	private Label warningBT;
	Question ques1;
	Question ques2;
	Question ques3;
	ArrayList<Question> easy = new ArrayList<Question>();
	ArrayList<Question> hard = new ArrayList<Question>();
	ArrayList<Question> mediocre = new ArrayList<Question>();
	int flag = 1;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		 SysData.getInstance().LoadQuestions();
		
		for(int i=0 ; i<SysData.getInstance().getQuestions().size();i++) {
			if(SysData.getInstance().getQuestions().get(i).getDifficultyLevel()==DifficultyLevel.HARD) {
				hard.add(SysData.getInstance().getQuestions().get(i));
			}
			if(SysData.getInstance().getQuestions().get(i).getDifficultyLevel()==DifficultyLevel.MEDIOCRE) {
				mediocre.add(SysData.getInstance().getQuestions().get(i));
			}
			if(SysData.getInstance().getQuestions().get(i).getDifficultyLevel()==DifficultyLevel.EASY) {
				easy.add(SysData.getInstance().getQuestions().get(i));
			}
		}
		Random rand = new Random();
		ques1 =easy.get(rand.nextInt(easy.size()));
		ques2 =mediocre.get(rand.nextInt(mediocre.size()));		
		ques3 =hard.get(rand.nextInt(hard.size()));
			
		
	    context.setText(ques1.getContext());
	    answer1.setText(ques1.getAnswers().get(0).getAnswerContext());
	    answer2.setText(ques1.getAnswers().get(1).getAnswerContext());
	    answer3.setText(ques1.getAnswers().get(2).getAnswerContext());
	    answer4.setText(ques1.getAnswers().get(3).getAnswerContext());
	    
	    context.setText(ques2.getContext());
	    answer1.setText(ques2.getAnswers().get(0).getAnswerContext());
	    answer2.setText(ques2.getAnswers().get(1).getAnswerContext());
	    answer3.setText(ques2.getAnswers().get(2).getAnswerContext());
	    answer4.setText(ques2.getAnswers().get(3).getAnswerContext());
	    
	    context.setText(ques3.getContext());
	    answer1.setText(ques3.getAnswers().get(0).getAnswerContext());
	    answer2.setText(ques3.getAnswers().get(1).getAnswerContext());
	    answer3.setText(ques3.getAnswers().get(2).getAnswerContext());
	    answer4.setText(ques3.getAnswers().get(3).getAnswerContext());
	    //this object for selecting one answer
	    ToggleGroup group = new ToggleGroup();
	    
	    answer1.setToggleGroup(group);
	    answer2.setToggleGroup(group);
	    answer3.setToggleGroup(group);
	    answer4.setToggleGroup(group);
	  
	    if(ques1.getDifficultyLevel()== DifficultyLevel.EASY) {
	    	level.setText("EASY QUESTION");
	    	level.setFill(Color.GREEN);
	    }
	   
	    if(ques2.getDifficultyLevel()== DifficultyLevel.MEDIOCRE) {
	    	level.setText("MEDIOCRE QUESTION");
	    	level.setFill(Color.YELLOW);
	    }
	   
	    if(ques3.getDifficultyLevel()== DifficultyLevel.HARD) {
	    	level.setText("HARD QUESTION");
	    	level.setFill(Color.RED);
	    }
	    
	}
	
	public void submit(ActionEvent event) throws Exception {
		Boolean selected = false;
		Stage stage ;

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	
		int trueanswer = 0 ;
		for(int i =0 ; i< ques1.getAnswers().size();i++) {
			if(ques1.getAnswers().get(i).isTrue()) {
				trueanswer= i;
			}
		}
		for(int i =0 ; i< ques2.getAnswers().size();i++) {
			if(ques2.getAnswers().get(i).isTrue()) {
				trueanswer= i;
			}
		}
		for(int i =0 ; i< ques3.getAnswers().size();i++) {
			if(ques3.getAnswers().get(i).isTrue()) {
				trueanswer= i;
			}
		}
		try {
		if(answer1.isSelected()) {
			selected = true;
			if(answer1.getText().equals(ques.getAnswers().get(trueanswer).getAnswerContext())) {
				if(ques.getDifficultyLevel()== DifficultyLevel.HARD) {
					StartGameController.points+=3;
			    }
				else if(ques.getDifficultyLevel()== DifficultyLevel.EASY) {
			    	StartGameController.points+=1;	
			    	
			    }
			    else{
			    	StartGameController.points+=2;	
			    	
			    }
			}
			else {
				if(ques.getDifficultyLevel()== DifficultyLevel.HARD) {
					StartGameController.points-=3;
			    }
				else if(ques.getDifficultyLevel()== DifficultyLevel.EASY) {
			    	StartGameController.points-=1;
			    	
			    }
				else {
			    	StartGameController.points-=2;
			    	
			    	
			    }
			}
			
		}
		else if(answer2.isSelected()) {
			selected = true;
			if(answer2.getText().equals(ques.getAnswers().get(trueanswer).getAnswerContext())) {
				if(ques.getDifficultyLevel()== DifficultyLevel.HARD) {
					StartGameController.points+=3;

					
			    }
				else if(ques.getDifficultyLevel()== DifficultyLevel.EASY) {
			    	StartGameController.points+=1;	
			    	
			    	}
				else {
			    	StartGameController.points+=2;	
			    	
			    	}
			}
			else {
				if(ques.getDifficultyLevel()== DifficultyLevel.HARD) {
					StartGameController.points-=3;
					
					
			    }
				else if(ques.getDifficultyLevel()== DifficultyLevel.EASY) {
			    	StartGameController.points-=1;	
			    	
			    	}
			    else{
			    	StartGameController.points-=1;	
			    	
			    	}
			}
		}
		if(answer3.isSelected()) {
			selected = true;
			if(answer3.getText().equals(ques.getAnswers().get(trueanswer).getAnswerContext())) {
				if(ques.getDifficultyLevel()== DifficultyLevel.HARD) {
					StartGameController.points+=3;
					
					
			    }
			    else if(ques.getDifficultyLevel()== DifficultyLevel.EASY) {
			    	StartGameController.points+=1;	
			    	
			    	}
			    else{
			    	StartGameController.points+=2;	
			    	}
			}
			else {
				if(ques.getDifficultyLevel()== DifficultyLevel.HARD) {
					StartGameController.points-=3;
					
					
			    }
				else if(ques.getDifficultyLevel()== DifficultyLevel.EASY) {
			    	StartGameController.points-=1;	
			    	}
				else{
			    	StartGameController.points-=2;	
			    	}
			}
		}
		if(answer4.isSelected()) {
			selected = true;
			if(answer4.getText().equals(ques.getAnswers().get(trueanswer).getAnswerContext())) {
				if(ques.getDifficultyLevel()== DifficultyLevel.HARD) {
					StartGameController.points+=3;
					
			    }
				else if(ques.getDifficultyLevel()== DifficultyLevel.EASY) {
			    	StartGameController.points+=1;	
			    	}
				else{
			    	StartGameController.points+=2;	
			    	
			    	}
			}
			else {
				if(ques.getDifficultyLevel()== DifficultyLevel.HARD) {
					StartGameController.points-=3;
					
			    }
				else if(ques.getDifficultyLevel()== DifficultyLevel.EASY) {
			    	StartGameController.points-=1;	
			    	}
			    else {
			    	StartGameController.points-=2;	
			    
			    	}
			}
		}
		if(selected == false) {
			throw new Exception();
		}
	    stage.close();

	}catch (Exception e) {
	   
			warningBT.setVisible(true);
	}
		
	}
	
}
