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
		// DisplayController.mainscreen = this;

		try {
			mainBorder = FXMLLoader.load(getClass().getResource("/View/mainscreen.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(mainBorder);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Knight's Move");
		primaryStage.setResizable(false);
		// primaryStage.getIcons().add(new
		// Image(getClass().getResourceAsStream("/View/pictures/logo.png")));
		primaryStage.show();
		// primary = primaryStage;

		// loadesign(1);
		// SoundController.getInstance().playIntro();

	}
}
