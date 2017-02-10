package exercise10;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Parent;

import javafx.stage.Stage;
// extends Application extends all the effects from javafx.
public class Main extends Application {
	private Stage primaryStage;
	
	private AnchorPane mainLayout;
	
	@Override
	// this method is used to initialize the GUI.
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Psychophysics.fxml"));
		Scene sc = new Scene(root);
		primaryStage.setScene(sc);
		primaryStage.setTitle("Psychophysics");
		primaryStage.show();
		
		
	}

		
		
	public static void main(String[] args) {
		//launch(args) method inside application.
		launch(args);
	}
}