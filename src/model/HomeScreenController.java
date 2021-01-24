package model;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeScreenController {
	@FXML
    private MenuItem home;
    @FXML
    private AnchorPane HomeScreenController;

    @FXML
    private MenuItem HelpAbout;
    
    @FXML
    private Button model1;
    
    @FXML
    private Button model2;

    @FXML
    private Button model3;
    
//	Scene scene1, scene2, scene3, scene, scenea, sceneb ;
//	
//    @FXML
//    void handleButton(ActionEvent event) throws IOException {
//    	Stage stage = new Stage();
//		
//		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/HomeScreen.fxml"));
//		scene = new Scene(root);
//		
//		Parent roota = FXMLLoader.load(getClass().getClassLoader().getResource("view/HomeScreen.fxml"));
//		scenea = new Scene(roota);
//		
//		Parent rootb = FXMLLoader.load(getClass().getClassLoader().getResource("view/HelpAbout.fxml"));
//		sceneb= new Scene(rootb);
//		
//		Parent root1 = FXMLLoader.load(getClass().getClassLoader().getResource("view/PopulationGrowthOptions.fxml"));
//		scene1 = new Scene(root1);
//		
//		Parent root2 = FXMLLoader.load(getClass().getClassLoader().getResource("view/LargeHerbivoreInteraction.fxml"));
//		scene2 = new Scene(root2);
//		
//		Parent root3 = FXMLLoader.load(getClass().getClassLoader().getResource("view/PreyPredatorInteraction.fxml"));
//		scene3 = new Scene(root3);
//		
//		home.setOnAction(e -> stage.setScene(scenea));
//		HelpAbout.setOnAction(e -> stage.setScene(sceneb));
//		model1.setOnAction(e -> stage.setScene(scene1));
//		model2.setOnAction(e -> stage.setScene(scene2));
//		model3.setOnAction(e -> stage.setScene(scene3));
//		
//		stage.setScene(scene);
//		stage.show();
//
//    }
    Stage stage1, stage2, stage3, stage4, stage5;
    @FXML
    void homebutton(ActionEvent event) throws IOException {
    	stage1 = new Stage();
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/HomeScreen.fxml"));
		Scene scene = new Scene(root);
		Image icon = new Image("/view/logo.jpg");
		stage1.getIcons().add(icon);
		stage1.setTitle("SurvivalOfTheFittest");
		stage1.setScene(scene);
		stage1.show(); 
    }

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
    	Stage stage2 = new Stage();
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/HelpAbout.fxml"));
		Scene scene = new Scene(root);
		Image icon = new Image("/view/logo.jpg");
		stage2.getIcons().add(icon);
		stage2.setTitle("SurvivalOfTheFittest");
		stage2.setScene(scene);
		stage2.show();

    }
    
    @FXML
    void model1button(ActionEvent event) throws IOException {
    	stage3 = new Stage();
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/PopulationGrowthOptions.fxml"));
		Scene scene = new Scene(root);
		Image icon = new Image("/view/logo.jpg");
		stage3.getIcons().add(icon);
		stage3.setTitle("SurvivalOfTheFittest");
		stage3.setScene(scene);
		stage3.show();
    }
    @FXML
    void model2button(ActionEvent event) throws IOException {
    	stage4 = new Stage();
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/LargeHerbivoreInteraction.fxml"));
		Scene scene = new Scene(root);
		Image icon = new Image("/view/logo.jpg");
		stage4.getIcons().add(icon);
		stage4.setTitle("SurvivalOfTheFittest");
		stage4.setScene(scene);
		stage4.show();
    }

    @FXML
    void model3button(ActionEvent event) throws IOException {
    	stage5 = new Stage();
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/PreyPredatorInteraction.fxml"));
		Scene scene = new Scene(root);
		Image icon = new Image("/view/logo.jpg");
		stage5.getIcons().add(icon);
		stage5.setTitle("SurvivalOfTheFittest");
		stage5.setScene(scene);
		stage5.show();
    }

}
