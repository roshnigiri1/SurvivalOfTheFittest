package model;

import java.io.IOException;

import java.util.Optional;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainHome extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/HomeScreen.fxml"));
		Scene scene = new Scene(root);
		Image icon = new Image("/view/logo.jpg");
		stage.getIcons().add(icon);
		stage.setTitle("SurvivalOfTheFittest");
		stage.setOnCloseRequest(e ->{
			e.consume();
			closeProgram(stage);
		} );
		stage.setScene(scene);
		stage.show();
	}
	

	public static void main(String[] args) {
		launch(args);
	}
	
	private  void closeProgram(Stage stage) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText("Close?");
		alert.setContentText("Application will be closed!");
		
		Optional<ButtonType> result = alert.showAndWait();
		if(result.get()==ButtonType.OK) {
			stage.close();
		}
}
}
