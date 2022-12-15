package Control;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import Enum.Directions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Game;
import model.Question;
import model.SysData;

public class StartGameController implements Initializable{
	
	@FXML
	private Label label1;
	@FXML
	private Text text;
	@FXML
	private Text level;
	@FXML 
	private Text pointsT;
	@FXML
	private GridPane board;
	@FXML
	private ImageView image;
	
	//timer fields;
	static long min,hr, sec,totalSec,points=0;
	Game game = new Game();
		// method that start timer in long one minute to every level in the game 
		public void setTimer(){
			totalSec=60;
			Timer timer = new Timer();
			TimerTask timerTask = new TimerTask() {
				@Override
				public void run(){					
						convertTime();
						
						// we added the points text just for checking we will change it when we finish the game
						pointsT.setText(String.valueOf(points));
						
						if(totalSec<=0) {	
							text.setText("00:00");
							timer.cancel();			
							}
				}
			};   
			timer.schedule(timerTask,0,1000);
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
		public void displaypoints(String points) {
			pointsT.setText(points);
		}
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
			setTimer();
			displayLevel("LEVEL 1");
			pointsT.setText(String.valueOf(points));
			
		}
		public Text getPointsT() {
			return pointsT;
		}
		public void setPointsT(Text pointsT) {
			this.pointsT = pointsT;
		}
		//method that pop question window in the middle of the game
		public void pop() throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("/View/QuestionWindow.fxml"));
			Stage stage = new Stage(); 
			Scene scene = new Scene(root);
			stage.setAlwaysOnTop(true);
			stage.setResizable(false);
			scene.getStylesheets().add(getClass().getResource("/View/editQuestion.css").toExternalForm());
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
		public void upLeft(ActionEvent event) throws IOException {
			game.getKnight().level1Move(Directions.UP, Directions.UP, Directions.LEFT);
			board.add(image, game.getKnight().getLocation().getX(), game.getKnight().getLocation().getY());
			
		}
		public void downRight(ActionEvent event) throws IOException {
			game.getKnight().level1Move(Directions.DOWN, Directions.DOWN, Directions.RIGHT);
			board.add(image, game.getKnight().getLocation().getX(), game.getKnight().getLocation().getY());
			
		}
		public void upRight(ActionEvent event) throws IOException {
			game.getKnight().level1Move(Directions.UP, Directions.UP, Directions.RIGHT);
			board.add(image, game.getKnight().getLocation().getX(), game.getKnight().getLocation().getY());
			
		}
		public void downLeft(ActionEvent event) throws IOException {
			game.getKnight().level1Move(Directions.DOWN, Directions.DOWN, Directions.LEFT);
			board.add(image, game.getKnight().getLocation().getX(), game.getKnight().getLocation().getY());
		}
		public void rightUp(ActionEvent event) throws IOException {
			game.getKnight().level1Move(Directions.RIGHT, Directions.RIGHT, Directions.UP);
			board.add(image, game.getKnight().getLocation().getX(), game.getKnight().getLocation().getY());
			
		}
		public void rightDown(ActionEvent event) throws IOException {
			game.getKnight().level1Move(Directions.RIGHT, Directions.RIGHT, Directions.DOWN);
			board.add(image, game.getKnight().getLocation().getX(), game.getKnight().getLocation().getY());
		}
		public void leftUp(ActionEvent event) throws IOException {
			game.getKnight().level1Move(Directions.LEFT, Directions.LEFT, Directions.UP);
			board.add(image, game.getKnight().getLocation().getX(), game.getKnight().getLocation().getY());
			
		}
		public void leftDown(ActionEvent event) throws IOException {
			game.getKnight().level1Move(Directions.LEFT, Directions.LEFT, Directions.DOWN);
			board.add(image, game.getKnight().getLocation().getX(), game.getKnight().getLocation().getY());
		}
		}
