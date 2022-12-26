package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import Enum.DifficultyLevel;
import javafx.application.Application;
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
import javafx.scene.image.Image;
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
import model.Knight;
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
	Timer timer;
	Alert a = new Alert(AlertType.NONE);
	//timer fields;
	static long min,hr, sec,totalSec,points=0;
	
	static String buttonId;
	//Board boardGame = new Board();
	int finish=0;
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

		//Location loc =new Location(0,0);
		Knight knight = new Knight(false);
		ArrayList<Location> trya = new ArrayList<Location>();
		trya= game.getKnight().allValidMovesLevel2(knight);
		System.out.println(trya);
		fillNotVisitedArray(notVisited);
		Location locFirst = new Location(0,0);
		game.getKnight().setLocation(locFirst);
		b00.setStyle("-fx-background-color: grey;-fx-border-color : black;");
		boardGame.getSquares()[0][0].setVisited(true);
		notVisited.remove(boardGame.getSquares()[0][0]);
		
		GridPane.setColumnIndex(imageK, 0);
		GridPane.setRowIndex(imageK, 0);
		
		rand = new Random();
		node1Q = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
		
		node2Q = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
		
		while(node1Q==node2Q ) {
			node2Q = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
			
		}
		node2Q.setStyle("-fx-background-color: yellow; ");
		node3Q = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
		while(node2Q==node3Q ||node3Q==node1Q) {
			node3Q = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
			
		}
		node3Q.setStyle("-fx-background-color: red; ");
		nodeRandomJump1=board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
		while(node3Q==nodeRandomJump1 ||node1Q==nodeRandomJump1||node2Q==nodeRandomJump1 ) {
			nodeRandomJump1 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
			
		}
		nodeRandomJump1.setStyle("-fx-background-color: blue; ");
		nodeRandomJump2=board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
		while(nodeRandomJump1==nodeRandomJump2 ||node3Q==nodeRandomJump2 ||node2Q==nodeRandomJump2 ||node1Q==nodeRandomJump2 ) {
			nodeRandomJump2 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
			
		}
		nodeRandomJump2.setStyle("-fx-background-color: pink; ");
		nodeRandomJump3=board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
		while(nodeRandomJump2==nodeRandomJump3 ||nodeRandomJump1==nodeRandomJump3 ||node2Q==nodeRandomJump3
				||node1Q==nodeRandomJump3 ||node3Q==nodeRandomJump3) {
			nodeRandomJump3 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
			
		}
		nodeRandomJump3.setStyle("-fx-background-color: purple; ");
		while(node1Q== node2Q||node1Q== node3Q||node1Q== nodeRandomJump3||node1Q==nodeRandomJump2 ||node1Q==nodeRandomJump1 ) {
			node1Q = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
		}
		node1Q.setStyle("-fx-background-color: green; ");
		setTimer();
		displayLevel("LEVEL 1");
		pointsT.setText(String.valueOf(points));
		try {
			level1Moves();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			//Thread.sleep(7000);
	
		//setTimer();
		
		
	}
		// method that start timer in long one minute to every level in the game 
		public void setTimer(){
	
			totalSec=60;
				timer = new Timer();
				TimerTask timerTask = new TimerTask() {
					@Override
					public void run(){					
							convertTime();
							
							// we added the points text just for checking we will change it when we finish the game
							pointsT.setText("Points: " +String.valueOf(points));
							
							if(totalSec<=0) {	
								text.setText("00:00");
								finish +=1;
								try {
									nextLevel();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
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
		
	
		//method that pop hard question window in the middle of the game
		public void popHard() throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("/View/QuestionWindowHard.fxml"));
			Stage stage = new Stage(); 
			Scene scene = new Scene(root);
			stage.setAlwaysOnTop(true);
			stage.setResizable(false);
			scene.getStylesheets().add(getClass().getResource("/View/editQuestion.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}
		//method that pop easy question window in the middle of the game
		public void popEasy() throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("/View/QuestionWindowEasy.fxml"));
			Stage stage = new Stage(); 
			Scene scene = new Scene(root);
			stage.setAlwaysOnTop(true);
			stage.setResizable(false);
			scene.getStylesheets().add(getClass().getResource("/View/editQuestion.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}
		//method that pop mediocre question window in the middle of the game
		public void popMediocre() throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("/View/QuestionWindowMediocre.fxml"));
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
		
			for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
				
				((ButtonBase) board.getChildren().get(node)).setOnAction(this);
//				while(finish==0) {
//					System.out.print(" ya rab tozbot");
//				}
			}


		}
		public void level2Moves() throws IOException {
		
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
			ArrayList<Location> validsMovesLevel2 =new ArrayList<Location>();
			validsMovesLevel2 = game.getKnight().allValidMovesLevel2(game.getKnight());
			
			
			if(arg0.getSource()==node1Q) {
				Location locNode1 = new Location(GridPane.getColumnIndex(node1Q),GridPane.getRowIndex(node1Q));
				if(validsPrevious.contains(locNode1) && flag1 == 0) {
					try {
						flag1++;
						popEasy();
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
							popMediocre();
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
							popHard();
							node3Q.setStyle("-fx-background-color: defult; ");
							node3Q.setStyle("-fx-border-color : black");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
			Location locQueen = new Location();
			double smallestDistance = 11;
			for(int i = 0 ; i < 8 ; i++) {
				for(int j = 0 ; j < 8 ; j ++) {
					if(finish==0) {
						if(((Button)arg0.getSource()).getId().toString().equals("b"+""+i +""+j) ) {
							Location loc = new Location(j,i);
							
							if(validsPrevious.contains(loc) ) {
								game.getKnight().setLocation(loc);
								GridPane.setColumnIndex(imageK,j);
								GridPane.setRowIndex(imageK,i );
								if(!arg0.getSource().equals(nodeRandomJump1)&&!arg0.getSource().equals(nodeRandomJump2)&&!arg0.getSource().equals(nodeRandomJump3)) {
									ArrayList<Location> QueenValidMoves = new ArrayList<Location>();
									QueenValidMoves = game.getQueen().validMovesForQueen(game.getQueen());
		
									for(int k =0;k<QueenValidMoves.size();k++) {
										if(game.getQueen().shortestDistance(game.getKnight().getLocation(), QueenValidMoves.get(k))<smallestDistance) {
											smallestDistance=game.getQueen().shortestDistance(game.getKnight().getLocation(), QueenValidMoves.get(k));
											locQueen = QueenValidMoves.get(k);
										}
									}
									
									game.getQueen().setLocation(locQueen);
									GridPane.setColumnIndex(imageQ,locQueen.getX());
									GridPane.setRowIndex(imageQ,locQueen.getY());
									if(game.getQueen().getLocation().equals(game.getKnight().getLocation())) {
										timer.cancel();
										a.setAlertType(AlertType.ERROR);//if the user not enter data 
										a.setContentText("you lose");
										a.show();
									}
								}else {
									if(arg0.getSource()==nodeRandomJump1) {
										System.out.println(validsPrevious);
										Squares sq= notVisited.get(rand.nextInt(notVisited.size())); 
										Location loc0 = new Location(sq.getLocation().getX(),sq.getLocation().getY());
										System.out.println(validsPrevious);
						                System.out.println(game.getKnight().getLocation());
										//if(validsPrevious.contains(loc) ) {
											game.getKnight().setLocation(loc0);
											System.out.println(game.getKnight().getLocation());
											GridPane.setColumnIndex(imageK,sq.getLocation().getX());
											GridPane.setRowIndex(imageK,sq.getLocation().getY() );
											
											ArrayList<Location> QueenValidMoves = new ArrayList<Location>();
											QueenValidMoves = game.getQueen().validMovesForQueen(game.getQueen());
							
											for(int k =0;k<QueenValidMoves.size();k++) {
												if(game.getQueen().shortestDistance(game.getKnight().getLocation(), QueenValidMoves.get(k))<smallestDistance) {
													smallestDistance=game.getQueen().shortestDistance(game.getKnight().getLocation(), QueenValidMoves.get(k));
													locQueen = QueenValidMoves.get(k);
												}
											}
											game.getQueen().setLocation(locQueen);
											GridPane.setColumnIndex(imageQ,locQueen.getX());
											GridPane.setRowIndex(imageQ,locQueen.getY());
											if(game.getQueen().getLocation().equals(game.getKnight().getLocation())) {
												timer.cancel();
												a.setAlertType(AlertType.ERROR);//if the user not enter data 
												a.setContentText("you lose");
												a.show();
											}
											if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node1Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node1Q)) {
												try {
													popEasy();
												} catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											else if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node2Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node2Q) ) {
												try {
													
													popMediocre();
												} catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											else if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node3Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node3Q)) {
												try {
													
													popHard();
												} catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											boardGame.getSquares()[sq.getLocation().getY()][sq.getLocation().getX()].setVisited(true);
											notVisited.remove(boardGame.getSquares()[sq.getLocation().getY()][sq.getLocation().getX()]);
											String str = "b"+sq.getLocation().getY()+sq.getLocation().getX();
											for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
												if(board.getChildren().get(node).getId().toString().equals(str)) {
													((Button)board.getChildren().get(node)).setStyle("-fx-background-color: grey;-fx-border-color : black;");
												}
											}
										//}
										
										
									}
									if(arg0.getSource()==nodeRandomJump2) {
										Squares sq= notVisited.get(rand.nextInt(notVisited.size()));
										Location loc1 = new Location(sq.getLocation().getX(),sq.getLocation().getY());
										System.out.println(validsPrevious);
						              
										//if(validsPrevious.contains(loc) ) {
											game.getKnight().setLocation(loc1);
											System.out.println(game.getKnight().getLocation());
											GridPane.setColumnIndex(imageK,sq.getLocation().getX());
											GridPane.setRowIndex(imageK,sq.getLocation().getY() );
											notVisited.remove(sq);
											ArrayList<Location> QueenValidMoves = new ArrayList<Location>();
											QueenValidMoves = game.getQueen().validMovesForQueen(game.getQueen());
							
											for(int k =0;k<QueenValidMoves.size();k++) {
												if(game.getQueen().shortestDistance(game.getKnight().getLocation(), QueenValidMoves.get(k))<smallestDistance) {
													smallestDistance=game.getQueen().shortestDistance(game.getKnight().getLocation(), QueenValidMoves.get(k));
													locQueen = QueenValidMoves.get(k);
												}
											}
											game.getQueen().setLocation(locQueen);
											GridPane.setColumnIndex(imageQ,locQueen.getX());
											GridPane.setRowIndex(imageQ,locQueen.getY());
											if(game.getQueen().getLocation().equals(game.getKnight().getLocation())) {
												timer.cancel();
												a.setAlertType(AlertType.ERROR);//if the user not enter data 
												a.setContentText("you lose");
												a.show();
											}
											if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node1Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node1Q)) {
												try {
													popEasy();
												} catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											else if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node2Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node2Q) ) {
												try {
													
													popMediocre();
												} catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											else if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node3Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node3Q)) {
												try {
													
													popHard();
												} catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											boardGame.getSquares()[sq.getLocation().getY()][sq.getLocation().getX()].setVisited(true);
											notVisited.remove(boardGame.getSquares()[sq.getLocation().getY()][sq.getLocation().getX()]);
											String str = "b"+sq.getLocation().getY()+sq.getLocation().getX();
											for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
												if(board.getChildren().get(node).getId().toString().equals(str)) {
													board.getChildren().get(node).setStyle("-fx-background-color: grey;-fx-border-color : black;");
												}
											}
										//}
									}
									
									
									if(arg0.getSource()==nodeRandomJump3) {
										Squares sq= notVisited.get(rand.nextInt(notVisited.size()));
										Location loc2 = new Location(sq.getLocation().getX(),sq.getLocation().getY());
										System.out.println(validsPrevious);
						                System.out.println();
										//if(validsPrevious.contains(loc) ) {
											game.getKnight().setLocation(loc2);
											System.out.println(game.getKnight().getLocation());
											GridPane.setColumnIndex(imageK,sq.getLocation().getX());
											GridPane.setRowIndex(imageK,sq.getLocation().getY() );
											ArrayList<Location> QueenValidMoves = new ArrayList<Location>();
											QueenValidMoves = game.getQueen().validMovesForQueen(game.getQueen());
							
											for(int k =0;k<QueenValidMoves.size();k++) {
												if(game.getQueen().shortestDistance(game.getKnight().getLocation(), QueenValidMoves.get(k))<smallestDistance) {
													smallestDistance=game.getQueen().shortestDistance(game.getKnight().getLocation(), QueenValidMoves.get(k));
													locQueen = QueenValidMoves.get(k);
												}
											}
											game.getQueen().setLocation(locQueen);
											GridPane.setColumnIndex(imageQ,locQueen.getX());
											GridPane.setRowIndex(imageQ,locQueen.getY());
											if(game.getQueen().getLocation().equals(game.getKnight().getLocation())) {
												timer.cancel();
												a.setAlertType(AlertType.ERROR);//if the user not enter data 
												a.setContentText("you lose");
												a.show();
											}
											if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node1Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node1Q)) {
												try {
													popEasy();
												} catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											else if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node2Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node2Q) ) {
												try {
													
													popMediocre();
												} catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
											else if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node3Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node3Q)) {
												try {
													
													popHard();
												} catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}
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
								if(boardGame.getSquares()[i][j].isVisited() == true) {
									points--;
									System.out.println(notVisited);
									String str = "b"+boardGame.getSquares()[i][j].getLocation().getY()+boardGame.getSquares()[i][j].getLocation().getX();
									System.out.println(str);
									for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
										if(board.getChildren().get(node).getId().toString().equals(str)) {
											board.getChildren().get(node).setStyle("-fx-background-color: defult;");
											board.getChildren().get(node).setStyle("-fx-border-color : black;");
										}
									}
									notVisited.add(boardGame.getSquares()[i][j]);
									// boardGame.getSquares()[i][j].setVisited(false);
								}else {
									points++;
									System.out.println(notVisited);
									boardGame.getSquares()[i][j].setVisited(true);
									notVisited.remove(boardGame.getSquares()[i][j]);
									((Button)arg0.getSource()).setStyle("-fx-background-color: grey;-fx-border-color : black;");
								}
								
								
								
							
						}
							else {
								//ColorChange(loc,validsPrevious,b00);
								a.setAlertType(AlertType.ERROR);//if the user not enter data 
								a.setContentText("invalid move try again");
								a.show();	
							}
	
						}
				}
					else if(finish == 1)
						{
							if(((Button)arg0.getSource()).getId().toString().equals("b"+""+i +""+j) ) {
								Location loc = new Location(j,i);
								
								if(validsMovesLevel2.contains(loc) ) {
									game.getKnight().setLocation(loc);
									GridPane.setColumnIndex(imageK,j);
									GridPane.setRowIndex(imageK,i );
								}
							}
						}
					}

			}
			
			//}
			
		}
			public void ColorChange(Location locNew ,ArrayList<Location> valids,Node node) {
				if(valids.contains(locNew)) {						
					node.pseudoClassStateChanged(PSEUDO_CLASS_VALID, true);
					 
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
			public void nextLevel() throws IOException {
				
				if(points>15 && finish==1) {
					points=0;
					level2Moves();
					setTimer();
					displayLevel("LEVEL 2");
				}
				else if(points<15){
					timer.cancel();
					System.out.println("you lose !!");	
				}
//				Parent root = FXMLLoader.load(getClass().getResource("/View/pause.fxml"));
//				Stage stage = new Stage(); 
//				Scene scene = new Scene(root);
//				stage.setAlwaysOnTop(true);
//				stage.setResizable(false);
//				scene.getStylesheets().add(getClass().getResource("/View/editQuestion.css").toExternalForm());
//				stage.setScene(scene);
//				stage.show();
			}
			
			
		}
		
