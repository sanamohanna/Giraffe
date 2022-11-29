package View;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainScreen extends Application {
	private AnchorPane mainBorder;

	public void start(Stage primaryStage) {
		
		try {
			mainBorder = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(mainBorder);
		Image icon = new Image("6808582.png");
		primaryStage.getIcons().add(icon);
		primaryStage.setTitle("Knight's Move Game");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		}
}
