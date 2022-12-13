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
import java.util.Date;
public class GameHistoryController implements Initializable{
	@FXML 
    private TableView Table;
	
    Player player = new Player("Klara");
    Player player1 = new Player("nada");
    Player player2 = new Player("sana");
    TableColumn<Game, Date> Date;
    TableColumn<Game, Player> NickName;
    TableColumn<Game, Integer> Points;
    
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
		NickName=new TableColumn<>("     Player     ");
		Date=new TableColumn<>("             Date           ");
		Points =new TableColumn<>("         Points            "); 
		Table.getColumns().addAll(NickName,Date,Points);
		// fill specific user details
	    ObservableList<Game> observQues = FXCollections.observableArrayList(new Game(player,150 ) , new Game(player1 , 100) , new Game(player2,200));
	    
		NickName.setCellValueFactory(new PropertyValueFactory<>("player"));
		Date.setCellValueFactory(new PropertyValueFactory<>("date"));
		Points.setCellValueFactory(new PropertyValueFactory<>("Points"));
		Table.setItems(observQues);		
	}

}
