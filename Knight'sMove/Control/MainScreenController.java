package Control;

import java.io.IOException;

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

	public void Instructions(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/View/Instructions.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/Instructions.css").toExternalForm());
		stage.setScene(scene);
		stage.show();

	}
	public void backButton1(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/mainScreen.css").toExternalForm());
		stage.setScene(scene);
	
		stage.show();

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

	public void EditQuestions(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/View/SetPassword.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		//scene.getStylesheets().add(getClass().getResource("/View/Instructions.css").toExternalForm());
		stage.setScene(scene);
		stage.show();

	}

	public void StartGame(ActionEvent event) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/View/UserName.fxml"));

		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/UserName.css").toExternalForm());
		stage.setScene(scene);

		stage.show();

	}
	
	public void GamesHistory(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/View/gamesHistory.fxml"));
		
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		//scene.getStylesheets().add(getClass().getResource("/View/gamesHistory.css").toExternalForm());
		stage.setScene(scene);
		
		stage.show();
		
		
	}

}

