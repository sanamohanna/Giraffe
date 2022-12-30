package Control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class gameStatusController {
	@FXML
	private Label level;
	@FXML
	private Label points;
	
	public void displayLevel(String level1){
		level.setText("YOU LOSE IN "+level1);
	}
	public void displayPoints(int points1){
		points.setText("WITH "+points1+" POINTS");
	}
	public void letsPlayAgain(ActionEvent event) throws IOException {
		//StartGameController.points=0;
		Parent root = FXMLLoader.load(getClass().getResource("/View/StartGame.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/StartGame.css").toExternalForm());
		stage.setScene(scene);			
		stage.show();
	}
}
