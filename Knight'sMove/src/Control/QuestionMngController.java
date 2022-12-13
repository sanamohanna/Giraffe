    package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Enum.DifficultyLevel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Answer;
import model.Question;
import model.SysData;

public class QuestionMngController implements Initializable {
    // Declare javaFX Variables
	// Variables named in sceneBuilder 
	@FXML
	private TableView<Question> table;
	@FXML
	private TextField context;
	@FXML
	private TextField answer1;
	@FXML
	private TextField answer2;
	@FXML
	private TextField answer3;
	@FXML
	private TextField answer4;
	@FXML
	private TextField team;
	@FXML
	private ChoiceBox<Integer> difLevel  ;
	@FXML
	private ChoiceBox<Integer> trueAnswer;
	@FXML
	private Button add;
	@FXML
	private Button addQues;
	@FXML
	private TextField textF;
	@FXML
	private Button delete;
	@FXML
	private Button deleteQues;
	@FXML
	private Text true1;
	@FXML
	private Text diff1;
	@FXML
	private TextField contextUpdated;
	@FXML
	private TextField answer1Updated;
	@FXML
	private TextField answer2Updated;
	@FXML
	private TextField answer3Updated;
	@FXML
	private TextField answer4Updated;
	@FXML
	private TextField teamUpdated;
	@FXML
	private ChoiceBox<Integer> difLevelUpdated  ;
	@FXML
	private ChoiceBox<Integer> trueAnswerUpdated;
	@FXML
	private Button updateQues; 
	@FXML
	private Button update;
	@FXML
	private TextField num2;
	@FXML
	private Text true11;
	@FXML
	private Text diff11;
	@FXML
	private Button updateQues2; 
	@FXML
	private Button show;
	@FXML
	private TextField quesNum;
	@FXML
	private Text showDif;
	@FXML
	private Text showTrue;
	@FXML
	private Text showAnswer1;
	@FXML
	private Text showAnswer2;
	@FXML
	private Text showAnswer3;
	@FXML
	private Text showAnswer4;
	@FXML
	private Text showTeam;
	@FXML
	private Text showContext;

