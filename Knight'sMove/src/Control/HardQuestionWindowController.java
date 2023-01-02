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

public class HardQuestionWindowController implements Initializable{
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
		
		ArrayList<Question> HardQuestions = new ArrayList<Question>();
		SysData.getInstance().LoadQuestions();
		for(int i = 0 ; i<SysData.getInstance().getQuestions().size(); i++){
			if(SysData.getInstance().getQuestions().get(i).getDifficultyLevel() == DifficultyLevel.HARD) {
				HardQuestions.add(SysData.getInstance().getQuestions().get(i));
			}
		}
		Random rand = new Random();
		ques = HardQuestions.get(rand.nextInt(HardQuestions.size()));
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

	    level.setText("HARD QUESTION");
	    level.setFill(Color.RED);
	
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
					StartGameController.points+=3;
			    
			}
			else {
					StartGameController.points-=3;
			}
			
		}
		else if(answer2.isSelected()) {
			selected = true;
			if(answer2.getText().equals(ques.getAnswers().get(trueanswer).getAnswerContext())) {
					StartGameController.points+=3;

			}
			else {
					StartGameController.points-=3;
			
			}
		}
		if(answer3.isSelected()) {
			selected = true;
			if(answer3.getText().equals(ques.getAnswers().get(trueanswer).getAnswerContext())) {
					StartGameController.points+=3;
			}
			else {
					StartGameController.points-=3;
		}
		}
		if(answer4.isSelected()) {
			selected = true;
			if(answer4.getText().equals(ques.getAnswers().get(trueanswer).getAnswerContext())) {
					StartGameController.points+=3;
			}
			else {
					StartGameController.points-=3;
		}
		}
		if(selected == false) {
			throw new Exception();
		}
		StartGameController.stopTimer=1;
		System.out.println(StartGameController.stopTimer);
	    stage.close();

	}catch (Exception e) {
	   
			warningBT.setVisible(true);
	}
		
	}
	
}
