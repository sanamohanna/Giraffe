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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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

public class StartGameController implements Initializable{
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
	
	static Node node;
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
		public void level1Moves() throws IOException {
			
			int y = GridPane.getRowIndex(imageK);;
			int x = GridPane.getColumnIndex(imageK);
			Location loc = new Location(x,y);
			validMoves= new ArrayList<Location>();
			validMoves= game.getKnight().allValidMovesLevel1(loc);
			for(int i=0 ; i < board.getChildren().size();i++) {
				System.out.println(board.getChildren().get(i).getId());
			}
			b00.setOnAction(arg0 -> {
				//b12.setStyle("-fx-background-color: white; ");
				int flag=0;
				Location loc00 = new Location(0,0); 
				try {
				for(int i = 0 ;i< validMoves.size();i++) {
						//b12.setStyle("-fx-background-color: green; ");
						if(validMoves.get(i).equals(loc00)) {
							flag =1;
							GridPane.setColumnIndex(imageK, 0);
							GridPane.setRowIndex(imageK,0 );
						}
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
				
					
			});
//			b01.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK,1);
//					GridPane.setRowIndex(imageK,0 );	
//				}
//			});
//			b02.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK, 2);
//					GridPane.setRowIndex(imageK,0);	
//				}
//			});
//			b03.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK, 3);
//					GridPane.setRowIndex(imageK,0 );	
//				}
//			});
//			b04.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK,4);
//					GridPane.setRowIndex(imageK,0 );	
//				}
//			});
//			b05.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK,5);
//					GridPane.setRowIndex(imageK,0);	
//				}
//			});
//			b07.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK, 7);
//					GridPane.setRowIndex(imageK,0 );	
//				}
//			});
//			b06.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK,6);
//					GridPane.setRowIndex(imageK,0 );	
//				}
//			});
//			b10.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK, 0);
//					GridPane.setRowIndex(imageK,1);	
//				}
//			});
//			b11.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK, 1);
//					GridPane.setRowIndex(imageK,1);	
//				}
//			});
//			b12.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK,2);
//					GridPane.setRowIndex(imageK,1 );	
//				}
//			});
//			b13.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK,3);
//					GridPane.setRowIndex(imageK,1);	
//				}
//			});
//			b14.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK, 4);
//					GridPane.setRowIndex(imageK,1);	
//				}
//			});
//			b15.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK,5);
//					GridPane.setRowIndex(imageK,1 );	
//				}
//			});
//			b16.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK,6);
//					GridPane.setRowIndex(imageK,1);	
//				}
//			});
//			b17.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK,7);
//					GridPane.setRowIndex(imageK,1);	
//				}
//			});
//			b20.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK, 0);
//					GridPane.setRowIndex(imageK,2);	
//				}
//			});
//			b21.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK, 1);
//					GridPane.setRowIndex(imageK,2);	
//				}
//			});
//			b22.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK,2);
//					GridPane.setRowIndex(imageK,2 );	
//				}
//			});
//			b23.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK,3);
//					GridPane.setRowIndex(imageK,2);	
//				}
//			});
//			b24.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK, 4);
//					GridPane.setRowIndex(imageK,2);	
//				}
//			});
//			b25.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK,5);
//					GridPane.setRowIndex(imageK,2 );	
//				}
//			});
//			b26.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK,6);
//					GridPane.setRowIndex(imageK,2);	
//				}
//			});
//			b27.setOnAction(new EventHandler() {
//				@Override
//				public void handle(Event arg0) {
//					GridPane.setColumnIndex(imageK,7);
//					GridPane.setRowIndex(imageK,2);	
//				}
//			});

		}
//		public void upLeft(ActionEvent event) throws IOException {
//			game.getKnight().level1Move(Directions.UP, Directions.UP, Directions.LEFT);
//			GridPane.setColumnIndex(imageK, game.getKnight().getLocation().getX());
//			GridPane.setRowIndex(imageK,game.getKnight().getLocation().getY() );
//			points++;
//		//	Location loc = game.getQueen().queenMove2(game.getKnight().getLocation());
//			//game.getQueen().queenMove(3, Directions.DOWN);
////			GridPane.setColumnIndex(imageQ, loc.getX());
////			GridPane.setRowIndex(imageQ,loc.getY());
//		}
//		public void downRight(ActionEvent event) throws IOException {
//			game.getKnight().level1Move(Directions.DOWN, Directions.DOWN, Directions.RIGHT);
//			GridPane.setColumnIndex(imageK, game.getKnight().getLocation().getX());
//			GridPane.setRowIndex(imageK,game.getKnight().getLocation().getY() );
//			
//			points++;
//			
//			game.getQueen().queenMove(3, Directions.DOWN);
//			GridPane.setColumnIndex(imageQ, game.getQueen().getLocation().getX());
//			GridPane.setRowIndex(imageQ,game.getQueen().getLocation().getY());
//		}
//		public void upRight(ActionEvent event) throws IOException {
//			game.getKnight().level1Move(Directions.UP, Directions.UP, Directions.RIGHT);
//			GridPane.setColumnIndex(imageK, game.getKnight().getLocation().getX());
//			GridPane.setRowIndex(imageK,game.getKnight().getLocation().getY() );
//			points++;
//			game.getQueen().queenMove(3, Directions.DOWN);
//			GridPane.setColumnIndex(imageQ, game.getQueen().getLocation().getX());
//			GridPane.setRowIndex(imageQ,game.getQueen().getLocation().getY());
//		}
//		public void downLeft(ActionEvent event) throws IOException {
//			game.getKnight().level1Move(Directions.DOWN, Directions.DOWN, Directions.LEFT);
//			GridPane.setColumnIndex(imageK, game.getKnight().getLocation().getX());
//			GridPane.setRowIndex(imageK,game.getKnight().getLocation().getY() );
//			points++;
//			game.getQueen().queenMove(3, Directions.LEFT);
//			GridPane.setColumnIndex(imageQ, game.getQueen().getLocation().getX());
//			GridPane.setRowIndex(imageQ,game.getQueen().getLocation().getY());
//		}
//		public void rightUp(ActionEvent event) throws IOException {
//			game.getKnight().level1Move(Directions.RIGHT, Directions.RIGHT, Directions.UP);
//			GridPane.setColumnIndex(imageK, game.getKnight().getLocation().getX());
//			GridPane.setRowIndex(imageK,game.getKnight().getLocation().getY() );
//			points++;
//			game.getQueen().queenMove(3, Directions.DOWN_RIGHT);
//			GridPane.setColumnIndex(imageQ, game.getQueen().getLocation().getX());
//			GridPane.setRowIndex(imageQ,game.getQueen().getLocation().getY());
//			
//		}
//		public void rightDown(ActionEvent event) throws IOException {
//			game.getKnight().level1Move(Directions.RIGHT, Directions.RIGHT, Directions.DOWN);
//			GridPane.setColumnIndex(imageK, game.getKnight().getLocation().getX());
//			GridPane.setRowIndex(imageK,game.getKnight().getLocation().getY() );
//			points++;
//			game.getQueen().queenMove(3, Directions.DOWN_LEFT);
//			GridPane.setColumnIndex(imageQ, game.getQueen().getLocation().getX());
//			GridPane.setRowIndex(imageQ,game.getQueen().getLocation().getY());
//		}
//		public void leftUp(ActionEvent event) throws IOException {
//			game.getKnight().level1Move(Directions.LEFT, Directions.LEFT, Directions.UP);
//			GridPane.setColumnIndex(imageK, game.getKnight().getLocation().getX());
//			GridPane.setRowIndex(imageK,game.getKnight().getLocation().getY() );
//			points++;
//			game.getQueen().queenMove(3, Directions.UP_RIGHT);
//			GridPane.setColumnIndex(imageQ, game.getQueen().getLocation().getX());
//			GridPane.setRowIndex(imageQ,game.getQueen().getLocation().getY());
//			
//		}
//		public void leftDown(ActionEvent event) throws IOException {
//			game.getKnight().level1Move(Directions.LEFT, Directions.LEFT, Directions.DOWN);
//			GridPane.setColumnIndex(imageK, game.getKnight().getLocation().getX());
//			GridPane.setRowIndex(imageK,game.getKnight().getLocation().getY() );
//			points++;
//			game.getQueen().queenMove(3, Directions.UP_LEFT);
//			GridPane.setColumnIndex(imageQ, game.getQueen().getLocation().getX());
//			GridPane.setRowIndex(imageQ,game.getQueen().getLocation().getY());
//		}
		}
