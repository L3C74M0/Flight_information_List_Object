package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class FlightsController {

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
	void nextPage(ActionEvent event) {

	}

	@FXML
	void previousPage(ActionEvent event) {

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
		assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'window.fxml'.";
		assert wallpaper0 != null : "fx:id=\"wallpaper0\" was not injected: check your FXML file 'window.fxml'.";
		assert wallpaper2 != null : "fx:id=\"wallpaper2\" was not injected: check your FXML file 'window.fxml'.";
		assert wallpaper1 != null : "fx:id=\"wallpaper1\" was not injected: check your FXML file 'window.fxml'.";
		assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'window.fxml'.";
		assert time != null : "fx:id=\"time\" was not injected: check your FXML file 'window.fxml'.";
		assert airline != null : "fx:id=\"airline\" was not injected: check your FXML file 'window.fxml'.";
		assert flight != null : "fx:id=\"flight\" was not injected: check your FXML file 'window.fxml'.";
		assert destiny != null : "fx:id=\"destiny\" was not injected: check your FXML file 'window.fxml'.";
		assert gate != null : "fx:id=\"gate\" was not injected: check your FXML file 'window.fxml'.";
		assert currentTime != null : "fx:id=\"currentTime\" was not injected: check your FXML file 'window.fxml'.";
		assert backGround != null : "fx:id=\"backGround\" was not injected: check your FXML file 'window.fxml'.";
		assert nextPage != null : "fx:id=\"nextPage\" was not injected: check your FXML file 'window.fxml'.";
		assert previousPage != null : "fx:id=\"previousPage\" was not injected: check your FXML file 'window.fxml'.";
	}
}