package Control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class pauseController {
	
	public void startTheGameAgain(ActionEvent event) throws IOException{
		//StartGameController.stopTimer=1;
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		StartGameController.stopTimer=1;
		stage.close();
		
	}
}
