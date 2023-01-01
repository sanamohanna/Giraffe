package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import View.MainScreen;
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
	int check=0;
	int kingMoveLevel4 = 0;
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
	Board boardGame = new Board();;
	int flagtest=0;
	int k = 0 , n = 0 ;
	int flag1 = 0  , flag2 = 0 , flag3 = 0;
	Node Forget1 ,Forget2 , Forget3;
	Node node1Q,node2Q ,node3Q;
	Node nodeRandomJump1,nodeRandomJump2 ,nodeRandomJump3;
	Node block1, block2, block3, block4, block5, block6, block7, block8;
	ArrayList<Squares> notVisited = new ArrayList<Squares>();
	Location locKing = new Location();
	Timer timer1 =new Timer();
	Timer timer2 =new Timer();
	Timer timer3 =new Timer();
	Timer timer4 =new Timer();
	Location locKnight = new Location(0,0) ;
	ArrayList<Location> KingValidMoves = new ArrayList<Location>();
	
	double smallestDistance = 11 ;
	
	
	/**
	 * 
	 * function that start the game in Level 1, put every piece in his place
	 * for every move count the points and remove the visited square from the array of not visited squares
	 * creating random three squares for the questions.
	 * for every square that the player want's to visit, pop an alert of not available move
	 * 
	 * **/
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
	
	/**
	 * 
	 * a function that check the game status of lose 
	 *it will be open the lose screen with the lose status and the level and points
	 * 
	 * **/
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
	public void gamestatusLose1() throws Exception {

		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/View/gameStatus.fxml"));
		Parent root = loader.load();
		gameStatusController status = loader.getController();
		//send the username to start game controller to display
		status.displayLevel(level.getText());
		//int total = game.getPoints()+points;
		status.displayPoints(game.getPoints());

		Stage stage = MainScreen.stage;
		//Stage stage = new Stage();
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("/View/StartGame.css").toExternalForm());
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		}
	
	/**
	 * 
	 * a function that check the game status of lose 
	 * it will be open the lose screen with the lose status and the level and points
	 * 
	 * **/
