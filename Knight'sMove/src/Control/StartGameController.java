package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import Enum.Directions;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Board;
import model.Game;
import model.Location;
import model.Question;
import model.SysData;

public class StartGameController implements Initializable,EventHandler<ActionEvent>{
	@FXML
	private Button b00,b01,b02,b03,b04,b05,b06,b07;
	@FXML
	private Button b10,b11,b12,b13,b14,b15,b16,b17;
	@FXML
	private Button b20,b21,b22,b23,b24,b25,b26,b27;
	@FXML
	private Button b30,b31,b32,b33,b34,b35,b36,b37;
	@FXML
	private Button b40,b41,b42,b43,b44,b45,b46,b47;
	@FXML
	private Button b50,b51,b52,b53,b54,b55,b56,b57;
	@FXML
	private Button b60,b61,b62,b63,b64,b65,b66,b67;
	@FXML
	private Button b70,b71,b72,b73,b74,b75,b76,b77;
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
	private ImageView imageK;
	@FXML
	private ImageView imageQ;
	Alert a = new Alert(AlertType.NONE);
	//timer fields;
	static long min,hr, sec,totalSec,points=0;

	static String buttonId;
	//Board boardGame = new Board();
	Game game = new Game();
	@Override
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		GridPane.setColumnIndex(imageK, 0);
		GridPane.setRowIndex(imageK, 0);
		
		
		try {
			level1Moves();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Random rand = new Random();
		Node node1 = board.getChildren().get(rand.nextInt(board.getChildren().size()-2));
		node1.setStyle("-fx-background-color: red; ");
		((Button) node1).setOnAction(event ->{
			
			try {
				pop();
			} catch (IOException e) {
				e.printStackTrace();
			}
			});
		Node node2 = board.getChildren().get(rand.nextInt(board.getChildren().size()-2));
		node2.setStyle("-fx-background-color: red; ");
		((Button) node2).setOnAction(event ->{
			
			try {
				pop();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			});
		Node node3 = board.getChildren().get(rand.nextInt(board.getChildren().size()-2));
		node3.setStyle("-fx-background-color: red; ");
		((Button) node3).setOnAction(event ->{
			
			try {
				pop();
			} catch (IOException e) {
				e.printStackTrace();
			}
			});
		setTimer();
		displayLevel("LEVEL 1");
		pointsT.setText(String.valueOf(points));
		
	}
		// method that start timer in long one minute to every level in the game 
		public void setTimer(){
			totalSec=60;
			Timer timer = new Timer();
			TimerTask timerTask = new TimerTask() {
				@Override
				public void run(){					
						convertTime();
						
						// we added the points text just for checking we will change it when we finish the game
						pointsT.setText("Points: " +String.valueOf(points));
						
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
//		public Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
//			for (Node node : gridPane.getChildren()) {
//			    if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
//			        return node;
//			    }
//			}
//			return null;
//		}
		ArrayList<Location> validMoves;
		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub

				Button bt =(Button) arg0.getSource();
				try {
				int flag=0;
				Location loc1 = new Location(GridPane.getColumnIndex(bt),GridPane.getRowIndex(bt));
				validMoves= game.getKnight().allValidMovesLevel1(loc1);
				for(int i = 0 ; i < validMoves.size(); i++) {
					System.out.println(validMoves.get(i));
				}
						if(validMoves.contains(loc1)) {
							flag =1;
							GridPane.setColumnIndex(imageK, GridPane.getColumnIndex(bt));
							GridPane.setRowIndex(imageK,GridPane.getRowIndex(bt) );
							game.getKnight().setLocation(loc1);
							points++;
							//level1Moves();
						}
				
					if(flag == 0) {
						throw new Exception();
					}
					}
				
					catch(Exception e) {
						a.setAlertType(AlertType.ERROR);//if the user not enter data 
						a.setContentText("invalid move try again");
						a.show();	
					}
				
					
		}
		
		int k = 0 , j = 0 ;
	
		public void level1Moves() throws IOException {
			Location loc =game.getKnight().getLocation();
			validMoves= game.getKnight().allValidMovesLevel1(loc);
			for(int node = 0 ; node < board.getChildren().size()-2 ; node++,j++) {
				if(j>7) {
					k++;
					j=0;
				}
				Location locNew = new Location(k,j);
				//System.out.println(locNew);
				((Button) board.getChildren().get(node)).setOnAction(this);
				
				if(validMoves.contains(locNew)) {
					board.getChildren().get(node).setStyle("-fx-background-color: green; ");
				}

			}
		}
		}
