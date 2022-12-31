package Control;

import java.io.IOException;
//import java.util.Timer;
//import java.util.TimerTask;
//import java.util.concurrent.TimeUnit;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

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
import model.Player;
import model.SysData;

public class UserNameController {
	@FXML
	TextField nameTextField;
	@FXML
	TextField newUser;
	static String Name;
    Alert a = new Alert(AlertType.NONE);
    //button that open startGame screen to to play
	public void letsPlay(ActionEvent event) throws Exception {
		Boolean flag = false;
		//check if the user entered a user name 
		try {
			if(nameTextField.getText().isEmpty()) {
				throw new Exception();
			}
		String UserName =nameTextField.getText();
		Name=UserName;
		Player player = new Player(UserName);
		if(!SysData.getInstance().getPlayers().contains(player)) {
			flag = true;
			throw new Exception();
		}else {

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
		}
	
	
		}catch (Exception e) {
			if(flag == true) {
				a.setAlertType(AlertType.ERROR);//if the user not enter data 
				a.setContentText("You Need To Sign Up!");
				a.show();
			}else {
			a.setAlertType(AlertType.ERROR);//if the user not enter data 
			a.setContentText("please enter all data!");
			a.show();		
			}		
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
	public void SignUpButton(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/SignUp.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/StartGame.css").toExternalForm());
		stage.setScene(scene);
	
		stage.show();
	}
	public void signUp_backButton(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/StartGame.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/StartGame.css").toExternalForm());
		stage.setScene(scene);
	
		stage.show();

	}
	public void SignUp(ActionEvent event) throws Exception {
		Boolean flag = false ;

		//check if the user entered a user name 
		try {
			if(newUser.getText().isEmpty()) {
				throw new Exception();
			}
		String newUserName =newUser.getText();
		Name=newUserName;
		Player NewPlayer = new Player(newUserName);
		if(!SysData.getInstance().getPlayers().contains(NewPlayer)) {
	    SysData.getInstance().getPlayers().add(NewPlayer);
		}
		else {
			flag = true;
			throw new Exception();
		}
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/View/StartGame.fxml"));
		Parent root = loader.load();
		StartGameController sgc1 = loader.getController();
		//send the username to start game controller to display
		sgc1.displayName(newUserName);
		
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/StartGame.css").toExternalForm());
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		
	
	
		}catch (Exception e) {
			if(flag == true) {
				a.setAlertType(AlertType.ERROR);//if the user not enter data 
				a.setContentText("This User Name is already exist!");
				a.show();
			}else {
			a.setAlertType(AlertType.ERROR);//if the user not enter data 
			a.setContentText("please enter all data!");
			a.show();		
			}
		}
	}
	
	
}
