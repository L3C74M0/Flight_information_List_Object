package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;
import model.Flights;

public class FlightsController {
	
	private Flights flights;
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Pane pane;

	@FXML
	private ImageView wallpaper0;

	@FXML
	private ImageView wallpaper2;

	@FXML
	private ImageView wallpaper1;

	@FXML
	private Button date;

	@FXML
	private Button time;

	@FXML
	private Button airline;

	@FXML
	private Button flight;

	@FXML
	private Button destiny;

	@FXML
	private Button gate;

	@FXML
	private Label currentTime;

	@FXML
	private ImageView backGround;

	@FXML
	private Button nextPage;

	@FXML
	private Button previousPage;

	@FXML
	private Button search;

	@FXML
	private TextField searchValue;

	@FXML
	private TextField amountFlights;

	@FXML
    private Button generateFlights;

	@FXML
    void generateFlights(ActionEvent event) {
		int value = 0;
		try {
    		value = Integer.parseInt(amountFlights.getText());
    		flights = new Flights(flights.generateFlightsList(value));
    		
    		for (int i = 0; i < flights.getFlights().size(); i++) {
    			System.out.println(flights.getFlights().get(i).getDate()+"\t"+
    					flights.getFlights().get(i).getDepartureTime()+"\t"+
    					flights.getFlights().get(i).getAirline()+"\t"+
    					flights.getFlights().get(i).getId()+"\t"+
    					flights.getFlights().get(i).getDestinationCity()+"\t"+
    					flights.getFlights().get(i).getBoardingGate()+"\t");	
    		}
    		System.out.println("\nOrdenados\n");
    		
    		//ordenar por fecha y hora de salida
    		flights.SortByDesnitationCity();
    	}catch(NumberFormatException e) {
    		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("ERROR");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Please enter some number");
        	info.show();
    	} 
		
		
		
		/**
		 * Prueba en consola para ver si se crean vuelos correctamente
		*/
		for (int i = 0; i < flights.getFlights().size(); i++) {
			System.out.println(flights.getFlights().get(i).getDate()+"\t"+
					flights.getFlights().get(i).getDepartureTime()+"\t"+
					flights.getFlights().get(i).getAirline()+"\t"+
					flights.getFlights().get(i).getId()+"\t"+
					flights.getFlights().get(i).getDestinationCity()+"\t"+
					flights.getFlights().get(i).getBoardingGate()+"\t");	
		}
    }
	
	@FXML
	void nextPage(ActionEvent event) {

	}

	@FXML
	void previousPage(ActionEvent event) {

	}

	@FXML
	void searchFlight(ActionEvent event) {
		
	}

	@FXML
	void sortByAirline(ActionEvent event) {

	}

	@FXML
	void sortByCity(ActionEvent event) {

	}

	@FXML
	void sortByDate(ActionEvent event) {

	}

	@FXML
	void sortByFlight(ActionEvent event) {

	}

	@FXML
	void sortByGate(ActionEvent event) {

	}

	@FXML
	void sortByTime(ActionEvent event) {

	}

	@FXML
	void initialize() {
		flights = new Flights(null);
		nextPage.setVisible(false);
		previousPage.setVisible(false);
	}
}
