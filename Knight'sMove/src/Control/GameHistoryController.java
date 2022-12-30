package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Game;
import model.Player;
import model.SysData;

import java.util.ArrayList;
import java.util.Date;
public class GameHistoryController implements Initializable{
	@FXML 
    private TableView Table;
	
    //Player player = new Player("Klara");
   
    TableColumn<Game, Date> Date;
    TableColumn<Game, Player> NickName;
    TableColumn<Game, Integer> Points;
    TableColumn<Game, Integer> Status; //still don't have the status because we don't finish the game
    ArrayList<Game> playerGames = new ArrayList<Game>();  
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
      
     //method that fill out the table with user game history details
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(SysData.getInstance().getPlayers().get(0).getGamesHistory());
		for(int i=0; i < SysData.getInstance().getPlayers().size();i++) {
			
			if(SysData.getInstance().getPlayers().get(i).getNickname().equals(UserNameForGameHistoryController.Name)) {
				System.out.println("ghjk");
				playerGames=SysData.getInstance().getPlayers().get(i).getGamesHistory();
				System.out.println(SysData.getInstance().getPlayers().get(i).getGamesHistory());
			}
		}
		
		NickName=new TableColumn<>("     Player     ");
		Date=new TableColumn<>("             Date           ");
		Points =new TableColumn<>("         Points            "); 

		Status = new TableColumn<>("         Status            ");
		Table.getColumns().addAll(NickName,Date,Points,Status);
		// fill specific user details
		// this details are just for giving example we will fill the table in true data in the last iteration 
	    ObservableList<Game> observQues = FXCollections.observableArrayList(playerGames);
	    
		NickName.setCellValueFactory(new PropertyValueFactory<>("player"));
		Date.setCellValueFactory(new PropertyValueFactory<>("date"));
		Points.setCellValueFactory(new PropertyValueFactory<>("Points"));
		Status.setCellValueFactory(new PropertyValueFactory<>("gameStatus"));
		Table.setItems(observQues);		
	}

}
