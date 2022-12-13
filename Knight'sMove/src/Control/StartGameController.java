package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartGameController implements Initializable {
	
	@FXML
	private Label label1;
	@FXML
	private Text text;
	@FXML
	private Text level;
	@FXML
	private Text pointsT;
	
	//timer fields;
	static long min,hr, sec,totalSec,points=0;
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
	// method that start timer in long one minute to every level in the game 
	public void setTimer() {
		totalSec=60;
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {
				convertTime();
				points++;
				pointsT.setText("POINTS:"+String.valueOf(points));
				if(totalSec<=0) {	
				text.setText("00:00");
				timer.cancel();
				//add something here
				}
			}
			
		};   
		timer.schedule(timerTask, 0, 1000);
	}
	//method that replace the totalsec to minutes and sec  
	private  void convertTime() {
		min = TimeUnit.SECONDS.toMinutes(totalSec);
		sec = totalSec  - (min * 60);
		text.setText(format(min)+":"+format(sec));
		totalSec--;
	}
	// add 0 to left side to value that small than 10
	private  String format(long value) {
		if(value<10) {
			return 0+""+value;
		}
		return value+"";
	}
	// display username in the screen 
	public void displayName(String userName) {
		label1.setText("Player: "+userName);
	}
	public void displayLevel(String level1) {
		level.setText(level1);
	}
	//initialize the timer and display level
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		setTimer();
		displayLevel("LEVEL 1");
	}
	

	}
