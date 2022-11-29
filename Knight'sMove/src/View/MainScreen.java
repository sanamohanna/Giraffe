package View;

import java.io.IOException;

import Control.QuestionMngController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class MainScreen extends Application {

	public void start(Stage primaryStage) throws  IOException{
		
		try {
<<<<<<< HEAD
			Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("mainScreen.css").toExternalForm());
			Image icon = new Image("6808582.png");
			primaryStage.getIcons().add(icon);
			primaryStage.setTitle("Knight's Move Game");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (IOException e) {
=======
			mainBorder = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
		} catch (IOException e) {
>>>>>>> 87bd42ad1be40877ef11f0240206e7e0c1e4ab4d
			e.printStackTrace();
		}
	}

}
