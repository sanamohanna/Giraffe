package Control;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class StartGameController implements Initializable {
	
	@FXML
	private Label label1;
	@FXML
	private Text text;
	@FXML
	private Text level;
	
	
	//timer fields;
	static long min,hr, sec,totalSec;
	
	
	public void setTimer() {
		totalSec=60;
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {
				convertTime();
				if(totalSec<=0) {	
				text.setText("00:00");
				timer.cancel();
				//add something here
				}
			}
			
		};   
		timer.schedule(timerTask, 0, 1000);
	}
	private  void convertTime() {
		min = TimeUnit.SECONDS.toMinutes(totalSec);
		sec = totalSec  - (min * 60);
		text.setText(format(min)+":"+format(sec));
		totalSec--;
	}
	private  String format(long value) {
		if(value<10) {
			return 0+""+value;
		}
		return value+"";
	}
	
	public void displayName(String userName) {
		label1.setText("Player: "+userName);
	}
	public void displayLevel() {
		level.setText("LEVEL 1");
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		setTimer();
		displayLevel();
	}
	

	}
