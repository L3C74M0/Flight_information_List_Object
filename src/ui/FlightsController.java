package ui;

import java.io.IOException;
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
	private String label1 = "";
	private String label2 = "";
	private String label3 = "";
	int currentPage = 1;
	private long delayedTime;

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
    private Label delayedTimeLabel;

	@FXML
	void generateFlights(ActionEvent event) {
		int value = 0;
		try {
			value = Integer.parseInt(amountFlights.getText());
			try {
				flights = new Flights(flights.generateFlightsList(value));
				if (value > 10) {
					nextPage.setVisible(true);
					previousPage.setVisible(true);
				}
				showTable();
			} catch (IOException e) {
				
			}
		} catch (NumberFormatException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Please enter some number");
			info.show();
		}
	}

	@FXML
	void nextPage(ActionEvent event) {
		int newPage = currentPage + 1;
		if (newPage < (flights.getFlights().size() / 10) + 2) {
			currentPage = newPage;
			showTable();
		}
	}

	@FXML
	void previousPage(ActionEvent event) {
		int newPage = currentPage - 1;
		if (newPage > 0) {
			currentPage = newPage;
			showTable();
		}
	}

	@FXML
	void searchFlight(ActionEvent event) {
		if (flights.getFlights() != null) {
			try {
				String characteristic = searchValue.getText();
				if(flights.searchFly(characteristic)==null) {
					Alert info = new Alert(AlertType.ERROR);
					info.setTitle("ERROR");
					info.setHeaderText(null);
					info.initStyle(StageStyle.UTILITY);
					info.setContentText("The searched flight has not been found");
					info.show();
				}else {
					showTable();
				}
			} catch (NumberFormatException e) {
				Alert info = new Alert(AlertType.ERROR);
				info.setTitle("ERROR");
				info.setHeaderText(null);
				info.initStyle(StageStyle.UTILITY);
				info.setContentText("please write some value");
				info.show();
			}
		} else {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Please create some flights first");
			info.show();
		}
	}

	@FXML
	void sortByAirline(ActionEvent event) {
		try {
			delayedTime = System.currentTimeMillis();
			flights.SortByAirline();
			delayedTimeLabel.setText("Time delayed: "+flights.calculateTime(delayedTime));
			showTable();
		} catch (NullPointerException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Please create some flights first");
			info.show();
		}
	}

	@FXML
	void sortByCity(ActionEvent event) {
		try {
			delayedTime = System.currentTimeMillis();
			flights.SortByDesnitationCity();
			delayedTimeLabel.setText("Time delayed: "+flights.calculateTime(delayedTime));
			showTable();
		} catch (NullPointerException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Please create some flights first");
			info.show();
		}
	}

	@FXML
	void sortByDate(ActionEvent event) {
		try {
			delayedTime = System.currentTimeMillis();
			flights.sortByDate();
			delayedTimeLabel.setText("Time delayed: "+flights.calculateTime(delayedTime));
			showTable();
		} catch (NullPointerException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Please create some flights first");
			info.show();
		}
	}

	@FXML
	void sortByFlight(ActionEvent event) {
		try {
			delayedTime = System.currentTimeMillis();
			flights.sortByFlightId();
			delayedTimeLabel.setText("Time delayed: "+flights.calculateTime(delayedTime));
			showTable();
		} catch (NullPointerException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Please create some flights first");
			info.show();
		}
	}

	@FXML
	void sortByGate(ActionEvent event) {
		try {
			delayedTime = System.currentTimeMillis();
			flights.sortByBoardingGate();
			delayedTimeLabel.setText("Time delayed: "+flights.calculateTime(delayedTime));
			showTable();
		} catch (NullPointerException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Please create some flights first");
			info.show();
		}
	}

	@FXML
	void sortByTime(ActionEvent event) {
		try {
			delayedTime = System.currentTimeMillis();
			flights.sortByDeparture();
			delayedTimeLabel.setText("Time delayed: "+flights.calculateTime(delayedTime));
			showTable();
		} catch (NullPointerException e) {
			Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Please create some flights first");
			info.show();
		}
	}

	@FXML
	void initialize() {
		try {
			flights = new Flights(null);
			nextPage.setVisible(false);
			previousPage.setVisible(false);
		} catch (IOException e) {
		}
	}

	public void showTable() throws NullPointerException{
		label1 = "";
		label2 = "";
		label3 = "";

		int pages = (flights.getFlights().size() / 10);

		for (int i = 0; i <= pages; i++) {
			if (i + 1 == currentPage) {
				for (int J = (10 * i); J < 10 + (10 * i) && J < flights.getFlights().size(); J++) {
					label1 += flights.getFlights().get(J).getDate() + "\t"
							+ flights.getFlights().get(J).getDepartureTime() + "\t\t\t\t\t\t\t\t\t\t\t\t\t"
							+ flights.getFlights().get(J).getBoardingGate() + "\n";
					dateColum.setText(label1);

					label2 += flights.getFlights().get(J).getId() + "\t\t\t"
							+ flights.getFlights().get(J).getDestinationCity() + "\n";
					flightColumn.setText(label2);

					label3 += flights.getFlights().get(J).getAirline() + "\n";
					airlineColumn.setText(label3);
				}

			}
		}
	}
}