	//calling the singleton of sysData class
	SysData sysData = SysData.getInstance();
	//declare Alert to show an error or an information message on the Screen
    Alert a = new Alert(AlertType.NONE);
    Alert c = new Alert(AlertType.NONE);
    // declaring the column of the table that well show all Questions
    TableColumn<Question, Integer> id;
    TableColumn<Question, String> ques;
    TableColumn<Question,DifficultyLevel> dif;
    //fell the table with all Questions and names of each column 
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    
		sysData.LoadQuestions();
		id=new TableColumn<Question, Integer>("    ID   ");
		ques=new TableColumn<Question, String>("                           Context                        ");
		dif =new TableColumn<Question, DifficultyLevel>("         Difficulty            "); 
		table.getColumns().addAll(id,ques,dif);
	    ObservableList<Question> observQues = FXCollections.observableArrayList(sysData.getQuestions());
	    //declaring to each column what the name of the variable that should take
		id.setCellValueFactory(new PropertyValueFactory<Question,Integer>("Id"));
		ques.setCellValueFactory(new PropertyValueFactory<>("Context"));
		dif.setCellValueFactory(new PropertyValueFactory<Question,DifficultyLevel>("difficultyLevel"));
		table.setItems(observQues);
    }
   
	private static QuestionMngController instance = null;

	
	// QuestionMngController Singleton Instance
	public static QuestionMngController getInstance() {
		if (instance == null) {
			instance = new QuestionMngController();
		}
		return instance;
	}
	//method that take ud back to the main screen
	//it's an action to back button
	public void backButton1(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/mainScreen.css").toExternalForm());
		stage.setScene(scene);
	
		stage.show();

	}
	// method that changing the visible show of some variable
	// According to the button we clicked (in this case it is add)
	public void addQues(ActionEvent event) throws Exception{
		showContext.setVisible(false);
		showAnswer1.setVisible(false);
		showAnswer2.setVisible(false);
		showAnswer3.setVisible(false);
		showAnswer4.setVisible(false);
		showTeam.setVisible(false);
		showDif.setVisible(false);
		showTrue.setVisible(false);
		show.setVisible(false);
		quesNum.setVisible(false);
		textF.setVisible(false);
		delete.setVisible(false);
		ObservableList<Integer> diffList = FXCollections.observableArrayList(1,2,3);
		ObservableList<Integer> trueAns = FXCollections.observableArrayList(1,2,3,4);
		difLevel.setItems(diffList);
		trueAnswer.setItems(trueAns);
		num2.setVisible(false);
		update.setVisible(false);
		context.setVisible(true);
		answer1.setVisible(true);
		answer2.setVisible(true);
		answer3.setVisible(true);
		answer4.setVisible(true);
		team.setVisible(true);
		difLevel.setVisible(true);
		trueAnswer.setVisible(true);
		add.setVisible(true);
		true1.setVisible(true);
		diff1.setVisible(true);

	}
	//method that add the question to the arraylist of all questions
	// also add the JSON file
	public void finishAddQues(ActionEvent event) throws Exception{
		int sameQ = 0 , sameA = 0;
		ArrayList<Answer> answers = new ArrayList<Answer>();
		try {
			//check if the user entered a null value or space 
			if(difLevel.getValue() == null || context.getText().trim().isEmpty() || answer1.getText().trim().isEmpty()
					|| answer2.getText().trim().isEmpty() || answer3.getText().trim().isEmpty() || answer4.getText().trim().isEmpty() || team.getText().trim().isEmpty()
					|| trueAnswer.getValue() == null) {
				throw new NullPointerException();
			}
			// get all the answers that the user want to add 
			Answer answer11 =new Answer(1,answer1.getText());
			answers.add(answer11);
			Answer answer22 =new Answer(2,answer2.getText());
			answers.add(answer22);
			Answer answer33 =new Answer(3,answer3.getText());
			answers.add(answer33);
			Answer answer44 =new Answer(4,answer4.getText());
			answers.add(answer44);
			//checking the right answer between all answers 
			if(trueAnswer.getValue().equals(1)) {
				answer11.setTrue(true);
			}
			else
				answer11.setTrue(false);
			if(trueAnswer.getValue().equals(2)) {
				answer22.setTrue(true);
			}
			else
				answer22.setTrue(false);
			if(trueAnswer.getValue().equals(3)) {
				answer33.setTrue(true);
			}
			else
				answer33.setTrue(false);
			if(trueAnswer.getValue().equals(4))
				answer44.setTrue(true);
			else
				answer44.setTrue(false);
			// get the difficultly of the question
			DifficultyLevel diff;
			if(difLevel.getValue().equals(1)) {
				diff = DifficultyLevel.EASY;
			}
			else if(difLevel.getValue().equals(2)) {
				diff = DifficultyLevel.MEDIOCRE;
			}
			else {
				diff = DifficultyLevel.HARD;
			}	
			sysData.LoadQuestions();
			//take all the entered data and add a new question
			Question newQues = new Question(sysData.getQuestions().size(),context.getText(),answers,diff,team.getText());
			//checking if there is the same question
				if(sysData.quesAlreadyExists(newQues.getContext(),-1)==false  )
				{
					//checking if there is two similar answers
						if(newQues.answerAlreadyExist(answers)==false) {
							// adding the new question to JSON and to the ArrayList
							sysData.addQuestion(newQues);
						}
						//if there is two similar answers 
						else {
							sameA = 1;
							throw new Exception();
						}
				}
				//if the question already exist
				else {
					sameQ = 1;
					throw new Exception();
				}
			
		
			sysData.WriteQuestions();
			//changing the visible show 
			context.setVisible(false);
			answer1.setVisible(false);
			answer2.setVisible(false);
			answer3.setVisible(false);
			answer4.setVisible(false);
			team.setVisible(false);
			difLevel.setVisible(false);
			trueAnswer.setVisible(false);
			add.setVisible(false);
			true1.setVisible(false);
			diff1.setVisible(false);
			addQues.setVisible(true);
			deleteQues.setVisible(true);
			updateQues.setVisible(true);
			// adding the new question to the table that show on the screen
			ObservableList<Question> observQues = FXCollections.observableArrayList(sysData.getQuestions());    
			id.setCellValueFactory(new PropertyValueFactory<Question,Integer>("Id"));
			ques.setCellValueFactory(new PropertyValueFactory<>("Context"));
			dif.setCellValueFactory(new PropertyValueFactory<Question,DifficultyLevel>("difficultyLevel"));		
			table.setItems(observQues);
			
			a.setAlertType(AlertType.INFORMATION);
			a.setContentText("added successfully");
			a.show();
			
	        
		}
		// catch for null data
		catch (NullPointerException e) {
			a.setAlertType(AlertType.ERROR);
			a.setContentText("please enter all data!");
			a.show();
			// catch for two similar answers or already existing question
		}catch (Exception e) {
			if(sameA == 1) {
				c.setAlertType(AlertType.ERROR);
				c.setContentText("there is two similar answers, try again!!");
				c.show();
			}
			if(sameQ == 1) {
				c.setAlertType(AlertType.ERROR);
				c.setContentText("question already exist!!");
				c.show();
			}
		}
		
	}
	// method that changing the visible show of some variable
	// According to the button we clicked (in this case it is remove)
	public void deleteQues(ActionEvent event) throws Exception{
		showContext.setVisible(false);
		showAnswer1.setVisible(false);
		showAnswer2.setVisible(false);
		showAnswer3.setVisible(false);
		showAnswer4.setVisible(false);
		showTeam.setVisible(false);
		showDif.setVisible(false);
		showTrue.setVisible(false);
		show.setVisible(false);
		quesNum.setVisible(false);
		context.setVisible(false);
		answer1.setVisible(false);
		answer2.setVisible(false);
		answer3.setVisible(false);
		answer4.setVisible(false);
		team.setVisible(false);
		difLevel.setVisible(false);
		trueAnswer.setVisible(false);
		add.setVisible(false);
		true1.setVisible(false);
		diff1.setVisible(false);
		textF.setVisible(true);
		delete.setVisible(true);
		num2.setVisible(false);
		update.setVisible(false);

			
	}
	//method that delete the question from the arraylist of all questions
	// also delete it from the JSON file
	public void finishDeleteQues(ActionEvent event) throws Exception{
		try {
			//checking if the number of the question that we want to delete is entered as null or space
			if(textF.getText().trim().isEmpty())
				throw new Exception();
			sysData.LoadQuestions();
		
	
           // checking if the number that entered existing or if it illegal
			if(Integer.parseInt(textF.getText())>= sysData.getQuestions().size() || Integer.parseInt(textF.getText())<0  ) {
				a.setAlertType(AlertType.ERROR);
				a.setContentText("the number is not valid, please try again!");
				a.show();			}
			else {
				sysData.LoadQuestions();
				//deleting the question from the arraylist and JsonFile 
				sysData.removeQuestion(Integer.parseInt(textF.getText()));
				sysData.WriteQuestions();
				textF.setVisible(false);
				delete.setVisible(false);
				addQues.setVisible(true);
				deleteQues.setVisible(true);
				updateQues.setVisible(true);
				// deleting question from the table that show on the screen
				ObservableList<Question> observQues = FXCollections.observableArrayList(sysData.getQuestions());    
				id.setCellValueFactory(new PropertyValueFactory<Question,Integer>("Id"));
				ques.setCellValueFactory(new PropertyValueFactory<>("Context"));
				dif.setCellValueFactory(new PropertyValueFactory<Question,DifficultyLevel>("difficultyLevel"));		
				table.setItems(observQues);			a.setAlertType(AlertType.INFORMATION);
				a.setContentText("deleted successfully");
				a.show();
				
			}
			//catch for entered a null data
		}catch (Exception e) {
			a.setAlertType(AlertType.ERROR);
			a.setContentText("please enter all data!");
			a.show();		}
		
		
	}
	// method that changing the visible show of some variable
	// According to the button we clicked (in this case it is update)
	public void updateQues(ActionEvent event) throws Exception{
		showContext.setVisible(false);
		showAnswer1.setVisible(false);
		showAnswer2.setVisible(false);
		showAnswer3.setVisible(false);
		showAnswer4.setVisible(false);
		showTeam.setVisible(false);
		showDif.setVisible(false);
		showTrue.setVisible(false);
		show.setVisible(false);
		quesNum.setVisible(false);
		contextUpdated.setVisible(false);
		answer1Updated.setVisible(false);
		answer2Updated.setVisible(false);
		answer3Updated.setVisible(false);
		answer4Updated.setVisible(false);
		teamUpdated.setVisible(false);
		difLevelUpdated.setVisible(false);
		trueAnswerUpdated.setVisible(false);
		true11.setVisible(false);
		diff11.setVisible(false);
		updateQues2.setVisible(false);
		num2.setVisible(true);
		update.setVisible(true);
		textF.setVisible(false);
		delete.setVisible(false);
		context.setVisible(false);
		answer1.setVisible(false);
		answer2.setVisible(false);
		answer3.setVisible(false);
		answer4.setVisible(false);
		team.setVisible(false);
		difLevel.setVisible(false);
		trueAnswer.setVisible(false);
		add.setVisible(false);
		true1.setVisible(false);
		diff1.setVisible(false);

	}
	//method that take the question number that we want to update 
	//and show us the question details
	public void finishUpdateQues(ActionEvent event) throws Exception{
		//checking if the number of the question that we want to update is entered as null or space
        try {
		sysData.LoadQuestions();
		if(num2.getText().trim().isEmpty()) {
			throw new Exception();
		}
		//checking if the number of the question that we want to delete is entered as null or space
		if(Integer.parseInt(num2.getText())>= sysData.getQuestions().size() || Integer.parseInt(num2.getText())<0  ) {
			a.setAlertType(AlertType.ERROR);
			a.setContentText("the number is not valid , please try again!");
			a.show();		}
				
		else {
			//showing question's details on the screen
			ObservableList<Integer> diffList = FXCollections.observableArrayList(1,2,3);
			ObservableList<Integer> trueAns = FXCollections.observableArrayList(1,2,3,4);
			difLevelUpdated.setItems(diffList);
			trueAnswerUpdated.setItems(trueAns);
			num2.setVisible(false);
			update.setVisible(false);
			contextUpdated.setVisible(true);
			answer1Updated.setVisible(true);
			answer2Updated.setVisible(true);
			answer3Updated.setVisible(true);
			answer4Updated.setVisible(true);
			teamUpdated.setVisible(true);
			difLevelUpdated.setVisible(true);
			trueAnswerUpdated.setVisible(true);
			true11.setVisible(true);
			diff11.setVisible(true);
			updateQues2.setVisible(true);
			Integer num =Integer.parseInt(num2.getText());
			contextUpdated.setText(sysData.getQuestions().get(num).getContext());
			answer1Updated.setText(sysData.getQuestions().get(num).getAnswers().get(0).getAnswerContext());
			answer2Updated.setText(sysData.getQuestions().get(num).getAnswers().get(1).getAnswerContext());
			answer3Updated.setText(sysData.getQuestions().get(num).getAnswers().get(2).getAnswerContext());
			answer4Updated.setText(sysData.getQuestions().get(num).getAnswers().get(3).getAnswerContext());
			teamUpdated.setText(sysData.getQuestions().get(num).getTeam());
			for(int i=0;i<sysData.getQuestions().get(num).getAnswers().size();i++) {
				if(sysData.getQuestions().get(num).getAnswers().get(i).isTrue()==true)	{
					trueAnswerUpdated.setValue(i+1);
				}
			}
			if(sysData.getQuestions().get(num).getDifficultyLevel()==DifficultyLevel.EASY)
				difLevelUpdated.setValue(1);
			if(sysData.getQuestions().get(num).getDifficultyLevel()==DifficultyLevel.HARD)
				difLevelUpdated.setValue(3);
			else
				difLevelUpdated.setValue(2);


		}

		}
		//catch for entered a null data
		catch (Exception e) {
			a.setAlertType(AlertType.ERROR);
			a.setContentText("please enter all data!");
			a.show(); 		}
		}
	
	//method that update the question in the arraylist of all questions
	// also update it in the JSON file
	public void finishUpdate(ActionEvent event) throws Exception{
		int sameA = 0 , sameQ = 0 ;;
		try {
		sysData.LoadQuestions();
		//check if the user entered a null value or space 
		if(difLevelUpdated.getValue() == null || contextUpdated.getText().trim().isEmpty() || answer1Updated.getText().trim().isEmpty()
				|| answer2Updated.getText().trim().isEmpty() || answer3Updated.getText().trim().isEmpty() || answer4Updated.getText().trim().isEmpty() 
				|| teamUpdated.getText().trim().isEmpty() || trueAnswerUpdated.getValue() == null ) {
			throw new NullPointerException();
		}
		Integer num =Integer.parseInt(num2.getText());
		ArrayList<Answer> answers = new ArrayList<Answer>();
		//checking if there is the same question
			if(sysData.quesAlreadyExists(contextUpdated.getText(),num)==false){
				sysData.getQuestions().get(num).setContext(contextUpdated.getText());
			}
			else {
				sameQ = 1;
				throw new Exception();
			}
			// get the difficultly of the question
		sysData.getQuestions().get(num).setTeam(teamUpdated.getText());
		
		if(difLevelUpdated.getValue()==1) {
			sysData.getQuestions().get(num).setDifficultyLevel(DifficultyLevel.EASY);
		}
		else if(difLevelUpdated.getValue()==2) {
			sysData.getQuestions().get(num).setDifficultyLevel(DifficultyLevel.MEDIOCRE);
		}
		else
			sysData.getQuestions().get(num).setDifficultyLevel(DifficultyLevel.HARD);
		// get all the answers that the user want to update
		Answer answer1 =new Answer(1,answer1Updated.getText());
		answers.add(answer1);
		Answer answer2 =new Answer(2,answer2Updated.getText());
		answers.add(answer2);
		Answer answer3 =new Answer(3,answer3Updated.getText());
		answers.add(answer3);
		Answer answer4 =new Answer(4,answer4Updated.getText());
		answers.add(answer4);
		//checking the right answer between all answers
		if(trueAnswerUpdated.getValue().equals(1)) {
			answer1.setTrue(true);
		}
		else
			answer1.setTrue(false);
		if(trueAnswerUpdated.getValue().equals(2)) {
			answer2.setTrue(true);
		}
		else
			answer2.setTrue(false);
		if(trueAnswerUpdated.getValue().equals(3)) {
			answer3.setTrue(true);
		}
		else
			answer3.setTrue(false);
		if(trueAnswerUpdated.getValue().equals(4))
			answer4.setTrue(true);
		else
			answer4.setTrue(false);
		//checking if there is two similar answers
			if(sysData.getQuestions().get(num).answerAlreadyExist(answers)==false){
				sysData.getQuestions().get(num).setAnswers(answers);
			}
			else {
				sameA = 1 ;
				throw new Exception();
			}
	
		sysData.WriteQuestions();
		contextUpdated.setVisible(false);
		answer1Updated.setVisible(false);
		answer2Updated.setVisible(false);
		answer3Updated.setVisible(false);
		answer4Updated.setVisible(false);
		teamUpdated.setVisible(false);
		difLevelUpdated.setVisible(false);
		trueAnswerUpdated.setVisible(false);
		true11.setVisible(false);
		diff11.setVisible(false);
		updateQues2.setVisible(false);
		// update question in the table that show on the screen
		ObservableList<Question> observQues = FXCollections.observableArrayList(sysData.getQuestions());    
		id.setCellValueFactory(new PropertyValueFactory<Question,Integer>("Id"));
		ques.setCellValueFactory(new PropertyValueFactory<>("Context"));
		dif.setCellValueFactory(new PropertyValueFactory<Question,DifficultyLevel>("difficultyLevel"));		
		table.setItems(observQues);
		a.setAlertType(AlertType.INFORMATION);
		a.setContentText("Updated successfully");
		a.show();
		
		
		}
		// catch for null data
		catch(NullPointerException e){
			a.setAlertType(AlertType.ERROR);
			a.setContentText("please enter all data!");
			a.show();
		}
		// catch for two similar answers or already existing question
		catch (Exception e) {
			if(sameA == 1) {
				c.setAlertType(AlertType.ERROR);
				c.setContentText("there is two similar answers, try again!!");
				c.show();
			}
			if(sameQ == 1) {
				c.setAlertType(AlertType.ERROR);
				c.setContentText("question already exist!!");
				c.show();
			}
		}
	 
	}
	// method that changing the visible show of some variable
	// According to the button we clicked (in this case it is show)
	public void showQues(ActionEvent event) throws Exception{
		
		show.setVisible(true);
		quesNum.setVisible(true);
		num2.setVisible(false);
		update.setVisible(false);
		textF.setVisible(false);
		delete.setVisible(false);
		context.setVisible(false);
		answer1.setVisible(false);
		answer2.setVisible(false);
		answer3.setVisible(false);
		answer4.setVisible(false);
		team.setVisible(false);
		difLevel.setVisible(false);
		trueAnswer.setVisible(false);
		add.setVisible(false);
		true1.setVisible(false);
		diff1.setVisible(false);
		showContext.setVisible(false);
		showAnswer1.setVisible(false);
		showAnswer2.setVisible(false);
		showAnswer3.setVisible(false);
		showAnswer4.setVisible(false);
		showTeam.setVisible(false);
		showDif.setVisible(false);
		showTrue.setVisible(false);
		contextUpdated.setVisible(false);
		answer1Updated.setVisible(false);
		answer2Updated.setVisible(false);
		answer3Updated.setVisible(false);
		answer4Updated.setVisible(false);
		teamUpdated.setVisible(false);
		difLevelUpdated.setVisible(false);
		trueAnswerUpdated.setVisible(false);
		true11.setVisible(false);
		diff11.setVisible(false);
		updateQues2.setVisible(false);
	}
	//method that show us details of one question  
	public void finishShowQues(ActionEvent event) throws Exception{
		  try {
			//checking if the number of the question that we want to delete is entered as null or space
				sysData.LoadQuestions();
				if(quesNum.getText().trim().isEmpty()) {
					throw new Exception();
				}
		           // checking if the number that entered existing or if it illegal
				if(Integer.parseInt(quesNum.getText())>= sysData.getQuestions().size() || Integer.parseInt(quesNum.getText())<0  ) {
					a.setAlertType(AlertType.ERROR);
					a.setContentText("the number is not valid , please try again!");
					a.show();		}
				else {
					//showing question's details on the screen
			quesNum.setVisible(false);
			show.setVisible(false);
			showContext.setVisible(true);
			showAnswer1.setVisible(true);
			showAnswer2.setVisible(true);
			showAnswer3.setVisible(true);
			showAnswer4.setVisible(true);
			showTeam.setVisible(true);
			showDif.setVisible(true);
			showTrue.setVisible(true);
			Integer num =Integer.parseInt(quesNum.getText());
			showContext.setText(sysData.getQuestions().get(num).getContext());
			showAnswer1.setText(sysData.getQuestions().get(num).getAnswers().get(0).getAnswerContext());
			showAnswer2.setText(sysData.getQuestions().get(num).getAnswers().get(1).getAnswerContext());
			showAnswer3.setText(sysData.getQuestions().get(num).getAnswers().get(2).getAnswerContext());
			showAnswer4.setText(sysData.getQuestions().get(num).getAnswers().get(3).getAnswerContext());
			showTeam.setText("Team: " +sysData.getQuestions().get(num).getTeam());
			for(int i=0;i<sysData.getQuestions().get(num).getAnswers().size();i++) {
				if(sysData.getQuestions().get(num).getAnswers().get(i).isTrue()==true)	{
					showTrue.setText("True Answer: "+String.valueOf(i+1));
				}
			}
			if(sysData.getQuestions().get(num).getDifficultyLevel()==DifficultyLevel.EASY)
				showDif.setText("Difficulty Level: "+String.valueOf(1));
			if(sysData.getQuestions().get(num).getDifficultyLevel()==DifficultyLevel.HARD)
				showDif.setText("Difficulty Level: "+String.valueOf(3));
			else
				showDif.setText("Difficulty Level: "+String.valueOf(2));
		}
		  }
			// catch for null data
			catch (Exception e) {
				a.setAlertType(AlertType.ERROR);
				a.setContentText("please enter all data!");
				a.show(); 		}
			}
}



    
