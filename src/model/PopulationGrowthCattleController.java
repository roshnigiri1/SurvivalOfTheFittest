package model;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class PopulationGrowthCattleController {

    @FXML
    private MenuItem help;
    
	@FXML
    private MenuItem home;
	
	@FXML
    private Button back;
   
    @FXML
    void homebutton(ActionEvent event) throws IOException {
    	Stage stage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/HomeScreen.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
    	Stage stage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/HelpAbout.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
    
    @FXML
    void popgrowthchoice(ActionEvent event) throws IOException {
    	Stage stage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/PopulationGrowthOptions.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

}
