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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Board;
import model.Game;
import model.Location;
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
	@FXML
	private ImageView upleft;
	@FXML
	private ImageView upright;
	@FXML
	private ImageView downleft;
	@FXML
	private ImageView downright;
	@FXML
	private ImageView leftup;
	@FXML
	private ImageView rightup;
	@FXML
	private ImageView rightdown;
	@FXML
	private ImageView leftdown;
	@FXML
	private ImageView knight;
	@FXML
	private ImageView imageKing;
	int speed=5;
	int counter = 0;
	
	Alert a = new Alert(AlertType.NONE);
	//timer fields;
	static long min,hr, sec,totalSec;
	static int points=0;
	static String buttonId;
	//Board boardGame = new Board();
	int finish=0;
	ArrayList<Squares>  forgetsSquares = new ArrayList<Squares>();
	Location knightLoc = new Location();
	Random rand;
	Game game = new Game();
	Board boardGame = new Board();
	Node node1Q,node2Q ,node3Q;
	Node nodeRandomJump1,nodeRandomJump2 ,nodeRandomJump3;
	int flagtest=0;
	int k = 0 , n = 0 ;
	int flag1 = 0  , flag2 = 0 , flag3 = 0;
	Node Forget1 ,Forget2 , Forget3;
	Node block1, block2, block3, block4, block5, block6, block7, block8;
	ArrayList<Squares> notVisited = new ArrayList<Squares>();
	Location locKing = new Location();
	Location locKing2 = new Location();
	Location locKing3 = new Location();
	Location locKing4 = new Location();
	Timer timer1 =new Timer();
	Timer timer2 =new Timer();
	Timer timer3 =new Timer();
	Timer timer4 =new Timer();
	Location locKnight = new Location(0,0) ;
	ArrayList<Location> KingValidMoves = new ArrayList<Location>();
	
	double smallestDistance = 11 , smallestDistance2 = 11,smallestDistance3=11,smallestDistance4=11;
	
	public static final PseudoClass PSEUDO_CLASS_VALID = PseudoClass.getPseudoClass("valid");
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		for(int i = 0 ; i < 8 ; i++) {
//			for(int j = 0 ; j < 8 ; j ++) {
//				boardGame.getSquares()[i][j].setVisited(false);;
//			}
//			
//		}
		
		totalSec=10;
		points=0;
		game.setPoints(0);
		imageKing.setVisible(false);
		fillNotVisitedArray(notVisited);
		Location locFirst = new Location(0,0);
		game.getKnight().setLocation(locFirst);
		b00.setStyle("-fx-background-color: grey;-fx-border-color : black;");
		boardGame.getSquares()[0][0].setVisited(true);
		points++;
		game.setPoints(points);
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
		setTimer(timer1);
		displayLevel("LEVEL 1");
	//	pointsT.setText(String.valueOf(points));
		try {
			levelsMoves();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
	}
	public void gamestatusLose(ActionEvent event) throws Exception {

		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/View/gameStatus.fxml"));
		Parent root = loader.load();
		gameStatusController status = loader.getController();
		//send the username to start game controller to display
		status.displayLevel(level.getText());
		//int total = game.getPoints()+points;
		status.displayPoints(game.getPoints());
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		//Stage stage = new Stage();
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("/View/StartGame.css").toExternalForm());
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		}
	public void gamestatuswon(ActionEvent event) throws Exception {

		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/View/gameStatus.fxml"));
		Parent root = loader.load();
		gameStatusController status = loader.getController();
		//send the username to start game controller to display
		status.displayLevel("YOU WON");
		//int total = game.getPoints()+points;
		status.displayPoints(game.getPoints());
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		//Stage stage = new Stage();
		Scene scene = new Scene(root);
		root.setStyle("-fx-background-color: green; ");
		//scene.getStylesheets().add(getClass().getResource("/View/StartGame.css").toExternalForm());
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		}
		public void kingMove(long totalSec){
			knightLoc=locKnight;
			smallestDistance=11;
			if(totalSec%speed == 0) {
				for(int k =0;k<KingValidMoves.size();k++) {
					if(game.getKing().shortestDistance(knightLoc, KingValidMoves.get(k)) < smallestDistance ) {
						smallestDistance=game.getKing().shortestDistance(knightLoc, KingValidMoves.get(k));
						locKing = KingValidMoves.get(k);
					}
				}
				game.getKing().setLocation(locKing);
				KingValidMoves=game.getKing().validMovesForKing(game.getKing());
				GridPane.setColumnIndex(imageKing,locKing.getX());
				GridPane.setRowIndex(imageKing,locKing.getY());
			}
			if(totalSec%10==0) {
				if(speed!=2)
				speed--;
			}
		}
		// method that start timer in long one minute to every level in the game 
		public void setTimer(Timer timer){
				TimerTask timerTask = new TimerTask() {
					@Override
					public void run(){					
							convertTime();
							if(finish == 2 || finish == 3) {
								//if(totalSec%speed == 0) {
									kingMove(totalSec);
								//}	
							}
							
							// we added the points text just for checking we will change it when we finish the game
							pointsT.setText("Points: " +String.valueOf(points));
							
							if(totalSec<=0) {	
								text.setText("00:00");
								finish +=1;
								try {
									nextLevel();
								} catch (IOException e) {
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

		
	
		public void levelsMoves() throws IOException {
		
			for(int node = 0 ; node < board.getChildren().size()-3 ; node++) {
				
				((ButtonBase) board.getChildren().get(node)).setOnAction(this);
			}


		}
		
		
	
		@Override
		public void handle(ActionEvent arg0) {
			ArrayList<Location> validsMovesLevel1 =new ArrayList<Location>();
			validsMovesLevel1 = game.getKnight().allValidMovesLevel1(game.getKnight());
			ArrayList<Location> validsMovesLevel2 =new ArrayList<Location>();
			validsMovesLevel2 = game.getKnight().allValidMovesLevel2(game.getKnight());
			ArrayList<Location>  validsMovesLevel3 = new ArrayList<Location>();
			validsMovesLevel3 = game.getKnight().allValidMovesLevel2(game.getKnight());
			ArrayList<Location>  validsMovesLevel4 = new ArrayList<Location>();
			validsMovesLevel4 = game.getKnight().allValidMovesLevel2(game.getKnight());
			Location locQueen = new Location();
			double smallestDistance = 11;
			for(int i = 0 ; i < 8 ; i++) {
				for(int j = 0 ; j < 8 ; j ++) {
					if(finish==0) {

						if(((Button)arg0.getSource()).getId().toString().equals("b"+""+i +""+j) ) {
							Location loc = new Location(j,i);
							
							if(validsMovesLevel1.contains(loc) ) {
								
								game.getKnight().setLocation(loc);
								GridPane.setColumnIndex(imageK,j);
								GridPane.setRowIndex(imageK,i );
								if(arg0.getSource()==node1Q && flag1==0) {
									try {
										popEasy();
									} catch (IOException e) {
										e.printStackTrace();
									}
									game.setPoints(points);
									flag1++;
								}
								 if(arg0.getSource()==node2Q && flag2==0) {
									flag2++;
									try {
										popMediocre();
									} catch (IOException e) {
										e.printStackTrace();
									}
									game.setPoints(points);
								 }
								 if(arg0.getSource()==node3Q && flag3==0) {
										flag3++;
										try {
											popHard();
										} catch (IOException e) {
											e.printStackTrace();
										}
										game.setPoints(points);
								 }
								 
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
										
										for(int player = 0 ; player<SysData.getInstance().getPlayers().size();player++) {
											if(SysData.getInstance().getPlayers().get(player).getNickname().equals(UserNameController.Name) ){
												game.setPlayer(SysData.getInstance().getPlayers().get(player));
												SysData.getInstance().getPlayers().get(player).getGamesHistory().add(game);
											}
										}
										timer1.cancel();
										try {
											gamestatusLose(arg0);
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								}else {
									if(arg0.getSource()==nodeRandomJump1 || arg0.getSource()==nodeRandomJump2 ||arg0.getSource()==nodeRandomJump3) {
										
										Squares sq= notVisited.get(rand.nextInt(notVisited.size())); 
										Location loc0 = new Location(sq.getLocation().getX(),sq.getLocation().getY());
										game.getKnight().setLocation(loc0);
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
											timer1.cancel();
											for(int player = 0 ; player<SysData.getInstance().getPlayers().size();player++) {
												if(SysData.getInstance().getPlayers().get(player).getNickname().equals(UserNameController.Name)) {
													game.setPlayer(SysData.getInstance().getPlayers().get(player));
													System.out.println(game);
													SysData.getInstance().getPlayers().get(player).getGamesHistory().add(game);
													//System.out.println(SysData.getInstance().getPlayers().get(player).getGamesHistory());
												}
											}
											try {
												gamestatusLose(arg0);
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
										if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node1Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node1Q)) {
											try {
												popEasy();
												flag1++;
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
										else if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node2Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node2Q) ) {
											try {										
												popMediocre();
												flag2++;
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
										else if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node3Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node3Q)) {
											try {									
												popHard();
												flag3++;
											} catch (IOException e) {
											
												e.printStackTrace();
											}
										}
										boardGame.getSquares()[sq.getLocation().getY()][sq.getLocation().getX()].setVisited(true);
										notVisited.remove(boardGame.getSquares()[sq.getLocation().getY()][sq.getLocation().getX()]);
										((Button)arg0.getSource()).setStyle("-fx-background-color: grey;-fx-border-color : black;");
										String str = "b"+sq.getLocation().getY()+sq.getLocation().getX();
										for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
											if(board.getChildren().get(node).getId().toString().equals(str)) {
												((Button)board.getChildren().get(node)).setStyle("-fx-background-color: grey;-fx-border-color : black;");
											}
										}
										
										
										
									}
									
								}
								if(boardGame.getSquares()[i][j].isVisited() == true) {
									points--;
									game.setPoints(points);
									boardGame.getSquares()[i][j].setNumVisits(boardGame.getSquares()[i][j].getNumVisits()+1);
								}else {
									points++;
									game.setPoints(points);
									boardGame.getSquares()[i][j].setNumVisits(boardGame.getSquares()[i][j].getNumVisits()+1);
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
									if(arg0.getSource()==node1Q && flag1==0) {
										try {
											popEasy();
										} catch (IOException e) {
											e.printStackTrace();
										}
										flag1++;
									}
									 if(arg0.getSource()==node2Q && flag2==0) {
										flag2++;
										try {
											popMediocre();
										} catch (IOException e) {
											
											e.printStackTrace();
										}
									 }
									 if(arg0.getSource()==node3Q && flag3==0) {
											flag3++;
											try {
												popHard();
											} catch (IOException e) {
												
												e.printStackTrace();
											}
									 }
									 if(boardGame.getSquares()[i][j].isVisited() == true) {
											points--;
											int visitsTime =boardGame.getSquares()[i][j].getNumVisits();
											boardGame.getSquares()[i][j].setNumVisits(visitsTime+1);
										}else {
											points++;
											int visitsTime =boardGame.getSquares()[i][j].getNumVisits();
											boardGame.getSquares()[i][j].setNumVisits(visitsTime+1);
											boardGame.getSquares()[i][j].setVisited(true);
											notVisited.remove(boardGame.getSquares()[i][j]);
											((Button)arg0.getSource()).setStyle("-fx-background-color: grey;-fx-border-color : black;");
										}
									if(!forgetsSquares.contains(boardGame.getSquares()[0][0]) && flagtest==0) {
										forgetsSquares.add(boardGame.getSquares()[0][0]);
										int visitsTime =boardGame.getSquares()[0][0].getNumVisits();
										boardGame.getSquares()[0][0].setNumVisits(visitsTime+1);
										flagtest++;
										
									}
									
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
										timer2.cancel();
										int total = game.getPoints()+points;
										game.setPoints(total);
										for(int player = 0 ; player<SysData.getInstance().getPlayers().size();player++) {
											if(SysData.getInstance().getPlayers().get(player).getNickname().equals(UserNameController.Name)) {
												game.setPlayer(SysData.getInstance().getPlayers().get(player));
												Game gamex = new Game();
												gamex=game;
												SysData.getInstance().getPlayers().get(player).getGamesHistory().add(gamex);
												System.out.println(SysData.getInstance().getPlayers().get(player).getGamesHistory());
											}
										}
										try {
											gamestatusLose(arg0);
										} catch (Exception e) {
											e.printStackTrace();
										}

									}
									
									if(arg0.getSource().equals(Forget1) || arg0.getSource().equals(Forget2) || arg0.getSource().equals(Forget3) ) {
								
										if(forgetsSquares.size()!=0) {
											System.out.println(forgetsSquares.size());
											if(forgetsSquares.size()==1) {
												if(forgetsSquares.get(0).getNumVisits()==1) {
													boardGame.getSquares()[forgetsSquares.get(0).getLocation().getY()][forgetsSquares.get(0).getLocation().getX()].setVisited(false);
													String str = "b"+forgetsSquares.get(0).getLocation().getY()+forgetsSquares.get(0).getLocation().getX();
													for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
														if(board.getChildren().get(node).getId().toString().equals(str)) {
															board.getChildren().get(node).setStyle("-fx-background-color: defult;");
															board.getChildren().get(node).setStyle("-fx-border-color : black;");
														}
													}
													notVisited.add(forgetsSquares.get(0));
													forgetsSquares.get(0).setNumVisits(0);
													points--;
													forgetsSquares.remove(0);
												}
												else {
													points++;
													int numVisits=forgetsSquares.get(0).getNumVisits();
													forgetsSquares.get(0).setNumVisits(numVisits-1);
													forgetsSquares.remove(0);
												}
											}
											else if(forgetsSquares.size()==2) {
												for(int square = forgetsSquares.size()-1 ;square>forgetsSquares.size()-3;square-- ) {
													if(forgetsSquares.get(square).getNumVisits()==1) {
														boardGame.getSquares()[forgetsSquares.get(square).getLocation().getY()][forgetsSquares.get(square).getLocation().getX()].setVisited(false);
														forgetsSquares.get(square).setNumVisits(0);
														String str = "b"+forgetsSquares.get(square).getLocation().getY()+forgetsSquares.get(square).getLocation().getX();
														for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
															if(board.getChildren().get(node).getId().toString().equals(str)) {
																board.getChildren().get(node).setStyle("-fx-background-color: defult;");
																board.getChildren().get(node).setStyle("-fx-border-color : black;");
															}
														}
														notVisited.add(forgetsSquares.get(square));
														points--;
														
													}
													else {
														points++;
														
														int numVisits=forgetsSquares.get(square).getNumVisits();
														forgetsSquares.get(square).setNumVisits(numVisits-1);
													}
												}
												forgetsSquares.remove(forgetsSquares.size()-1);
												forgetsSquares.remove(forgetsSquares.size()-1);
//												
//												if(forgetsSquares.get(1).getNumVisits()==1) {
//													boardGame.getSquares()[forgetsSquares.get(1).getLocation().getY()][forgetsSquares.get(1).getLocation().getX()].setVisited(false);
//													forgetsSquares.get(1).setNumVisits(0);
//													points--;
//													String str = "b"+forgetsSquares.get(1).getLocation().getY()+forgetsSquares.get(1).getLocation().getX();
//													for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
//														if(board.getChildren().get(node).getId().toString().equals(str)) {
//															board.getChildren().get(node).setStyle("-fx-background-color: defult;");
//															board.getChildren().get(node).setStyle("-fx-border-color : black;");
//														}
//													}
//													notVisited.add(forgetsSquares.get(1));
//													forgetsSquares.remove(1);
//												}
//												else {
//													points++;
//													int numVisits=forgetsSquares.get(1).getNumVisits();
//													forgetsSquares.get(1).setNumVisits(numVisits-1);
//													forgetsSquares.remove(1);
//												}
//												if(forgetsSquares.get(0).getNumVisits()==1) {
//													boardGame.getSquares()[forgetsSquares.get(0).getLocation().getY()][forgetsSquares.get(0).getLocation().getX()].setVisited(false);
//													forgetsSquares.get(0).setNumVisits(0);
//													String str = "b"+forgetsSquares.get(0).getLocation().getY()+forgetsSquares.get(0).getLocation().getX();
//													for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
//														if(board.getChildren().get(node).getId().toString().equals(str)) {
//															board.getChildren().get(node).setStyle("-fx-background-color: defult;");
//															board.getChildren().get(node).setStyle("-fx-border-color : black;");
//														}
//													}
//													points--;
//													notVisited.add(forgetsSquares.get(0));
//													forgetsSquares.remove(0);
//												}
//												else {
//													points++;
//													int numVisits=forgetsSquares.get(0).getNumVisits();
//													forgetsSquares.get(0).setNumVisits(numVisits-1);
//													forgetsSquares.remove(0);
//												}
												
												
											}
											else
												if(forgetsSquares.size()>=3) {
												for(int square = forgetsSquares.size()-1 ;square>forgetsSquares.size()-4;square-- ) {
													if(forgetsSquares.get(square).getNumVisits()==1) {
														boardGame.getSquares()[forgetsSquares.get(square).getLocation().getY()][forgetsSquares.get(square).getLocation().getX()].setVisited(false);
														forgetsSquares.get(square).setNumVisits(0);
														String str = "b"+forgetsSquares.get(square).getLocation().getY()+forgetsSquares.get(square).getLocation().getX();
														for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
															if(board.getChildren().get(node).getId().toString().equals(str)) {
																board.getChildren().get(node).setStyle("-fx-background-color: defult;");
																board.getChildren().get(node).setStyle("-fx-border-color : black;");
															}
														}
														notVisited.add(forgetsSquares.get(square));
														points--;
														
													}
													else {
														points++;
														
														int numVisits=forgetsSquares.get(square).getNumVisits();
														forgetsSquares.get(square).setNumVisits(numVisits-1);
													}
												}
												forgetsSquares.remove(forgetsSquares.size()-1);
												forgetsSquares.remove(forgetsSquares.size()-1);
												forgetsSquares.remove(forgetsSquares.size()-1);
												
											}
										}
									}
									
									if(!forgetsSquares.contains(boardGame.getSquares()[i][j])) {
										forgetsSquares.add(boardGame.getSquares()[i][j]);
										
									}
									
									
									
									
								}
								else {
									a.setAlertType(AlertType.ERROR);//if the user not enter data 
									a.setContentText("invalid move try again");
									a.show();	
								}
								
								
							}
						}
					else if(finish == 2)
					{
					
						if(((Button)arg0.getSource()).getId().toString().equals("b"+""+i +""+j) ) {
							Location loc = new Location(j,i);
							
							if(validsMovesLevel3.contains(loc) ) {
								game.getKnight().setLocation(loc);
								GridPane.setColumnIndex(imageK,j);
								GridPane.setRowIndex(imageK,i );
								if(arg0.getSource()==node1Q && flag1==0) {
									try {
										popEasy();
									} catch (IOException e) {
										e.printStackTrace();
									}
									flag1++;
									
								}
								 if(arg0.getSource()==node2Q && flag2==0) {
									flag2++;
									try {
										popMediocre();
									} catch (IOException e) {
										e.printStackTrace();
									}
								 }
								 if(arg0.getSource()==node3Q && flag3==0) {
										flag3++;
										try {
											popHard();
										} catch (IOException e) {
											
											e.printStackTrace();
										}
										
								 }
								locKnight =loc;
								if(!forgetsSquares.contains(boardGame.getSquares()[0][0]) && flagtest==0) {
									forgetsSquares.add(boardGame.getSquares()[0][0]);
									int visitsTime =boardGame.getSquares()[0][0].getNumVisits();
									boardGame.getSquares()[0][0].setNumVisits(visitsTime+1);
									flagtest++;
									
								}
								
								if(boardGame.getSquares()[i][j].isVisited() == true) {
									points--;
									
									int visitsTime =boardGame.getSquares()[i][j].getNumVisits();
									boardGame.getSquares()[i][j].setNumVisits(visitsTime+1);
								}else {
									points++;
									
									int visitsTime =boardGame.getSquares()[i][j].getNumVisits();
									boardGame.getSquares()[i][j].setNumVisits(visitsTime+1);
									boardGame.getSquares()[i][j].setVisited(true);
									notVisited.remove(boardGame.getSquares()[i][j]);
									((Button)arg0.getSource()).setStyle("-fx-background-color: grey;-fx-border-color : black;");
								}
								if(arg0.getSource()==nodeRandomJump1 ||arg0.getSource()==nodeRandomJump2) {
									Squares sq= notVisited.get(rand.nextInt(notVisited.size()));
									Location loc2 = new Location(sq.getLocation().getX(),sq.getLocation().getY());
									game.getKnight().setLocation(loc2);
									GridPane.setColumnIndex(imageK,sq.getLocation().getX());
									GridPane.setRowIndex(imageK,sq.getLocation().getY() );
									if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node1Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node1Q)) {
										try {
											popEasy();
											flag1++;
										} catch (IOException e) {
											
											e.printStackTrace();
										}
										
									}
									else if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node2Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node2Q) ) {
										try {												
											popMediocre();
											flag2++;
										} catch (IOException e) {
											
											e.printStackTrace();
										}
									
									}
									else if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node3Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node3Q)) {
										try {									
											popHard();
											flag3++;
										} catch (IOException e) {
											
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
								
								if(arg0.getSource().equals(Forget1) || arg0.getSource().equals(Forget2)) {
									
									if(forgetsSquares.size()!=0) {
										
										if(forgetsSquares.size()==1) {
											if(forgetsSquares.get(0).getNumVisits()==1) {
												boardGame.getSquares()[forgetsSquares.get(0).getLocation().getY()][forgetsSquares.get(0).getLocation().getX()].setVisited(false);
												String str = "b"+forgetsSquares.get(0).getLocation().getY()+forgetsSquares.get(0).getLocation().getX();
												for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
													if(board.getChildren().get(node).getId().toString().equals(str)) {
														board.getChildren().get(node).setStyle("-fx-background-color: defult;");
														board.getChildren().get(node).setStyle("-fx-border-color : black;");
													}
												}
												notVisited.add(forgetsSquares.get(0));
												forgetsSquares.get(0).setNumVisits(0);
												points--;
												
												forgetsSquares.remove(0);
											}
											else {
												points++;
												
												int numVisits=forgetsSquares.get(0).getNumVisits();
												forgetsSquares.get(0).setNumVisits(numVisits-1);
												forgetsSquares.remove(0);
											}
										}
										else if(forgetsSquares.size()==2) {
											for(int square = forgetsSquares.size()-1 ;square>forgetsSquares.size()-3;square-- ) {
												if(forgetsSquares.get(square).getNumVisits()==1) {
													boardGame.getSquares()[forgetsSquares.get(square).getLocation().getY()][forgetsSquares.get(square).getLocation().getX()].setVisited(false);
													forgetsSquares.get(square).setNumVisits(0);
													String str = "b"+forgetsSquares.get(square).getLocation().getY()+forgetsSquares.get(square).getLocation().getX();
													for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
														if(board.getChildren().get(node).getId().toString().equals(str)) {
															board.getChildren().get(node).setStyle("-fx-background-color: defult;");
															board.getChildren().get(node).setStyle("-fx-border-color : black;");
														}
													}
													notVisited.add(forgetsSquares.get(square));
													points--;
													
												}
												else {
													points++;
													
													int numVisits=forgetsSquares.get(square).getNumVisits();
													forgetsSquares.get(square).setNumVisits(numVisits-1);
												}
											}
											forgetsSquares.remove(forgetsSquares.size()-1);
											forgetsSquares.remove(forgetsSquares.size()-1);
//											if(forgetsSquares.get(1).getNumVisits()==1) {
//												boardGame.getSquares()[forgetsSquares.get(1).getLocation().getY()][forgetsSquares.get(1).getLocation().getX()].setVisited(false);
//												forgetsSquares.get(1).setNumVisits(0);
//												points--;
//												
//												String str = "b"+forgetsSquares.get(1).getLocation().getY()+forgetsSquares.get(1).getLocation().getX();
//												for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
//													if(board.getChildren().get(node).getId().toString().equals(str)) {
//														board.getChildren().get(node).setStyle("-fx-background-color: defult;");
//														board.getChildren().get(node).setStyle("-fx-border-color : black;");
//													}
//												}
//												notVisited.add(forgetsSquares.get(1));
//												forgetsSquares.remove(1);
//											}
//											else {
//												points++;
//												
//												int numVisits=forgetsSquares.get(1).getNumVisits();
//												forgetsSquares.get(1).setNumVisits(numVisits-1);
//												forgetsSquares.remove(1);
//											}
//											if(forgetsSquares.get(0).getNumVisits()==1) {
//												boardGame.getSquares()[forgetsSquares.get(0).getLocation().getY()][forgetsSquares.get(0).getLocation().getX()].setVisited(false);
//												forgetsSquares.get(0).setNumVisits(0);
//												String str = "b"+forgetsSquares.get(0).getLocation().getY()+forgetsSquares.get(0).getLocation().getX();
//												for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
//													if(board.getChildren().get(node).getId().toString().equals(str)) {
//														board.getChildren().get(node).setStyle("-fx-background-color: defult;");
//														board.getChildren().get(node).setStyle("-fx-border-color : black;");
//													}
//												}
//												points--;
//												
//												notVisited.add(forgetsSquares.get(0));
//												forgetsSquares.remove(0);
//											}
//											else {
//												points++;
//												
//												int numVisits=forgetsSquares.get(0).getNumVisits();
//												forgetsSquares.get(0).setNumVisits(numVisits-1);
//												forgetsSquares.remove(0);
//											}
//											
											
										}
										else
											if(forgetsSquares.size()>=3) {
											for(int square = forgetsSquares.size()-1 ;square>forgetsSquares.size()-4;square-- ) {
												if(forgetsSquares.get(square).getNumVisits()==1) {
													boardGame.getSquares()[forgetsSquares.get(square).getLocation().getY()][forgetsSquares.get(square).getLocation().getX()].setVisited(false);
													forgetsSquares.get(square).setNumVisits(0);
													String str = "b"+forgetsSquares.get(square).getLocation().getY()+forgetsSquares.get(square).getLocation().getX();
													for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
														if(board.getChildren().get(node).getId().toString().equals(str)) {
															board.getChildren().get(node).setStyle("-fx-background-color: defult;");
															board.getChildren().get(node).setStyle("-fx-border-color : black;");
														}
													}
													notVisited.add(forgetsSquares.get(square));
													points--;
													
												}
												else {
													points++;
													
													int numVisits=forgetsSquares.get(square).getNumVisits();
													forgetsSquares.get(square).setNumVisits(numVisits-1);
												}
											}
											forgetsSquares.remove(forgetsSquares.size()-1);
											forgetsSquares.remove(forgetsSquares.size()-1);
											forgetsSquares.remove(forgetsSquares.size()-1);
											
										}
									}
								}
								if(!forgetsSquares.contains(boardGame.getSquares()[i][j])) {
									forgetsSquares.add(boardGame.getSquares()[i][j]);
									
								}
								
							}
							else {
								a.setAlertType(AlertType.ERROR);//if the user not enter data 
								a.setContentText("invalid move try again");
								a.show();	
							}
							
						}
					}
					else if(finish == 3)
					{
						if(((Button)arg0.getSource()).getId().toString().equals("b"+""+i +""+j) ) {
							Location loc = new Location(j,i);
							
							if(validsMovesLevel4.contains(loc) ) {
								if(arg0.getSource()!=block1 &&arg0.getSource()!=block2 &&arg0.getSource()!=block3 &&
									arg0.getSource()!=block4 &&arg0.getSource()!=block5 &&arg0.getSource()!=block6 &&
									arg0.getSource()!=block7 &&arg0.getSource()!=block8) {
									
									game.getKnight().setLocation(loc);
									GridPane.setColumnIndex(imageK,j);
									GridPane.setRowIndex(imageK,i );
									if(arg0.getSource()==node1Q && flag1==0) {
										try {
											popEasy();
										} catch (IOException e) {
											e.printStackTrace();
										}
										flag1++;
										
									}
									 if(arg0.getSource()==node2Q && flag2==0) {
										flag2++;
										try {
											popMediocre();
										} catch (IOException e) {
											e.printStackTrace();
										}
										
									 }
									 if(arg0.getSource()==node3Q && flag3==0) {
											flag3++;
											try {
												popHard();
											} catch (IOException e) {
												e.printStackTrace();
											}
											
									 }
									 locKnight =loc;
									if(boardGame.getSquares()[i][j].isVisited() == true) {
										points--;
										
										int visitsTime =boardGame.getSquares()[i][j].getNumVisits();
										boardGame.getSquares()[i][j].setNumVisits(visitsTime+1);
									}else {
										points++;
										
										int visitsTime =boardGame.getSquares()[i][j].getNumVisits();
										boardGame.getSquares()[i][j].setNumVisits(visitsTime+1);
										boardGame.getSquares()[i][j].setVisited(true);
										notVisited.remove(boardGame.getSquares()[i][j]);
										((Button)arg0.getSource()).setStyle("-fx-background-color: grey;-fx-border-color : black;");
									}
								}
								
							}
							else {
								a.setAlertType(AlertType.ERROR);//if the user not enter data 
								a.setContentText("invalid move try again");
								a.show();	
							}
						}
					}
				
				}
				

			}
			

			
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
			public void pause(ActionEvent event) throws IOException {
				//Parent root = FXMLLoader.load(getClass().getResource("/View/pause.fxml"));
				//timer.cancel();
				Stage stage = new Stage();
				
				
				FXMLLoader loader =  new FXMLLoader(getClass().getResource("/View/pause.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root);
				//Parent root = loader.load();
				pauseController pc = loader.getController();
				pc.setX(totalSec);
				stage.setResizable(false);
				scene.getStylesheets().add(getClass().getResource("/View/mainScreen.css").toExternalForm());
				stage.setScene(scene);			
				stage.show();
			}
			public void fillNotVisitedArray(ArrayList<Squares> array) {					
				for(int i = 0 ; i < 8 ; i++) {
					for(int j = 0 ; j < 8 ; j ++) {
						array.add(boardGame.getSquares()[i][j]);
					}
					
				}				
			}
			public void nextLevel() throws IOException {
				
				if(points>=0 && finish==1) {
					flag1=0;
					flag2=0;
					flag3=0;
					totalSec=10;
					
					for(int i = 0 ; i < 8 ; i++) {
						for(int j = 0 ; j < 8 ; j ++) {
							boardGame.getSquares()[i][j].setVisited(false);
							boardGame.getSquares()[i][j].setNumVisits(0);
						}
						
					}

					for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
						board.getChildren().get(node).setStyle("-fx-background-color: defult;");
						board.getChildren().get(node).setStyle("-fx-border-color : black;");
					}
					fillNotVisitedArray(notVisited);
					points=1;
					Location locFirst = new Location(0,0);
					game.getKnight().setLocation(locFirst);
					
					boardGame.getSquares()[0][0].setVisited(true);
					notVisited.remove(boardGame.getSquares()[0][0]);
					GridPane.setColumnIndex(imageK, 0);
					GridPane.setRowIndex(imageK, 0);
					pointsT.setText(String.valueOf(points));
					game.getQueen().setLocation(new Location(7,0));
					GridPane.setColumnIndex(imageQ,7);
					GridPane.setRowIndex(imageQ,0);
					imageKing.setVisible(false);
					upleft.setVisible(false);
					upright.setVisible(false);
					leftup.setVisible(false);
					rightup.setVisible(false);
					rightdown.setVisible(false);
					leftdown.setVisible(false);
					downright.setVisible(false);
					downleft.setVisible(false);
					knight.setVisible(false);
					
					b00.setStyle("-fx-background-color: grey;-fx-border-color : black;");
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
					node1Q.setStyle("-fx-background-color: green; ");

					Forget1 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(Forget1==node1Q ||Forget1==node2Q || Forget1==node3Q) {
						Forget1 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					Forget1.setStyle("-fx-background-color: lightblue; ");
					Forget2 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(Forget1==Forget2 || Forget2==node1Q ||Forget2==node2Q || Forget2==node3Q) {
						Forget2 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					Forget2.setStyle("-fx-background-color: orange; ");
					Forget3 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(Forget2==Forget3 || Forget1==Forget3 || Forget3==node1Q ||Forget3==node2Q || Forget3==node3Q) {
						Forget3 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					Forget3.setStyle("-fx-background-color: orange; ");
					
					levelsMoves();
					setTimer(timer2);
					displayLevel("LEVEL 2");
					
					
				}
				else if(points<15&& finish==1){
			//		timer2.cancel();
					
					
				}
				if(points>=0 && finish==2) {
					
					for(int i = 0 ; i < 8 ; i++) {
						for(int j = 0 ; j < 8 ; j ++) {
							boardGame.getSquares()[i][j].setVisited(false);;
							boardGame.getSquares()[i][j].setNumVisits(0);
						}
					}
					fillNotVisitedArray(notVisited);
					for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
						board.getChildren().get(node).setStyle("-fx-background-color: defult;");
						board.getChildren().get(node).setStyle("-fx-border-color : black;");
					}
					points=0;
					Location locFirst = new Location(0,0);
					game.getKnight().setLocation(locFirst);
					b00.setStyle("-fx-background-color: grey;-fx-border-color : black;");
					boardGame.getSquares()[0][0].setVisited(true);
					points++;
					
					notVisited.remove(boardGame.getSquares()[0][0]);
					GridPane.setColumnIndex(imageK, 0);
					GridPane.setRowIndex(imageK, 0);
					pointsT.setText(String.valueOf(points));
					game.getKing().setLocation(new Location(7,0));
					GridPane.setColumnIndex(imageKing,7);
					GridPane.setRowIndex(imageKing,0);
					KingValidMoves=game.getKing().validMovesForKing(game.getKing());
					flag1=0;
					flag2=0;
					flag3=0;
					totalSec=60;
					speed=5;
					imageKing.setVisible(true);
					imageQ.setVisible(false);
					
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
					node1Q.setStyle("-fx-background-color: green; ");
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

					Forget1 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(Forget1 == nodeRandomJump1 || Forget1 == nodeRandomJump2 || Forget1==node1Q ||Forget1==node2Q || Forget1==node3Q) {
						Forget1 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}		
					Forget1.setStyle("-fx-background-color: lightblue; ");
					Forget2 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(Forget1==Forget2 || Forget2==node1Q ||Forget2==node2Q || Forget2==node3Q || Forget2 == nodeRandomJump1 || Forget2 == nodeRandomJump2) {
						Forget2 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					Forget2.setStyle("-fx-background-color: orange; ");
					
					
					levelsMoves();
					displayLevel("LEVEL 3");
					setTimer(timer3);
					
				}
				if(points>=0 && finish==3) {
					Location locFirst = new Location(0,0);
					game.getKnight().setLocation(locFirst);
					for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
						board.getChildren().get(node).setStyle("-fx-background-color: defult;");
						board.getChildren().get(node).setStyle("-fx-border-color : black;");
					}
					for(int i = 0 ; i < 8 ; i++) {
						for(int j = 0 ; j < 8 ; j ++) {
							boardGame.getSquares()[i][j].setVisited(false);
							boardGame.getSquares()[i][j].setNumVisits(0);
						}		
					}
					fillNotVisitedArray(notVisited);
					
					points=0;
					flag1=0;
					flag2=0;
					flag3=0;
					totalSec=60;
					speed=5;
					
					b00.setStyle("-fx-background-color: grey;-fx-border-color : black;");
					boardGame.getSquares()[0][0].setVisited(true);
					points++;
					notVisited.remove(boardGame.getSquares()[0][0]);
					GridPane.setColumnIndex(imageK, 0);
					GridPane.setRowIndex(imageK, 0);
					pointsT.setText(String.valueOf(points));
					game.getKing().setLocation(new Location(7,0));
					GridPane.setColumnIndex(imageKing,7);
					GridPane.setRowIndex(imageKing,0);
					KingValidMoves=game.getKing().validMovesForKing(game.getKing());
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
					node1Q.setStyle("-fx-background-color: green; ");
					
					block1 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					block1.setStyle("-fx-background-color: darkred; ");
					block2 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(block1==block2 || block2 == node1Q  ||block2 == node2Q ||block2 == node3Q ) {
						block2 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					block2.setStyle("-fx-background-color: darkred; ");
					block3 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(block3==block2  || block3 == block1 || block3 == node1Q  ||block3 == node2Q ||block3 == node3Q) {
						block3 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					block3.setStyle("-fx-background-color: darkred; ");
					block4 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(block4==block1 || block4==block2 || block4==block3 || block4 == node1Q  ||block4 == node2Q ||block4 == node3Q) {
						block4 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					block4.setStyle("-fx-background-color: darkred; ");
					block5 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(block4==block5 || block5==block2 || block5==block3 || block5==block1 ||block5 == node1Q  ||block5 == node2Q ||block5 == node3Q) {
						block5 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					block5.setStyle("-fx-background-color: darkred; ");
					block6 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(block6==block5 || block6==block2 || block6==block3 || block6==block1 || block6==block4 ||block6 == node1Q  ||block6 == node2Q ||block6 == node3Q) {
						block6 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					block6.setStyle("-fx-background-color: darkred; ");
					block7 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(block7==block5|| block7==block6 || block7==block4 || block7==block2 || block7==block3 || block7==block1 || block7 == node1Q  ||block7 == node2Q ||block7 == node3Q) {
						block7 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					block7.setStyle("-fx-background-color: darkred; ");
					block8 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(block8==block7|| block8==block6  || block5==block8|| block8==block4 || block8==block3|| block8==block2 || block8==block1 || block8 == node1Q  ||block8 == node2Q ||block8 == node3Q) {
						block8 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					block8.setStyle("-fx-background-color: darkred; ");
					levelsMoves();
					displayLevel("LEVEL 4");
					setTimer(timer4);
				}
				if(points>=0 && finish==4) {
					//gamestatusWon(last);
				}
			}
		}