//	public void gamestatuswon() throws Exception {
//
//		FXMLLoader loader =  new FXMLLoader(getClass().getResource("/View/gameStatus.fxml"));
//		Parent root = loader.load();
//		gameStatusController status = loader.getController();
//		//send the username to start game controller to display
//		status.displayLevel("YOU WON");
//		//int total = game.getPoints()+points;
//		status.displayPoints(game.getPoints());
//		Stage stage = Stage)((Node)event.getSource()).getScene().getWindow();
//		//Stage stage = new Stage();
//		Scene scene = new Scene(root);
//		root.setStyle("-fx-background-color: green; ");
//		//scene.getStylesheets().add(getClass().getResource("/View/StartGame.css").toExternalForm());
//		stage.setResizable(false);
//		stage.setScene(scene);
//		stage.show();
//	}
	
	/**
	 * 
	 * method for the movement of the king
	 * 
	 * **/
	public void kingMoveLevel3(long totalSec){
		knightLoc=locKnight;
		smallestDistance=11;
		if(totalSec%speed == 0) {
			for(int k =0;k<KingValidMoves.size();k++) {
				//check if the shortest distance between the king and knight is small than the smallest distance
				if(game.getKing().shortestDistance(knightLoc, KingValidMoves.get(k)) < smallestDistance ) {
					smallestDistance=game.getKing().shortestDistance(knightLoc, KingValidMoves.get(k));
					locKing = KingValidMoves.get(k);
				}
			}
			//move the king to the smallest distance
			game.getKing().setLocation(locKing);
			//change the array of the valid moves to new array with the valid moves to the new place
			KingValidMoves=game.getKing().validMovesForKing(game.getKing());
			GridPane.setColumnIndex(imageKing,locKing.getX());
			GridPane.setRowIndex(imageKing,locKing.getY());
//			if(game.getKing().getLocation().equals(game.getKnight().getLocation())) {
//				timer3.cancel();
//				try {
//					gamestatusLose1();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}
		if(game.getKing().getLocation().equals(game.getKnight().getLocation())) {
			check=1;
		}
		// let the king move accelerate
		if(totalSec%10==0) {
			if(speed!=1)
			speed--;
		}
	}
	/**
	 * 
	 * method for the movement of the king
	 * 
	 * **/
	Location toRemove1 = new Location();
	Location toRemove2 = new Location();
	public void kingMoveLevel4(long totalSec){
		kingMoveLevel4 = 0;
		knightLoc=locKnight;
		smallestDistance=11;
		//change the array of the valid moves to new array with the valid moves to the new place
		KingValidMoves=game.getKing().validMovesForKing(game.getKing());
		KingValidMoves.remove(toRemove2);
		if(totalSec%speed == 0) {
			while(kingMoveLevel4==0) {
				smallestDistance=11;
				//KingValidMoves.remove(toRemove2);
				for(int k =0;k<KingValidMoves.size();k++) {
					
					//check if the shortest distance between the king and knight is small than the smallest distance
					if(game.getKing().shortestDistance(knightLoc, KingValidMoves.get(k)) < smallestDistance ) {
						smallestDistance=game.getKing().shortestDistance(knightLoc, KingValidMoves.get(k));
						locKing = KingValidMoves.get(k);
					}
				}
				//Squares kingLoc =boardGame.getSquares()[locKing.getY()][locKing.getX()];
				if(locKing.getX()!=GridPane.getColumnIndex(block1) && locKing.getY()!=GridPane.getRowIndex(block1) 
					&& locKing.getX()!=GridPane.getColumnIndex(block2) && locKing.getY()!=GridPane.getRowIndex(block2)
					&& locKing.getX()!=GridPane.getColumnIndex(block3) && locKing.getY()!=GridPane.getRowIndex(block3)
					&& locKing.getX()!=GridPane.getColumnIndex(block4) && locKing.getY()!=GridPane.getRowIndex(block4)
					&& locKing.getX()!=GridPane.getColumnIndex(block5) && locKing.getY()!=GridPane.getRowIndex(block5)
					&& locKing.getX()!=GridPane.getColumnIndex(block6) && locKing.getY()!=GridPane.getRowIndex(block6)
					&& locKing.getX()!=GridPane.getColumnIndex(block7) && locKing.getY()!=GridPane.getRowIndex(block7)
					&& locKing.getX()!=GridPane.getColumnIndex(block8) && locKing.getY()!=GridPane.getRowIndex(block8)) {
					//move the king to the smallest distance
					game.getKing().setLocation(locKing);
					GridPane.setColumnIndex(imageKing,locKing.getX());
					GridPane.setRowIndex(imageKing,locKing.getY());
					kingMoveLevel4=1;
						
				}
				else {
					System.out.println("2");
					KingValidMoves.remove(locKing);
					System.out.println();
				}
				
			}
			
			if(game.getKing().getLocation().equals(game.getKnight().getLocation())) {
				check=1;
			}
		}
		// let the king move accelerate
		if(totalSec%10==0) {
			if(speed!=1)
			speed--;
		}
	}
		// method that start timer in one minute to every level in the game 
		public void setTimer(Timer timer){
				TimerTask timerTask = new TimerTask() {
					@Override
					public void run(){					
							convertTime();
							if(finish == 2 ) {
								kingMoveLevel3(totalSec);	
							}
							if(finish == 3) {
								kingMoveLevel3(totalSec);
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
		//display level in status screen
		public void displayLevel(String level1) {
			level.setText(level1);
		}
		// display points in status screan
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
		
		
		/**
		 * 
		 * method for the game
		 * 
		 * **/
		@Override
		public void handle(ActionEvent arg0) {
			//save the valid moves of the knight in array list for each level
			ArrayList<Location> validsMovesLevel1 =new ArrayList<Location>();
			validsMovesLevel1 = game.getKnight().allValidMovesLevel1(game.getKnight());
			ArrayList<Location> validsMovesLevel2 =new ArrayList<Location>();
			validsMovesLevel2 = game.getKnight().allValidMovesLevel2(game.getKnight());
			ArrayList<Location>  validsMovesLevel3 = new ArrayList<Location>();
			validsMovesLevel3 = game.getKnight().allValidMovesLevel2(game.getKnight());
			ArrayList<Location>  validsMovesLevel4 = new ArrayList<Location>();
			validsMovesLevel4 = game.getKnight().allValidMovesLevel2(game.getKnight());
			Location locQueen = new Location();// create location for queen
			double smallestDistance = 11;
			//loop on the board
			for(int i = 0 ; i < 8 ; i++) {
				for(int j = 0 ; j < 8 ; j ++) {
					if(finish==0) { // level 1
						//check if the square that the knight chose to move is equal to the square b[i][j]
						if(((Button)arg0.getSource()).getId().toString().equals("b"+""+i +""+j) ) {
							Location loc = new Location(j,i); // create location and save it's place on square b[j][i]
							//check if the valid moves for level 1 contain the location that the player chose
							if(validsMovesLevel1.contains(loc) ) {
								//set the knight on the board
								game.getKnight().setLocation(loc);
								GridPane.setColumnIndex(imageK,j);
								GridPane.setRowIndex(imageK,i );
								//check if the square that the knight moved on is an easy question square
								if(arg0.getSource()==node1Q && flag1==0) {
									try {
										popEasy(); //show easy question
									} catch (IOException e) {
										e.printStackTrace();
									}
									game.setPoints(points); //add question's points if the player answer is true
									flag1++;
								}
								//check if the square that the knight moved on is a medium question square
								 if(arg0.getSource()==node2Q && flag2==0) {
									flag2++;
									try {
										popMediocre();//show medium question
									} catch (IOException e) {
										e.printStackTrace();
									}
									game.setPoints(points);//add question's points if the player answer is tru
								 }
								//check if the square that the knight moved on is a hard question square
								 if(arg0.getSource()==node3Q && flag3==0) {
										flag3++;
										try {
											popHard();//show hard question 
										} catch (IOException e) {
											e.printStackTrace();
										}
										game.setPoints(points);//add question's points if the player answer is tru
								}
								//check if the square that the knight is moved on isn't a random jump square
								if(!arg0.getSource().equals(nodeRandomJump1)&&!arg0.getSource().equals(nodeRandomJump2)&&!arg0.getSource().equals(nodeRandomJump3)) {
									//creating array for queen valid moves and add all the squares that the queen can move to
									ArrayList<Location> QueenValidMoves = new ArrayList<Location>();
									QueenValidMoves = game.getQueen().validMovesForQueen(game.getQueen());
									
									for(int k =0;k<QueenValidMoves.size();k++) {
										//check if the shortest distance between the queen and knight is small than the smallest distance
										if(game.getQueen().shortestDistance(game.getKnight().getLocation(), QueenValidMoves.get(k))<smallestDistance) {
											smallestDistance=game.getQueen().shortestDistance(game.getKnight().getLocation(), QueenValidMoves.get(k));
											locQueen = QueenValidMoves.get(k);
										}
									}
									//move the queen to the square that have the shortest distance between the queen and the knight
									game.getQueen().setLocation(locQueen);
									GridPane.setColumnIndex(imageQ,locQueen.getX());
									GridPane.setRowIndex(imageQ,locQueen.getY());
									//check if the square that the queen moved to is the square that the knight is on it
									if(game.getQueen().getLocation().equals(game.getKnight().getLocation())) {
										
										for(int player = 0 ; player<SysData.getInstance().getPlayers().size();player++) {
											//check if the player is in the sysData
											if(SysData.getInstance().getPlayers().get(player).getNickname().equals(UserNameController.Name) ){
												game.setPlayer(SysData.getInstance().getPlayers().get(player));
												SysData.getInstance().getPlayers().get(player).getGamesHistory().add(game);//add the game to the games history for the player
											}
										}
										timer1.cancel();//stop the timer
										try {
											gamestatusLose(arg0); //show game status lose screen
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								}else { //check if the square that the player chose is a random jump square
									if(arg0.getSource()==nodeRandomJump1 || arg0.getSource()==nodeRandomJump2 ||arg0.getSource()==nodeRandomJump3) {
										//square that  will knight jump in the random jump from the squares that isn't visited
										Squares sq= notVisited.get(rand.nextInt(notVisited.size())); 
										Location loc0 = new Location(sq.getLocation().getX(),sq.getLocation().getY());// save location
										game.getKnight().setLocation(loc0); //let the knight jump on the square
										GridPane.setColumnIndex(imageK,sq.getLocation().getX());
										GridPane.setRowIndex(imageK,sq.getLocation().getY() );
										//create new valid moves to the queen 
										ArrayList<Location> QueenValidMoves = new ArrayList<Location>();
										QueenValidMoves = game.getQueen().validMovesForQueen(game.getQueen());
										for(int k =0;k<QueenValidMoves.size();k++) {
											//check if the shortest distance between the queen and knight is small than the smallest distance
											if(game.getQueen().shortestDistance(game.getKnight().getLocation(), QueenValidMoves.get(k))<smallestDistance) {
												smallestDistance=game.getQueen().shortestDistance(game.getKnight().getLocation(), QueenValidMoves.get(k));
												locQueen = QueenValidMoves.get(k);
											}
										}
										//move the queen to the shortest distance
										game.getQueen().setLocation(locQueen);
										GridPane.setColumnIndex(imageQ,locQueen.getX());
										GridPane.setRowIndex(imageQ,locQueen.getY());
										//check if the square that the queen moved to is the square that the knight is on it
										if(game.getQueen().getLocation().equals(game.getKnight().getLocation())) {
											timer1.cancel(); //stop the timer
											for(int player = 0 ; player<SysData.getInstance().getPlayers().size();player++) {
												//check if the player is on the sysData
												if(SysData.getInstance().getPlayers().get(player).getNickname().equals(UserNameController.Name)) {
													game.setPlayer(SysData.getInstance().getPlayers().get(player));
													System.out.println(game);
													SysData.getInstance().getPlayers().get(player).getGamesHistory().add(game);//add the game to the game history
													//System.out.println(SysData.getInstance().getPlayers().get(player).getGamesHistory());
												}
											}
											try {
												gamestatusLose(arg0); //show game status lose screen
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
										//check if the square that the knight moved on is a easy question square
										if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node1Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node1Q)) {
											try {
												popEasy();//show easy question
												flag1++;
											} catch (IOException e) {
												e.printStackTrace();
											}
										}//check if the square that the knight moved on is a medium question square
										else if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node2Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node2Q) ) {
											try {										
												popMediocre();//show medium question
												flag2++;
											} catch (IOException e) {
												e.printStackTrace();
											}
										}//check if the square that the knight moved on is a hard question square
										else if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node3Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node3Q)) {
											try {									
												popHard();//show hard question
												flag3++;
											} catch (IOException e) {
											
												e.printStackTrace();
											}
										}
										//set the square as a visited square
										boardGame.getSquares()[sq.getLocation().getY()][sq.getLocation().getX()].setVisited(true);
										//remove the square from the not visited squares array list
										notVisited.remove(boardGame.getSquares()[sq.getLocation().getY()][sq.getLocation().getX()]);
										//change the color of the visited square
										((Button)arg0.getSource()).setStyle("-fx-background-color: grey;-fx-border-color : black;");
										String str = "b"+sq.getLocation().getY()+sq.getLocation().getX();
										for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
											if(board.getChildren().get(node).getId().toString().equals(str)) {
												((Button)board.getChildren().get(node)).setStyle("-fx-background-color: grey;-fx-border-color : black;");
											}
										}
										
										
										
									}
									
								}
								//check if the player chose to move on a square that is visited
								if(boardGame.getSquares()[i][j].isVisited() == true) {
									points--;//lose point
									game.setPoints(points);//set the points
									//count the number of visits for the square
									boardGame.getSquares()[i][j].setNumVisits(boardGame.getSquares()[i][j].getNumVisits()+1);//set the number of visits for this square
								}else { //if the square is not visited
									points++;//win point
									game.setPoints(points);//set points
									//count the number of visits for the square
									boardGame.getSquares()[i][j].setNumVisits(boardGame.getSquares()[i][j].getNumVisits()+1);//set the number of visits for this square
									boardGame.getSquares()[i][j].setVisited(true);//change the square to visited
									notVisited.remove(boardGame.getSquares()[i][j]);//remove the square from not visited squares array
									((Button)arg0.getSource()).setStyle("-fx-background-color: grey;-fx-border-color : black;"); //change the color of the square
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
					else if(finish == 1) //level 2
						{
						//check if the square that the knight chose to move is equal to the square b[i][j]
							if(((Button)arg0.getSource()).getId().toString().equals("b"+""+i +""+j) ) {
								Location loc = new Location(j,i); //create a location and save it on b[j][i] place
								//check if the valid moves for level 2 contain the location that the player chose
								if(validsMovesLevel2.contains(loc) ) {
									//put the knight in the location that the player chose
									game.getKnight().setLocation(loc);
									GridPane.setColumnIndex(imageK,j);
									GridPane.setRowIndex(imageK,i );
									//check if the square that the knight moved on is an easy question square
									if(arg0.getSource()==node1Q && flag1==0) {
										try {
											popEasy();//show easy question
										} catch (IOException e) {
											e.printStackTrace();
										}
										flag1++;
									}//check if the square that the knight moved on is a medium  question square
									 if(arg0.getSource()==node2Q && flag2==0) {
										flag2++;
										try {
											popMediocre();// show medium question
										} catch (IOException e) {
											
											e.printStackTrace();
										}
									 }//check if the square that the knight moved on is a hard question square
									 if(arg0.getSource()==node3Q && flag3==0) {
											flag3++;
											try {
												popHard();//show hard question
											} catch (IOException e) {
												
												e.printStackTrace();
											}
									 }
									//check if the player chose to move on a square that is visited
									 if(boardGame.getSquares()[i][j].isVisited() == true) {
											points--;//lose point
											//count and set the number of visits for the square
											int visitsTime =boardGame.getSquares()[i][j].getNumVisits();
											boardGame.getSquares()[i][j].setNumVisits(visitsTime+1);
										}else {//if the player chose to move on a square that is not visited
											points++; //win point
											//count the number of visits for the square
											int visitsTime =boardGame.getSquares()[i][j].getNumVisits();
											boardGame.getSquares()[i][j].setNumVisits(visitsTime+1);//set visits number
											boardGame.getSquares()[i][j].setVisited(true);//set the square as a visited
											notVisited.remove(boardGame.getSquares()[i][j]); //remove the square from the not visited squares array
											((Button)arg0.getSource()).setStyle("-fx-background-color: grey;-fx-border-color : black;");//change the color of the visited square
										}
									 //check if the array of the forget square is not contain the first place in the game
									if(!forgetsSquares.contains(boardGame.getSquares()[0][0]) && flagtest==0) {
										forgetsSquares.add(boardGame.getSquares()[0][0]); //add the first place to the forgets squares array
										int visitsTime =boardGame.getSquares()[0][0].getNumVisits(); //save the visits number of the first place
										boardGame.getSquares()[0][0].setNumVisits(visitsTime+1);//set the number of visited for the first place
										flagtest++;
										
									}
									//create array and saves the queen valid moves
									ArrayList<Location> QueenValidMoves = new ArrayList<Location>();
									QueenValidMoves = game.getQueen().validMovesForQueen(game.getQueen());
		
									for(int k =0;k<QueenValidMoves.size();k++) {
										//check if the shortest distance between the queen and knight is small than the smallest distance
										if(game.getQueen().shortestDistance(game.getKnight().getLocation(), QueenValidMoves.get(k))<smallestDistance) {
											smallestDistance=game.getQueen().shortestDistance(game.getKnight().getLocation(), QueenValidMoves.get(k));
											locQueen = QueenValidMoves.get(k);
										}
									}
									//move the queen to the shortest distance
									game.getQueen().setLocation(locQueen);
									GridPane.setColumnIndex(imageQ,locQueen.getX());
									GridPane.setRowIndex(imageQ,locQueen.getY());
									//check if the square that the queen moved to is the square that the knight is on it
									if(game.getQueen().getLocation().equals(game.getKnight().getLocation())) {
										timer2.cancel(); //stop timer
										int total = game.getPoints()+points;//save the level point in the total points score
										game.setPoints(total);// save the score of level 1 and 2
										for(int player = 0 ; player<SysData.getInstance().getPlayers().size();player++) {
											//check if the player is on the sysData
											if(SysData.getInstance().getPlayers().get(player).getNickname().equals(UserNameController.Name)) {
												game.setPlayer(SysData.getInstance().getPlayers().get(player));
												Game gamex = new Game();
												gamex=game;
												SysData.getInstance().getPlayers().get(player).getGamesHistory().add(gamex); //add the game to the games history
												System.out.println(SysData.getInstance().getPlayers().get(player).getGamesHistory());
											}
										}
										try {
											gamestatusLose(arg0); //show game status lose screen
										} catch (Exception e) {
											e.printStackTrace();
										}

									}
									//check if the square that the square that the player chose to move is a forget square
									if(arg0.getSource().equals(Forget1) || arg0.getSource().equals(Forget2) || arg0.getSource().equals(Forget3) ) {
										//check if the array of the forget squares array contain squares, not 0
										if(forgetsSquares.size()!=0) {
											System.out.println(forgetsSquares.size());
											//check if the forget squares array is contain one square, first square
											if(forgetsSquares.size()==1) {
												//check if the number of visit is 1, the player visit the square once
												if(forgetsSquares.get(0).getNumVisits()==1) {
													//set the square as not visited square
													boardGame.getSquares()[forgetsSquares.get(0).getLocation().getY()][forgetsSquares.get(0).getLocation().getX()].setVisited(false);
													String str = "b"+forgetsSquares.get(0).getLocation().getY()+forgetsSquares.get(0).getLocation().getX();
													//loop on the board squares
													for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
														//check if the square is equal to the square on board 
														if(board.getChildren().get(node).getId().toString().equals(str)) {
															//change the color of the square 
															board.getChildren().get(node).setStyle("-fx-background-color: defult;");
															board.getChildren().get(node).setStyle("-fx-border-color : black;");
														}
													}
													notVisited.add(forgetsSquares.get(0)); //add the first square to the squares array that is not visited
													forgetsSquares.get(0).setNumVisits(0);// set the number of the visited to 0
													points--;//lose the point that the player win
													forgetsSquares.remove(0); //remove the square from the forget squares array
												}
												else { // if the player visit the square more than one time
													points++; // win point that he lose
													int numVisits=forgetsSquares.get(0).getNumVisits();//save the number of visit for the square
													forgetsSquares.get(0).setNumVisits(numVisits-1);// Change the number of visit of the square to less one
													forgetsSquares.remove(0);//remove the square from the forget squares array
												}
											}
											else if(forgetsSquares.size()==2) {//check if the forget squares array is contain two square
												//loop in the forget squares array from the last square in the array to the first square
												for(int square = forgetsSquares.size()-1 ;square>forgetsSquares.size()-3;square-- ) {
													//check if the number of visit is 1, the player visit the square once
													if(forgetsSquares.get(square).getNumVisits()==1) {
														//set the square as not visited square
														boardGame.getSquares()[forgetsSquares.get(square).getLocation().getY()][forgetsSquares.get(square).getLocation().getX()].setVisited(false);
														forgetsSquares.get(square).setNumVisits(0); //set the number of visit to 0
														String str = "b"+forgetsSquares.get(square).getLocation().getY()+forgetsSquares.get(square).getLocation().getX();
														//loop on the board squares
														for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
															//check if the square is equal to the square on board
															if(board.getChildren().get(node).getId().toString().equals(str)) {
																//change the color of the square
																board.getChildren().get(node).setStyle("-fx-background-color: defult;");
																board.getChildren().get(node).setStyle("-fx-border-color : black;");
															}
														}
														notVisited.add(forgetsSquares.get(square));//add the square to the not visited squares array
														points--; //lose the point that the player win from this square
														
													}
													else {// if the player visit the square more than one time
														points++; // win the point that he lose
														int numVisits=forgetsSquares.get(square).getNumVisits();//save the number of visit for the square
														forgetsSquares.get(square).setNumVisits(numVisits-1);// Change the number of visit of the square to less one
													}
												}
												//remove the squares from the forget squares array
												forgetsSquares.remove(forgetsSquares.size()-1);
												forgetsSquares.remove(forgetsSquares.size()-1);

											}
											else
												if(forgetsSquares.size()>=3) { //check if the forget squares array is contain three square or more
													//loop in the forget squares array from the last square in the array to the third last square	
												for(int square = forgetsSquares.size()-1 ;square>forgetsSquares.size()-4;square-- ) {
													//check if the number of visit is 1, the player visit the square once
													if(forgetsSquares.get(square).getNumVisits()==1) {
														//set the square as not visited square
														boardGame.getSquares()[forgetsSquares.get(square).getLocation().getY()][forgetsSquares.get(square).getLocation().getX()].setVisited(false);
														forgetsSquares.get(square).setNumVisits(0);//set the number of visited to 0
														String str = "b"+forgetsSquares.get(square).getLocation().getY()+forgetsSquares.get(square).getLocation().getX();
														//loop on the board squares
														for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
															//check if the square is equal to the square on board
															if(board.getChildren().get(node).getId().toString().equals(str)) {
																//change the color of the squares
																board.getChildren().get(node).setStyle("-fx-background-color: defult;");
																board.getChildren().get(node).setStyle("-fx-border-color : black;");
															}
														}
														notVisited.add(forgetsSquares.get(square)); //add the square to the not visited squares array
														points--; //lost the point that the player win from the square
														
													}
													else {// if the player visit the square more than one time
														points++;//win the point that he lose
														
														int numVisits=forgetsSquares.get(square).getNumVisits();//save the number of visit for the square
														forgetsSquares.get(square).setNumVisits(numVisits-1);// Change the number of visit of the square to less one
													}
												}
												//remove the last three squares from the forget squares array
												forgetsSquares.remove(forgetsSquares.size()-1);
												forgetsSquares.remove(forgetsSquares.size()-1);
												forgetsSquares.remove(forgetsSquares.size()-1);
												
											}
										}
									}
									//check if the forget squares array not contain the square
									if(!forgetsSquares.contains(boardGame.getSquares()[i][j])) {
										forgetsSquares.add(boardGame.getSquares()[i][j]); //add the square to the forget squares array
										
									}
									
									
									
									
								}
								else {
									a.setAlertType(AlertType.ERROR);//if the player chose square not valid to move on  
									a.setContentText("invalid move try again");
									a.show();	
								}
								
								
							}
						}
					else if(finish == 2) //level 3
					{
						//check if the square that the knight chose to move is equal to the square b[i][j]
						if(((Button)arg0.getSource()).getId().toString().equals("b"+""+i +""+j) ) {
							Location loc = new Location(j,i); //create a location and save it on b[j][i] place
							//check if the valid moves for level 3 contain the location that the player chose
							if(validsMovesLevel3.contains(loc) ) {
								//put the knight on the location that the player chose
								game.getKnight().setLocation(loc);
								GridPane.setColumnIndex(imageK,j);
								GridPane.setRowIndex(imageK,i );
								//check if the king and the knight is on the same square
								if(check==1) {
									timer3.cancel(); //stop timer
									check=0; //set the check 0 - as not on the same square
									int total = game.getPoints()+points; //add the point of the level to the points score
									game.setPoints(total); //set the points score
									//loop on the players of the sysData
									for(int player = 0 ; player<SysData.getInstance().getPlayers().size();player++) {
										//check if the player is on the sysData
										if(SysData.getInstance().getPlayers().get(player).getNickname().equals(UserNameController.Name)) {
											game.setPlayer(SysData.getInstance().getPlayers().get(player)); 
											Game gamex = new Game();
											gamex=game;
											SysData.getInstance().getPlayers().get(player).getGamesHistory().add(gamex);//add the game to the games history
										}
									}
									try {
										gamestatusLose(arg0); // show game status lose screen
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								//check if the square that the knight moved on is a easy question square
								if(arg0.getSource()==node1Q && flag1==0) {
									try {
										popEasy(); //show easy question
									} catch (IOException e) {
										e.printStackTrace();
									}
									flag1++;
									
								}//check if the square that the knight moved on is a medium question square
								 if(arg0.getSource()==node2Q && flag2==0) {
									flag2++;
									try {
										popMediocre(); //show medium question
									} catch (IOException e) {
										e.printStackTrace();
									}
								 }//check if the square that the knight moved on is a hard question square
								 if(arg0.getSource()==node3Q && flag3==0) {
										flag3++;
										try {
											popHard();//show hard question
										} catch (IOException e) {
											
											e.printStackTrace();
										}
										
								 }
								locKnight =loc; //put the knight in the location that the player chose
								 //check if the array of the forget square is not contain the first place in the game
								if(!forgetsSquares.contains(boardGame.getSquares()[0][0]) && flagtest==0) {
									forgetsSquares.add(boardGame.getSquares()[0][0]);//add the first place to the forgets squares array
									int visitsTime =boardGame.getSquares()[0][0].getNumVisits();//save the visits number of the first place
									boardGame.getSquares()[0][0].setNumVisits(visitsTime+1);//set the number of visited for the first place, add 1 to the number 
									flagtest++;
									
								}
								//check if the square that the player chose is visited square
								if(boardGame.getSquares()[i][j].isVisited() == true) {
									points--;//lose one point 
									//set number of visits, add one to the number
									int visitsTime =boardGame.getSquares()[i][j].getNumVisits();
									boardGame.getSquares()[i][j].setNumVisits(visitsTime+1);
								}else {//if the square that the player chose is not visited square
									points++; //add one point
									//set number of visits, add one to the number
									int visitsTime =boardGame.getSquares()[i][j].getNumVisits();
									boardGame.getSquares()[i][j].setNumVisits(visitsTime+1);
									boardGame.getSquares()[i][j].setVisited(true); //sat the square as a visited square
									notVisited.remove(boardGame.getSquares()[i][j]);//remove the square from the not visited squares array
									((Button)arg0.getSource()).setStyle("-fx-background-color: grey;-fx-border-color : black;"); //change the color of the square
								}
								//check if the square that the player chose is a random jump square
								if(arg0.getSource()==nodeRandomJump1 ||arg0.getSource()==nodeRandomJump2) {
									//square that  will knight jump in the random jump from the squares that isn't visited
									Squares sq= notVisited.get(rand.nextInt(notVisited.size()));
									Location loc2 = new Location(sq.getLocation().getX(),sq.getLocation().getY());//save the location 
									game.getKnight().setLocation(loc2);//let the knight jump to the location
									GridPane.setColumnIndex(imageK,sq.getLocation().getX());
									GridPane.setRowIndex(imageK,sq.getLocation().getY() );
									//check if the square that the knight moved on is a easy  question square
									if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node1Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node1Q)) {
										try {
											popEasy();//show easy question
											flag1++;
										} catch (IOException e) {
											
											e.printStackTrace();
										}
										
									}///check if the square that the knight moved on is a medium  question square
									else if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node2Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node2Q) ) {
										try {												
											popMediocre();//show medium question
											flag2++;
										} catch (IOException e) {
											
											e.printStackTrace();
										}
									
									} //check if the square that the knight moved on is a hard  question square
									else if(GridPane.getColumnIndex(imageK)==GridPane.getColumnIndex(node3Q) &&GridPane.getRowIndex(imageK)==GridPane.getRowIndex(node3Q)) {
										try {									
											popHard();//show hard question
											flag3++;
										} catch (IOException e) {
											
											e.printStackTrace();
										}
										
									}
									boardGame.getSquares()[sq.getLocation().getY()][sq.getLocation().getX()].setVisited(true);//set the square as a visited square
									notVisited.remove(boardGame.getSquares()[sq.getLocation().getY()][sq.getLocation().getX()]);//remove the square from the not visited squares array
									((Button)arg0.getSource()).setStyle("-fx-background-color: grey;"); //change the color of the square
									String str = "b"+sq.getLocation().getY()+sq.getLocation().getX();
									//loop on the board squares
									for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
										//check if the board squares equal to the square that the knight move
										if(board.getChildren().get(node).getId().toString().equals(str)) {
											board.getChildren().get(node).setStyle("-fx-background-color: grey;-fx-border-color : black;");//change the color of the square
										}
									}
								}
								//check if the square that the knight is on is a forget square
								if(arg0.getSource().equals(Forget1) || arg0.getSource().equals(Forget2)) {
									// check if the length of the forget square isn't 0
									if(forgetsSquares.size()!=0) {
										//check if the length of the forget squares is 1
										if(forgetsSquares.size()==1) {
											//check if the number of visits of the first square on the forget squares array is 1
											if(forgetsSquares.get(0).getNumVisits()==1) {
												boardGame.getSquares()[forgetsSquares.get(0).getLocation().getY()][forgetsSquares.get(0).getLocation().getX()].setVisited(false);//set the square as not visited
												String str = "b"+forgetsSquares.get(0).getLocation().getY()+forgetsSquares.get(0).getLocation().getX();
												//loop on the board squares
												for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
													//check if the board square on the place b[j][i] equals to the square 
													if(board.getChildren().get(node).getId().toString().equals(str)) {
														//change the color of the square
														board.getChildren().get(node).setStyle("-fx-background-color: defult;");
														board.getChildren().get(node).setStyle("-fx-border-color : black;");
													}
												}
												notVisited.add(forgetsSquares.get(0));//add the first square to the not visited squares array
												forgetsSquares.get(0).setNumVisits(0);//set the first square number of the visits as 0
												points--; //lose the point that the player win from the square
												
												forgetsSquares.remove(0); //remove the first square from the forget squares array  
											}
											else { //if the number of visits of the first square on the forget squares array is more than 1
												points++; //add the point that the player lose from the square
												//set the number of visits, less one
												int numVisits=forgetsSquares.get(0).getNumVisits();
												forgetsSquares.get(0).setNumVisits(numVisits-1);
												forgetsSquares.remove(0);//remove the square from forget squares array
											}
										}//check if the length of the forget squares is 2
										else if(forgetsSquares.size()==2) {
											//loop on the forget squares array, from the last square 
											for(int square = forgetsSquares.size()-1 ;square>forgetsSquares.size()-3;square-- ) {
												//check if the number of visits of the first square on the forget squares array is 1
												if(forgetsSquares.get(square).getNumVisits()==1) {
													boardGame.getSquares()[forgetsSquares.get(square).getLocation().getY()][forgetsSquares.get(square).getLocation().getX()].setVisited(false);//set that the square is not visited
													forgetsSquares.get(square).setNumVisits(0); //set the number of visit as 0
													String str = "b"+forgetsSquares.get(square).getLocation().getY()+forgetsSquares.get(square).getLocation().getX();
													//loop on the board squares
													for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
														//check if the board square on the place b[j][i] equals to the square
														if(board.getChildren().get(node).getId().toString().equals(str)) {
															//change square color
															board.getChildren().get(node).setStyle("-fx-background-color: defult;");
															board.getChildren().get(node).setStyle("-fx-border-color : black;");
														}
													}
													notVisited.add(forgetsSquares.get(square));//add the square to the not visited squares array
													points--; //lose the point from the square
													
												}
												else {//if the number of visits square on the forget squares array is more than 1
													points++; //add a point from the square
													//set the number of visits, less 1
													int numVisits=forgetsSquares.get(square).getNumVisits();
													forgetsSquares.get(square).setNumVisits(numVisits-1);
												}
											}
											//remove the squares from the forget squares array
											forgetsSquares.remove(forgetsSquares.size()-1);
											forgetsSquares.remove(forgetsSquares.size()-1);	
										}
										else
											if(forgetsSquares.size()>=3) { //check if the length of the forget squares is 3 or more
											//loop on the forget squares array, from the last square 	
											for(int square = forgetsSquares.size()-1 ;square>forgetsSquares.size()-4;square-- ) {
												//check if the number of visits of the first square on the forget squares array is 1
												if(forgetsSquares.get(square).getNumVisits()==1) {
													boardGame.getSquares()[forgetsSquares.get(square).getLocation().getY()][forgetsSquares.get(square).getLocation().getX()].setVisited(false);//set the square as not visited
													forgetsSquares.get(square).setNumVisits(0);//set the number of visits as 0
													String str = "b"+forgetsSquares.get(square).getLocation().getY()+forgetsSquares.get(square).getLocation().getX();
													//loop on the board squares
													for(int node = 0 ; node < board.getChildren().size()-2 ; node++) {
														//check if the board square on the place b[j][i] equals to the square
														if(board.getChildren().get(node).getId().toString().equals(str)) {
															//set the colors of the squares
															board.getChildren().get(node).setStyle("-fx-background-color: defult;");
															board.getChildren().get(node).setStyle("-fx-border-color : black;");
														}
													}
													notVisited.add(forgetsSquares.get(square));// add the square to the not visited squares array
													points--; //lose the point from the square
													
												}
												else {//if the number of visits square on the forget squares array is more than 
													points++;//add a point from the square
													//set the number of visits, less 1
													int numVisits=forgetsSquares.get(square).getNumVisits();
													forgetsSquares.get(square).setNumVisits(numVisits-1);
												}
											}
											//remove the last three squares from the forget squares array
											forgetsSquares.remove(forgetsSquares.size()-1);
											forgetsSquares.remove(forgetsSquares.size()-1);
											forgetsSquares.remove(forgetsSquares.size()-1);
											
										}
									}
								}
								//check if the forget squares array is not contain the square that the player chose
								if(!forgetsSquares.contains(boardGame.getSquares()[i][j])) {
									forgetsSquares.add(boardGame.getSquares()[i][j]);//add the squares to the forget squares array
									
								}
								
							}
							else { 
								a.setAlertType(AlertType.ERROR);//if the player chose not valid square to move 
								a.setContentText("invalid move try again");
								a.show();	
							}
							
						}
					}
					else if(finish == 3) //level 4
					{//check if the square that the knight chose to move is equal to the square b[i][j]
						if(((Button)arg0.getSource()).getId().toString().equals("b"+""+i +""+j) ) {
							Location loc = new Location(j,i); //create new location 
							//check if level 4 valid moves contain the location
							if(validsMovesLevel4.contains(loc) ) {
								//check if the square isn't a block square
								if(arg0.getSource()!=block1 &&arg0.getSource()!=block2 &&arg0.getSource()!=block3 &&
									arg0.getSource()!=block4 &&arg0.getSource()!=block5 &&arg0.getSource()!=block6 &&
									arg0.getSource()!=block7 &&arg0.getSource()!=block8) {
									//put the knight on the location that the player chose
									game.getKnight().setLocation(loc);
									GridPane.setColumnIndex(imageK,j);
									GridPane.setRowIndex(imageK,i );
									//check if the knight and the king is on the same square
									if(check==1) {
										timer4.cancel(); //stop timer
										check=0;//put the check 0 - as the knight and the king isn't on the same place
										int total = game.getPoints()+points; //add the level points to the points score
										game.setPoints(total); //set the point score
										//loop on the players of the sysData
										for(int player = 0 ; player<SysData.getInstance().getPlayers().size();player++) {
											//check if the player is on the sysData
											if(SysData.getInstance().getPlayers().get(player).getNickname().equals(UserNameController.Name)) {
												game.setPlayer(SysData.getInstance().getPlayers().get(player));
												Game gamex = new Game();
												gamex=game;
												SysData.getInstance().getPlayers().get(player).getGamesHistory().add(gamex);//add the game to the player games history
											}
										}
										try {
											gamestatusLose(arg0);//show game status lose screen
										} catch (Exception e) {
											e.printStackTrace();
										}
									}///check if the square that the knight moved on is an easy  question square
									if(arg0.getSource()==node1Q && flag1==0) {
										try {
											popEasy();//show easy question
										} catch (IOException e) {
											e.printStackTrace();
										}
										flag1++;
										
									}///check if the square that the knight moved on is a medium  question square
									 if(arg0.getSource()==node2Q && flag2==0) {
										flag2++;
										try {
											popMediocre();//show medium question 
										} catch (IOException e) {
											e.printStackTrace();
										}
										
									 }///check if the square that the knight moved on is a hard  question square
									 if(arg0.getSource()==node3Q && flag3==0) {
											flag3++;
											try {
												popHard();//show hard question
											} catch (IOException e) {
												e.printStackTrace();
											}
											
									 }
									 locKnight =loc; //move the knight to the location
									 //check if the square is visited 
									if(boardGame.getSquares()[i][j].isVisited() == true) {
										points--; //lose one point
										//set the number of visits, add one
										int visitsTime =boardGame.getSquares()[i][j].getNumVisits();
										boardGame.getSquares()[i][j].setNumVisits(visitsTime+1);
									}else { //if the square is not visited
										points++;//add one point
										//set number of visits, add one
										int visitsTime =boardGame.getSquares()[i][j].getNumVisits();
										boardGame.getSquares()[i][j].setNumVisits(visitsTime+1);
										boardGame.getSquares()[i][j].setVisited(true);//set the square as a visited square
										notVisited.remove(boardGame.getSquares()[i][j]);//remove the square from the not visited squares array 
										((Button)arg0.getSource()).setStyle("-fx-background-color: grey;-fx-border-color : black;");//change the color of the square
									}
								}
								
							}
							else {
								a.setAlertType(AlertType.ERROR);//if the player chose a not valid square to move 
								a.setContentText("invalid move try again");
								a.show();	
							}
						}
					}
				
				}
				

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
					totalSec=5;
					
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
					int total = game.getPoints()+points;
					game.setPoints(total);
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
					if(b00.getStyle()!="-fx-background-color: grey;-fx-border-color : black;")
						b00.setStyle("-fx-background-color: grey;-fx-border-color : black;");
					points=0;
					Location locFirst = new Location(0,0);
					game.getKnight().setLocation(locFirst);
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
					totalSec=30;
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
					totalSec=6;
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
					
					while(block1==b00 || block1==b07) {
						block1 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					block1.setStyle("-fx-background-color: darkred; ");
					block2 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(block1==block2 || block2 == node1Q  ||block2 == node2Q ||block2 == node3Q || block2==b00 || block2==b07 ) {
						block2 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					block2.setStyle("-fx-background-color: darkred; ");
					block3 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(block3==block2  || block3 == block1 || block3 == node1Q  ||block3 == node2Q ||block3 == node3Q || block3==b00 || block3==b07) {
						block3 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					block3.setStyle("-fx-background-color: darkred; ");
					block4 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(block4==block1 || block4==block2 || block4==block3 || block4 == node1Q  ||block4 == node2Q ||block4 == node3Q || block4==b00 || block4==b07) {
						block4 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					block4.setStyle("-fx-background-color: darkred; ");
					block5 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(block4==block5 || block5==block2 || block5==block3 || block5==block1 ||block5 == node1Q  ||block5 == node2Q ||block5 == node3Q || block5==b00 || block5==b07) {
						block5 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					block5.setStyle("-fx-background-color: darkred; ");
					block6 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(block6==block5 || block6==block2 || block6==block3 || block6==block1 || block6==block4 ||block6 == node1Q  ||block6 == node2Q ||block6 == node3Q || block6==b00 || block6==b07) {
						block6 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					block6.setStyle("-fx-background-color: darkred; ");
					block7 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(block7==block5|| block7==block6 || block7==block4 || block7==block2 || block7==block3 || block7==block1 || block7 == node1Q  ||block7 == node2Q ||block7 == node3Q || block7==b00 || block7==b07) {
						block7 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					block7.setStyle("-fx-background-color: darkred; ");
					block8 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					while(block8==block7|| block8==block6  || block5==block8|| block8==block4 || block8==block3|| block8==block2 || block8==block1 || block8 == node1Q  ||block8 == node2Q ||block8 == node3Q || block8==b00 || block8==b07) {
						block8 = board.getChildren().get(rand.nextInt(board.getChildren().size()-3));
					}
					block8.setStyle("-fx-background-color: darkred; ");
					levelsMoves();
					displayLevel("LEVEL 4");
					setTimer(timer4);
				}
				if(points>=0 && finish==4) {
//					try {
//						gamestatuswon();
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
			}
		}