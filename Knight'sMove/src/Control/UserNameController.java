package Control;

import java.io.IOException;
//import java.util.Timer;
//import java.util.TimerTask;
//import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class UserNameController {
	@FXML
	TextField nameTextField;
	int totalSec;
	String time;
    Alert a = new Alert(AlertType.NONE);
    //button that open startGame screen to to play
	public void letsPlay(ActionEvent event) throws Exception {
		//check if the user entered a user name 
		//if not pop out a warning
		try {
			if(nameTextField.getText() == null) {
				throw new Exception();
			}
		String UserName =nameTextField.getText();
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/View/StartGame.fxml"));
		Parent root = loader.load();
		StartGameController sgc1 = loader.getController();
		//send the username to start game controller to display
		sgc1.displayName(UserName);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/StartGame.css").toExternalForm());
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		}catch (Exception e) {
			a.setAlertType(AlertType.ERROR);
			a.setContentText("please enter all data!");
			a.show();		
			}
	}
	// button to return us to the main screen
	public void backButton(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/mainScreen.css").toExternalForm());
		stage.setScene(scene);
	
		stage.show();

	}
}
