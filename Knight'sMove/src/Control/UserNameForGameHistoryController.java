package Control;

import java.io.IOException;

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

public class UserNameForGameHistoryController {
	@FXML
	private TextField userName;
	
	 Alert a = new Alert(AlertType.NONE);
	
	
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
		// button to enter to the history list for  player
		public void seeHistory(ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("/View/gamesHistory.fxml"));
			try {
				if(userName.getText().isEmpty() || userName.getText() == " ")
					throw new Exception();
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setResizable(false);
				scene.getStylesheets().add(getClass().getResource("/View/gameHistory.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
				
			}catch (Exception e) { //if the user not enter data 
				a.setAlertType(AlertType.ERROR);
				a.setContentText("please enter all data!");
				a.show();		}
			
			
			
		}
}
