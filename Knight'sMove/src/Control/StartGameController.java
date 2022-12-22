package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;

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
import model.Squares;
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
	Random rand;
	Game game = new Game();
	Board boardGame = new Board();
	Node node1Q,node2Q ,node3Q;
	Node nodeRandomJump1,nodeRandomJump2 ,nodeRandomJump3;
	ArrayList<Squares> notVisited = new ArrayList<Squares>();
	public static final PseudoClass PSEUDO_CLASS_VALID = PseudoClass.getPseudoClass("valid");
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		fillNotVisitedArray(notVisited);
		Location locFirst = new Location(0,0);
		game.getKnight().setLocation(locFirst);
		b00.setStyle("-fx-background-color: grey;-fx-border-color : black;");
		boardGame.getSquares()[0][0].setVisited(true);
		notVisited.remove(boardGame.getSquares()[0][0]);
		
		GridPane.setColumnIndex(imageK, 0);
		GridPane.setRowIndex(imageK, 0);
		
		
		try {
			level1Moves();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rand = new Random();
		node1Q = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
		node1Q.setStyle("-fx-background-color: red; ");
		node2Q = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
		node2Q.setStyle("-fx-background-color: red; ");
		node3Q = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
		node3Q.setStyle("-fx-background-color: red; ");
		nodeRandomJump1=board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
		//nodeRandomJump1.setStyle("-fx-background-color: green; ");
		nodeRandomJump2=board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
		//nodeRandomJump2.setStyle("-fx-background-color: green; ");
		nodeRandomJump3=board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
		//nodeRandomJump3.setStyle("-fx-background-color: green; ");
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

		
	
		public void level1Moves() throws IOException {
			Location loc =game.getKnight().getLocation();
			//validMoves= game.getKnight().allValidMovesLevel1(loc);
			for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
				
				((ButtonBase) board.getChildren().get(node)).setOnAction(this);
				
			}


			}
		int k = 0 , n = 0 ;
		int flag1 = 0  , flag2 = 0 , flag3 = 0;

		@Override
		public void handle(ActionEvent arg0) {
			ArrayList<Location> validsPrevious =new ArrayList<Location>();
			validsPrevious = game.getKnight().allValidMovesLevel1(game.getKnight());
			
			if(arg0.getSource()==node1Q) {
				Location locNode1 = new Location(GridPane.getColumnIndex(node1Q),GridPane.getRowIndex(node1Q));
				if(validsPrevious.contains(locNode1) && flag1 == 0) {
					try {
						flag1++;
						pop();
						node1Q.setStyle("-fx-background-color: defult; ");
						node1Q.setStyle("-fx-border-color : black");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
					
			}
			if(arg0.getSource()==node2Q) {
				Location locNode2 = new Location(GridPane.getColumnIndex(node2Q),GridPane.getRowIndex(node2Q));
				if(validsPrevious.contains(locNode2) && flag2 == 0) {
						try {
							flag2++;
							pop();
							node2Q.setStyle("-fx-background-color: defult ; ");
							node2Q.setStyle("-fx-border-color : black");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
			if(arg0.getSource()==node3Q) {
				Location locNode3 = new Location(GridPane.getColumnIndex(node3Q),GridPane.getRowIndex(node3Q));
				if(validsPrevious.contains(locNode3) && flag3 == 0) {
				try {
					       flag3++;
							pop();
							node3Q.setStyle("-fx-background-color: defult; ");
							node3Q.setStyle("-fx-border-color : black");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
			for(int i = 0 ; i < 8 ; i++) {
				for(int j = 0 ; j < 8 ; j ++) {
					
					if(((Button)arg0.getSource()).getId().toString().equals("b"+""+i +""+j) ) {
						Location loc = new Location(j,i);
						
						if(validsPrevious.contains(loc) ) {
							game.getKnight().setLocation(loc);
							GridPane.setColumnIndex(imageK,j);
							GridPane.setRowIndex(imageK,i );
							if(boardGame.getSquares()[i][j].isVisited() == true) {
								points--;
							}else 							points++;

							boardGame.getSquares()[i][j].setVisited(true);
							notVisited.remove(boardGame.getSquares()[i][j]);
							((Button)arg0.getSource()).setStyle("-fx-background-color: grey;-fx-border-color : black;");
							
							ArrayList<Location> valids =new ArrayList<Location>();
							valids = game.getKnight().allValidMovesLevel1(game.getKnight());
						
//							for(int node = 0 ; node < board.getChildren().size()-2 ; node++,n++) {
//								if(n>7) {
//									k++;
//									n=0;
//								}
//								Location locNew = new Location(n,k);
//	
//								ColorChange(locNew,valids, board.getChildren().get(node));
//							}
						
					}
						else {
							//ColorChange(loc,validsPrevious,b00);
							a.setAlertType(AlertType.ERROR);//if the user not enter data 
							a.setContentText("invalid move try again");
							a.show();	
						}

					}
				}

			}
			if(arg0.getSource()==nodeRandomJump1) {
				Squares sq= notVisited.get(rand.nextInt(notVisited.size())); 
				Location loc = new Location(sq.getLocation().getX(),sq.getLocation().getY());
				game.getKnight().setLocation(loc);
				GridPane.setColumnIndex(imageK,sq.getLocation().getX());
				GridPane.setRowIndex(imageK,sq.getLocation().getY() );
				boardGame.getSquares()[sq.getLocation().getY()][sq.getLocation().getX()].setVisited(true);
				notVisited.remove(boardGame.getSquares()[sq.getLocation().getY()][sq.getLocation().getX()]);
				String str = "b"+sq.getLocation().getY()+sq.getLocation().getX();
				for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
					if(board.getChildren().get(node).getId().toString().equals(str)) {
						((Button)board.getChildren().get(node)).setStyle("-fx-background-color: grey;-fx-border-color : black;");
					}
				}
				
				
			}
			if(arg0.getSource()==nodeRandomJump2) {
				Squares sq= notVisited.get(rand.nextInt(notVisited.size()));
				Location loc = new Location(sq.getLocation().getX(),sq.getLocation().getY());
				game.getKnight().setLocation(loc);
				GridPane.setColumnIndex(imageK,sq.getLocation().getX());
				GridPane.setRowIndex(imageK,sq.getLocation().getY() );
				boardGame.getSquares()[sq.getLocation().getY()][sq.getLocation().getX()].setVisited(true);
				notVisited.remove(boardGame.getSquares()[sq.getLocation().getY()][sq.getLocation().getX()]);
				String str = "b"+sq.getLocation().getY()+sq.getLocation().getX();
				for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
					if(board.getChildren().get(node).getId().toString().equals(str)) {
						board.getChildren().get(node).setStyle("-fx-background-color: grey;-fx-border-color : black;");
					}
				}
			}
			if(arg0.getSource()==nodeRandomJump3) {
				Squares sq= notVisited.get(rand.nextInt(notVisited.size()));
				Location loc = new Location(sq.getLocation().getX(),sq.getLocation().getY());
				game.getKnight().setLocation(loc);
				GridPane.setColumnIndex(imageK,sq.getLocation().getX());
				GridPane.setRowIndex(imageK,sq.getLocation().getY() );
				boardGame.getSquares()[sq.getLocation().getY()][sq.getLocation().getX()].setVisited(true);
				notVisited.remove(boardGame.getSquares()[sq.getLocation().getY()][sq.getLocation().getX()]);
				((Button)arg0.getSource()).setStyle("-fx-background-color: grey;");
				String str = "b"+sq.getLocation().getY()+sq.getLocation().getX();
				for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
					if(board.getChildren().get(node).getId().toString().equals(str)) {
						board.getChildren().get(node).setStyle("-fx-background-color: grey;-fx-border-color : black;");
					}
				}
			}
			
		}
			public void ColorChange(Location locNew ,ArrayList<Location> valids,Node node) {
				if(valids.contains(locNew)) {						
					node.pseudoClassStateChanged(PSEUDO_CLASS_VALID, true);
					//node.setStyle("-fx-background-color: green; "); 
					node1Q.setStyle("-fx-background-color: red; ");
					node2Q.setStyle("-fx-background-color: red; ");
					node3Q.setStyle("-fx-background-color: red; ");
				
				}else {
					
				}
				
			}
			public void fillNotVisitedArray(ArrayList<Squares> array) {					
				for(int i = 0 ; i < 8 ; i++) {
					for(int j = 0 ; j < 8 ; j ++) {
						array.add(boardGame.getSquares()[i][j]);
					}
					
				}				
			}
			
		}
		
