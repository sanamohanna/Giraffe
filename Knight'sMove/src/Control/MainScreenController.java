package Control;

import java.io.IOException;

//import View.MainScreen;
import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainScreenController {
	// button that send us to Instructions screen
	public void Instructions(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/View/Instructions.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/Instructions.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	// button that send us to SetPassword screen 
	public void EditQuestions(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/View/SetPassword.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/setPassword.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	// button that send us to UserName screen 
	public void StartGame(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/View/UserName.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/UserName.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	// button that send us to usernameForHistory screen 
	public void GamesHistory(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/View/usernameForHistory .fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/gameHistory.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

}

