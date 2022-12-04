package Control;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.text.Text;

public class StartGameController {
	
	@FXML
	private Label label1;
	//@FXML
	//private Label label2;
	@FXML
	private Text text;
	
	
	
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
	public  void convertTime() {
		min = TimeUnit.SECONDS.toMinutes(totalSec);
		sec = totalSec  - (min * 60);
		//hr = TimeUnit.MINUTES.toHours(min);
		//min = min - (hr *60);
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
		label1.setText("hello: "+userName);
	}
	

	}
