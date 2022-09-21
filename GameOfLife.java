package app;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class GameOfLife extends Application {

	
	@Override
	public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("GameOfLife.fxml"));
		Scene scene = new Scene(root);		
		stage.setTitle("Game of Life");
		stage.setScene(scene);
		stage.show();
		
	}
	public static void main(String[] args) {
		launch(args);

	}

}
