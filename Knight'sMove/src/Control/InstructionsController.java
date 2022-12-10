package Control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class InstructionsController {
// Event Listener on Button[#backButton].onAction
	@FXML
	private Button backButton;

	public void backButton(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		// stage.setResizable(false);
		scene.getStylesheets().add(getClass().getResource("/View/mainScreen.css").toExternalForm());
		stage.setScene(scene);
		stage.show();

	}
}
