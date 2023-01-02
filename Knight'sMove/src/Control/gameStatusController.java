package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class gameStatusController implements Initializable {
	@FXML
	private Label level;
	@FXML
	private Label points;
	@FXML
	private ImageView cup;
	static int check = 0;
	public void cupVisiable(){
		cup.setVisible(true);
		
	}
	public void displayLevelLose(String level1){
		level.setText("YOU LOST IN "+level1);
		
	}
	public void displayLevelWon(){
		level.setText("YOU WON THE GAME");
	}
	public void displayPoints(int points1){
		points.setText("WITH "+points1+" POINTS");
	}
	public void letsPlayAgain(ActionEvent event) throws IOException {
		//StartGameController.points=0;
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/View/StartGame.fxml"));
		Parent root = loader.load();
		StartGameController sgc1 = loader.getController();
		sgc1.displayName(UserNameController.Name);
		
		//Parent root = FXMLLoader.load(getClass().getResource("/View/StartGame.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/StartGame.css").toExternalForm());
		stage.setScene(scene);			
		stage.show();
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
		// method to show player game history
		public void gameHistory(ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("/View/usernameForHistory.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setResizable(false);
			scene.getStylesheets().add(getClass().getResource("/View/usernameForHistory.css").toExternalForm());
			stage.setScene(scene);
		
			stage.show();

		}
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			if(check==1) {
				cup.setVisible(true);
			}
			
		}
}
