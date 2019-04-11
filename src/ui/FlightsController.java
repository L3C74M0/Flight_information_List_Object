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
	private String label1="";
	private String label2="";
	private String label3="";
	
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
    private Label dateColum;
	
	@FXML
    private Label flightColumn;
	
	 @FXML
	 private Label airlineColumn;
	
	@FXML
    void generateFlights(ActionEvent event) {
		int value = 0;
		try {
    		value = Integer.parseInt(amountFlights.getText());
    		flights = new Flights(flights.generateFlightsList(value));
    	}catch(NumberFormatException e) {
    		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("ERROR");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Please enter some number");
        	info.show();
    	} 
		showTable();
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
		try {
			flights.SortByAirline();
			showTable();
		}catch(NullPointerException e) {
    		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("ERROR");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Please enter some number");
        	info.show();
    	} 
	}

	@FXML
	void sortByCity(ActionEvent event) {
		try{
			flights.SortByDesnitationCity();
			showTable();
		}catch(NullPointerException e) {
    		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("ERROR");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Please enter some number");
        	info.show();
    	} 
	}

	@FXML
	void sortByDate(ActionEvent event) {
		try{
			flights.sortByDate();
			showTable();
		}catch(NullPointerException e) {
    		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("ERROR");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Please enter some number");
        	info.show();
    	} 
	}

	@FXML
	void sortByFlight(ActionEvent event) {
		try{
			flights.sortByFlightId();
			showTable();
		}catch(NullPointerException e) {
    		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("ERROR");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Please enter some number");
        	info.show();
    	} 
	}

	@FXML
	void sortByGate(ActionEvent event) {
		try{
			flights.sortByBoardingGate();
			showTable();
		}catch(NullPointerException e) {
    		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("ERROR");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Please enter some number");
        	info.show();
    	} 
	}

	@FXML
	void sortByTime(ActionEvent event) {
		try{
			flights.sortByDeparture();;
			showTable();
		}catch(NullPointerException e) {
    		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("ERROR");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Please enter some number");
        	info.show();
    	} 
	}

	@FXML
	void initialize() {
		flights = new Flights(null);
		nextPage.setVisible(false);
		previousPage.setVisible(false);
	}
	
	public void showTable() {
		label1="";
		label2="";
		label3="";
		for (int I = 0; I < flights.getFlights().size(); I++) {
			label1 += flights.getFlights().get(I).getDate() + "\t" + flights.getFlights().get(I).getDepartureTime()
					+ "\t\t\t\t\t\t\t\t\t\t\t\t\t" + flights.getFlights().get(I).getBoardingGate() + "\n";
			dateColum.setText(label1);

			label2 += flights.getFlights().get(I).getId() + "\t\t\t" + flights.getFlights().get(I).getDestinationCity()
					+ "\n";
			flightColumn.setText(label2);

			label3 += flights.getFlights().get(I).getAirline() + "\n";
			airlineColumn.setText(label3);
		}
	}
	
	
}
