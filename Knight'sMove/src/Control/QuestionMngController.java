package Control;

import java.util.ArrayList;

import Enum.DifficultyLevel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.AdminPlayer;
import model.Answer;
import model.Question;
import model.SysData;

public class QuestionMngController {
	@FXML
	private TextField NickName;
	@FXML
	private PasswordField Password;
	@FXML
	private Button check;
	@FXML
	private Text warning;
	@FXML
	private TableView<Question> table;
	@FXML
	private TableColumn<Question, Integer> id;
	@FXML
	private TableColumn<Question, String> ques;
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
	private Text error;
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
	private Text error2;
	@FXML
	private Text true11;
	@FXML
	private Text diff11;
	@FXML
	private Button updateQues2; 
	@FXML
	private Text error3;

	
	private static QuestionMngController instance = null;
	private ArrayList<AdminPlayer> admins = new ArrayList<AdminPlayer>();
	SysData sysData = SysData.getInstance();
	// QuestionMngController Singleton Instance
	public static QuestionMngController getInstance() {
		if (instance == null) {
			instance = new QuestionMngController();
		}
		return instance;
	}

	
	public QuestionMngController() {
		super();
		 AdminPlayer admin1 =new AdminPlayer("klara","Klara");
		 AdminPlayer admin2 =new AdminPlayer("sana","Sana");
		 AdminPlayer admin3 =new AdminPlayer("nada","Nada");
		 AdminPlayer admin4 =new AdminPlayer("safa","Safa");
		this.admins.add(admin1);
		this.admins.add(admin2);
		this.admins.add(admin3);
		this.admins.add(admin4);
	}
	
	public Text getWarning() {
		return warning;
	}


	public void setWarning(Text warning) {
		this.warning = warning;
	}

	public void checkDetails(ActionEvent event) throws Exception{
		int flag=1;
		for(int i =0;i< admins.size();i++) {
			if(NickName.getText().equals(admins.get(i).getNickname()) && Password.getText().equals(admins.get(i).getPassword()))
			{
				flag =0;
				Parent root = FXMLLoader.load(getClass().getResource("/View/EditQuestions.fxml"));
				Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setResizable(false);
//				ObservableList<Question> data = FXCollections.<Question>observableArrayList();
//				data.addAll(SysData.getInstance().getQuestions());
//				id.setCellValueFactory(new PropertyValueFactory<Question,Integer>("id"));
//				ques.setCellValueFactory(new PropertyValueFactory<>("context"));
//				table.setItems(data);
//				 table.getColumns().addAll(id,ques);
//				table.refresh();
//				table.getColumns().add(id);
//				table.getColumns().add(ques);
//				for(Question question: SysData.getInstance().getQuestions()) {
//					table.getItems().add(question);
//				}
				//scene.getStylesheets().add(getClass().getResource("/View/mainScreen.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
			}
		}
		if(flag==1)
		warning.setVisible(true);
	}
	
