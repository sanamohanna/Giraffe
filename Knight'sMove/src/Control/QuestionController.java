package Control;

import java.io.IOException;
import java.net.URL;
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
	Question ques;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		 SysData.getInstance().LoadQuestions();
		Random rand = new Random();
		ques = SysData.getInstance().getQuestions().get(rand.nextInt(SysData.getInstance().getQuestions().size()));
	    context.setText(ques.getContext());
	    answer1.setText(ques.getAnswers().get(0).getAnswerContext());
	    answer2.setText(ques.getAnswers().get(1).getAnswerContext());
	    answer3.setText(ques.getAnswers().get(2).getAnswerContext());
	    answer4.setText(ques.getAnswers().get(3).getAnswerContext());
	    //this object for selecting one answer
	    ToggleGroup group = new ToggleGroup();
	    
	    answer1.setToggleGroup(group);
	    answer2.setToggleGroup(group);
	    answer3.setToggleGroup(group);
	    answer4.setToggleGroup(group);
	    if(ques.getDifficultyLevel()== DifficultyLevel.HARD) {
	    	level.setText("HARD QUESTION");
	    	level.setFill(Color.RED);
	    }
	    if(ques.getDifficultyLevel()== DifficultyLevel.EASY) {
	    	level.setText("EASY QUESTION");
	    	level.setFill(Color.GREEN);
	    }
	    if(ques.getDifficultyLevel()== DifficultyLevel.MEDIOCRE) {
	    	level.setText("MEDIOCRE QUESTION");
	    	level.setFill(Color.YELLOW);
	    }
	}
	
	public void submit(ActionEvent event) throws Exception {
		Boolean selected = false;
		Stage stage ;

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	
		int trueanswer = 0 ;
		for(int i =0 ; i< ques.getAnswers().size();i++) {
			if(ques.getAnswers().get(i).isTrue()) {
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
