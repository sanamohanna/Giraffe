package Control;

import View.MainScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainScreenController {

	QuestionMngController q;
	
	
	
	public void Instructures(ActionEvent event) throws Exception {
	
		Parent root = FXMLLoader.load(getClass().getResource("/View/Instructures.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/Instructures.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		
		
	}
	public void EditQuestions(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/View/SetPassword.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		//scene.getStylesheets().add(getClass().getResource("/View/SetPassword.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		
		
	}
	public void StartGame(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/View/UserName.fxml"));
		
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/UserName.css").toExternalForm());
		stage.setScene(scene);
		
		stage.show();
		
		
	}

	

}