	public void addQues(ActionEvent event) throws Exception{
		ObservableList<Integer> diffList = FXCollections.observableArrayList(1,2,3);
		ObservableList<Integer> trueAns = FXCollections.observableArrayList(1,2,3,4);
		difLevel.setItems(diffList);
		trueAnswer.setItems(trueAns);
		
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
		addQues.setVisible(false);
		deleteQues.setVisible(false);
		updateQues.setVisible(false);
	}
	public void finishAddQues(ActionEvent event) throws Exception{
		ArrayList<Answer> answers = new ArrayList<Answer>();
		try {
			if(difLevel.getValue() == null || context.getText() == null || answer1.getText() == null 
					|| answer2.getText() == null || answer3.getText() == null || answer3.getText() == null
					|| trueAnswer.getValue() == null ) {
				throw new Exception();
			}
			Answer answer11 =new Answer(1,answer1.getText());
			answers.add(answer11);
			Answer answer22 =new Answer(2,answer2.getText());
			answers.add(answer22);
			Answer answer33 =new Answer(3,answer3.getText());
			answers.add(answer33);
			Answer answer44 =new Answer(4,answer4.getText());
			answers.add(answer44);
			
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
			Question newQues = new Question(sysData.getQuestions().size(),context.getText(),answers,diff,"animal");
			sysData.addQuestion(newQues);
			sysData.WriteQuestions();
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
//			a.setAlertType(AlertType.INFORMATION);
//			a.setContentText("added successfully");
//			a.show();
//	        
		}
		catch (Exception e) {
//			a.setAlertType(AlertType.ERROR);
//			a.setContentText("please enter all data!");
//			a.show();
		}
		
	}
	public void deleteQues(ActionEvent event) throws Exception{
		textF.setVisible(true);
		delete.setVisible(true);
		addQues.setVisible(false);
		deleteQues.setVisible(false);
		updateQues.setVisible(false);
			
		/*0000*/
	}
	public void finishDeleteQues(ActionEvent event) throws Exception{
		try {
			if(textF == null)
				throw new Exception();
			sysData.LoadQuestions();
			sysData.removeQuestion(Integer.parseInt(textF.getText()));
			sysData.WriteQuestions();
			error.setVisible(false);
			textF.setVisible(false);
			delete.setVisible(false);
			addQues.setVisible(true);
			deleteQues.setVisible(true);
	

			if(Integer.parseInt(textF.getText())>= sysData.getQuestions().size() || Integer.parseInt(textF.getText())<0  ) {
					error.setVisible(true);
			}
			else {
				sysData.LoadQuestions();
				sysData.removeQuestion(Integer.parseInt(textF.getText()));
				sysData.WriteQuestions();
				textF.setVisible(false);
				delete.setVisible(false);
				addQues.setVisible(true);
				deleteQues.setVisible(true);
		
			}
			
		}catch (Exception e) {
			error3.setVisible(true);
		}
		
		
	}
	public void updateQues(ActionEvent event) throws Exception{
		num2.setVisible(true);
		update.setVisible(true);
	}
	public void finishUpdateQues(ActionEvent event) throws Exception{

		sysData.LoadQuestions();
		error2.setVisible(false);
		if(Integer.parseInt(num2.getText())>= sysData.getQuestions().size() || Integer.parseInt(num2.getText())<0  ) {
			error2.setVisible(true);
		}
		else 
		{
			ObservableList<Integer> diffList = FXCollections.observableArrayList(1,2,3);
			ObservableList<Integer> trueAns = FXCollections.observableArrayList(1,2,3,4);
			difLevelUpdated.setItems(diffList);
			trueAnswerUpdated.setItems(trueAns);
			num2.setVisible(false);
			update.setVisible(false);

		try {
			if(num2.getText() == null) {
				throw new Exception();
			}
			sysData.LoadQuestions();
			if(Integer.parseInt(num2.getText())>= sysData.getQuestions().size() || Integer.parseInt(num2.getText())<0  ) {
				error2.setVisible(true);
			}
		else {
			num2.setVisible(false);
			update.setVisible(false);
			error2.setVisible(false);

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
			addQues.setVisible(false);
			deleteQues.setVisible(false);
			updateQues.setVisible(false);
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
		catch (Exception e) {
			error3.setVisible(true);
 		}
		}

	}
	public void finishUpdate(ActionEvent event) throws Exception{
		sysData.LoadQuestions();
		Integer num =Integer.parseInt(num2.getText());
		ArrayList<Answer> answers = new ArrayList<Answer>();
		sysData.getQuestions().get(num).setContext(contextUpdated.getText());
		sysData.getQuestions().get(num).setTeam(teamUpdated.getText());
		
		if(difLevelUpdated.getValue()==1) {
			sysData.getQuestions().get(num).setDifficultyLevel(DifficultyLevel.EASY);
		}
		else if(difLevelUpdated.getValue()==2) {
			sysData.getQuestions().get(num).setDifficultyLevel(DifficultyLevel.MEDIOCRE);
		}
		else
			sysData.getQuestions().get(num).setDifficultyLevel(DifficultyLevel.HARD);
		
		Answer answer1 =new Answer(1,answer1Updated.getText());
		answers.add(answer1);
		Answer answer2 =new Answer(2,answer2Updated.getText());
		answers.add(answer2);
		Answer answer3 =new Answer(3,answer3Updated.getText());
		answers.add(answer3);
		Answer answer4 =new Answer(4,answer4Updated.getText());
		answers.add(answer4);
	
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
		sysData.getQuestions().get(num).setAnswers(answers);
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
		addQues.setVisible(true);
		deleteQues.setVisible(true);
		updateQues.setVisible(true);
	}
}
