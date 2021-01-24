package model;
import application.LogisticPopulationGrowth;
import application.Model;
import application.MultiReturnValues;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class LogisticPopulationGrowthController<K, V> implements Initializable{

	@FXML
	private LineChart<?,?> LineChart;

	@FXML
	private CategoryAxis x;

	@FXML
	private NumberAxis y;

	@FXML
	private MenuItem help;

	@FXML
	private MenuItem home;

	@FXML
	private TextField txt1;


	@FXML
	void homebutton(ActionEvent event) throws IOException {
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/HomeScreen.fxml"));
		Scene scene = new Scene(root);
		Image icon = new Image("/view/logo.jpg");
		stage.getIcons().add(icon);
		stage.setTitle("SurvivalOfTheFittest");
		stage.setScene(scene);
		stage.show();
		LineChart.getData().clear();
	}

	@FXML
	void handleButtonAction(ActionEvent event) throws IOException {
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/HelpAbout.fxml"));
		Scene scene = new Scene(root);
		Image icon = new Image("/view/logo.jpg");
		stage.getIcons().add(icon);
		stage.setTitle("SurvivalOfTheFittest");
		stage.setScene(scene);
		stage.show();
	}

	public void btn(ActionEvent event)
	{
		String msg1= txt1.getText();
		
		try {
			int year = Integer.parseInt(msg1);
			if (year <= 2017) {
				alert2();
			}
			// HERE WE PUT THE FUNCTION of LOGISTIC POPULATION GROWTH
			//Predation predation=new Predation();
			LogisticPopulationGrowth logistic = new LogisticPopulationGrowth();
			logistic.logisticPopulationGrowth(year);
			TreeMap<String, Double> deer = MultiReturnValues.getTreeMap(LogisticPopulationGrowth.getnD_Copy());
			TreeMap<String, Double> horse =  MultiReturnValues.getTreeMap(LogisticPopulationGrowth.getnH_Copy());
			TreeMap<String, Double> cattle =  MultiReturnValues.getTreeMap(LogisticPopulationGrowth.getnC_Copy());

			//Map<String,Double> deer= predation.deerPopulationGrowth(wolves,year);
			//Map<String,Double> horse=predation.horsePopulationGrowth(wolves,year);
			//Map<String,Double> cattle=predation.cattlePopulationGrowth(wolves,year);


			LineChart.getData().clear();

			XYChart.Series series = new XYChart.Series();
			series.setName("Deer");
			for (Map.Entry<String, Double> entry: deer.entrySet()) {
				String tmpString = entry.getKey();
				Double tmpValue = entry.getValue();
				XYChart.Data<String, Double> d = new XYChart.Data<>(tmpString, tmpValue);
				System.out.println(d);
				series.getData().add(d);
			}

			XYChart.Series series2 = new XYChart.Series();
			series2.setName("Horse");
			for (Map.Entry<String, Double> entry : horse.entrySet()) {
				String tmpString = entry.getKey();
				Double tmpValue = entry.getValue();
				XYChart.Data<String, Double> h = new XYChart.Data<>(tmpString, tmpValue);
				System.out.println(h);
				series2.getData().add(h);
			}

			XYChart.Series series3 = new XYChart.Series();
			series3.setName("Cattle");
			for (Map.Entry<String, Double> entry : cattle.entrySet()) {
				String tmpString = entry.getKey();
				Double tmpValue = entry.getValue();
				XYChart.Data<String, Double> c = new XYChart.Data<>(tmpString, tmpValue);
				System.out.println(c);
				series3.getData().add(c);
			}


			LineChart.getData().addAll(series, series2, series3);

//	    	ObservableList<Map<String, Double>> data=FXCollections.observableArrayList();
//	    	data.add(deer);
//
			//yearColumn.setCellValueFactory(new MapValueFactory<>(deer.keySet()));
//	    	table.getItems().addAll(data);
		}
		catch (Exception e)
		{
			alert();

		}
	}

	@FXML
	public void alert(){
		Alert a1= new Alert(Alert.AlertType.ERROR);
		a1.setTitle("Error");
		a1.setContentText("Only an Integer value is allowed");
		a1.setHeaderText(null);
		a1.showAndWait();
	}

	@FXML
	public void alert2()
	{
		Alert a1= new Alert(Alert.AlertType.ERROR);
		a1.setTitle("Error");
		a1.setContentText("Year before 2017 is not valid");
		a1.setHeaderText(null);
		a1.showAndWait();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}
