package Control;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserNameController {
	@FXML
	TextField nameTextField;
	int totalSec;
	String time;
	//StartGameController stg = new StartGameController();
	public void letsPlay(ActionEvent event) throws Exception {
		String UserName =nameTextField.getText();
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/View/StartGame.fxml"));
		Parent root = loader.load();
		StartGameController sgc1 = loader.getController();
		StartGameController sgc2 = loader.getController();
		sgc2.setTimer();
		sgc1.displayName(UserName);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		//scene.getStylesheets().add(getClass().getResource("/View/.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}	
		
	
private  String format(long value) {
	if(value<10) {
		return 0+""+value;
	}
	return value+"";
}
}
