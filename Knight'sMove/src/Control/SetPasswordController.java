package Control;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.AdminPlayer;

public class SetPasswordController {
	@FXML
	private TextField NickName;
	@FXML
	private PasswordField Password;
	@FXML
	private Button check;
	@FXML
	private Text warning;

	private static SetPasswordController instance = null;
	private ArrayList<AdminPlayer> admins = new ArrayList<AdminPlayer>();
	
	// QuestionMngController Singleton Instance
	public static SetPasswordController getInstance() {
		if (instance == null) {
			instance = new SetPasswordController();
		}
		return instance;
	}
	
	public SetPasswordController() {
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
	
				scene.getStylesheets().add(getClass().getResource("/View/editQuestion.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
			}
		}
		if(flag==1)
		warning.setVisible(true);
	}
	public void backButton2(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/mainScreen.css").toExternalForm());
		stage.setScene(scene);
	
		stage.show();

	}
}
