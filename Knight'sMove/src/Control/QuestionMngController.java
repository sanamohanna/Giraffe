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
	private TableColumn<?,? > id;
	@FXML
	private TableColumn<?, ?> ques;
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
				//scene.getStylesheets().add(getClass().getResource("/View/mainScreen.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
			}
		}
		if(flag==1)
		warning.setVisible(true);
	}
//	public void displayQuestions(ActionEvent event) {
//		for(int i=0; i<sysData.getQuestions().size();i++) {
//		 id.setId(sysData.getQuestions().get(i).getId());
//		}
//	}
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
		addQues.setVisible(false);
		
	}
	public void finishAddQues(ActionEvent event) throws Exception{
		ArrayList<Answer> answers = new ArrayList<Answer>();
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
		addQues.setVisible(true);
	}
		
}
