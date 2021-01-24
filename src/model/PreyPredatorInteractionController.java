package model;
import application.Predation;


import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.chart.LineChart;

public class PreyPredatorInteractionController<K, V> implements Initializable{
	
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
    private TextField txt2;
    
    @FXML
    private TableView<?> table;
    
    @FXML
    private TableColumn<K,V> yearColumn;

    @FXML
    private TableColumn<K,V> deerColumn;

    @FXML
    private TableColumn<K,V> cattleColumn;

    @FXML
    private TableColumn<K,V> horseColumn;

    @FXML
    private TableColumn<K,V> wolvesColumn;
    
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
    
    public void btn(ActionEvent event)
    {
    	String msg1= txt1.getText();
    	String msg2= txt2.getText();
    	try 
    	{
	    	double wolves =Integer.parseInt(msg1);
	    	int year = Integer.parseInt(msg2);
	    	if(year<=2017)
	    	{
	    		alert2();
	    	}
	    	
	    	Predation predation=new Predation();
	    	Map<String,Double> deer= predation.deerPopulationGrowth(wolves,year);
	    	Map<String,Double> horse=predation.horsePopulationGrowth(wolves,year);
	    	Map<String,Double> cattle=predation.cattlePopulationGrowth(wolves,year);
	    	Map<String,Double> wolf=predation.predatorPopulationGrowth(wolves,year);
	    	
	    	
	    	LineChart.getData().clear();
	    	
	    	XYChart.Series series = new XYChart.Series();
	    	series.setName("Deer");
	    	for(Map.Entry<String, Double> entry:deer.entrySet())
	    	{
	    		String tmpString = entry.getKey();
	            double tmpValue = entry.getValue();
	            XYChart.Data<String, Double> d = new XYChart.Data<>(tmpString, tmpValue);
	            System.out.println(d);
	            series.getData().add(d);
	    	}
	    	
	    	XYChart.Series series2 = new XYChart.Series();
	    	series2.setName("Horse");
	    	for(Map.Entry<String, Double> entry:horse.entrySet())
	    	{
	    		String tmpString = entry.getKey();
	            double tmpValue = entry.getValue();
	            XYChart.Data<String, Double> h = new XYChart.Data<>(tmpString, tmpValue);
	            System.out.println(h);
	            series2.getData().add(h);
	    	}
	    	
	    	XYChart.Series series3 = new XYChart.Series();
	    	series3.setName("Cattle");
	    	for(Map.Entry<String, Double> entry:cattle.entrySet())
	    	{
	    		String tmpString = entry.getKey();
	            double tmpValue = entry.getValue();
	            XYChart.Data<String, Double> c = new XYChart.Data<>(tmpString, tmpValue);
	            System.out.println(c);
	            series3.getData().add(c);
	    	}
	    	
	    	XYChart.Series series4 = new XYChart.Series();
	    	series4.setName("Wolves");
	    	for(Map.Entry<String, Double> entry:wolf.entrySet())
	    	{
	    		String tmpString = entry.getKey();
	            double tmpValue = entry.getValue();
	            XYChart.Data<String, Double> w = new XYChart.Data<>(tmpString, tmpValue);
	            System.out.println(w);
	            series4.getData().add(w);
	    	}
	    	
	    	LineChart.getData().addAll(series,series2,series3,series4);
	    	
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
    public void alert()
    {
    	Alert a1= new Alert(Alert.AlertType.ERROR);
    	a1.setTitle("Error");
    	a1.setContentText("Integer is only allowed");
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
