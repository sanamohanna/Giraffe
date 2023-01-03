package Control;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class pauseController {
	// method that start the game again
	public void startTheGameAgain(ActionEvent event) throws IOException{
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		//change the stop timer to 1 to start the timer again
		StartGameController.stopTimer=1;
		stage.close();
		
	}
}
