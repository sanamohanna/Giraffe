package View;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class MainScreen extends Application {
	 public static Stage stage;
	public static void main(String[] args) {
		Application.launch(args);
	}
	// this method display the main screen 
//	public void start(Stage primaryStage) throws IOException {
//
//		try {
//
//			Parent root = FXMLLoader.load(getClass().getResource("/View/StartGame.fxml"));
//			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("/View/StartGame.css").toExternalForm());
//			Image icon = new Image("/View/Images/6808582.png"); 
//			primaryStage.setResizable(false);
//			primaryStage.getIcons().add(icon);
//			primaryStage.setTitle("KNIGHT'S MOVE GAME");
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//	}
	public void start(Stage primaryStage) throws IOException {

		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/View/mainScreen.css").toExternalForm());
			Image icon = new Image("/View/Images/6808582.png"); 
			primaryStage.setResizable(false);
			primaryStage.getIcons().add(icon);
			primaryStage.setTitle("KNIGHT'S MOVE GAME");
			primaryStage.setScene(scene);
			stage=primaryStage;
			primaryStage.show();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
