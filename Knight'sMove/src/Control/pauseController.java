package Control;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class pauseController {
	long x ;
	public long getX() {
		return x;
	}
	public void setX(long x) {
		this.x = x;
	}
	public void startTheGameAgain() throws IOException{
		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/View/StartGame.fxml"));
		StartGameController str = loader.getController();
		StartGameController.totalSec=this.x;
		//str.setTimer();
		
	}
}
