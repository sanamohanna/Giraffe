package View;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class MainScreen extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage primaryStage) throws IOException {

		try {

			Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/View/mainScreen.css").toExternalForm());
			Image icon = new Image("6808582.png"); 
			primaryStage.setResizable(false);
			primaryStage.getIcons().add(icon);
			primaryStage.setTitle("Knight's Move Game");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
