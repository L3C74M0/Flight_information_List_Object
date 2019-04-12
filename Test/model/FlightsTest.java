package model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class FlightsTest {
	
	ArrayList<Flight> flight;
	
	public void setupScenary1(){
		flight = new ArrayList<Flight>();
	}
	
	@Test
	public void generateFlightsList() {
		setupScenary1();
		Flights flights;
		try {
			flights = new Flights(null);
			flight = flights.generateFlightsList(2);
			assertNotNull(flight, "La lista esta vacia");
		} catch (IOException e) {
			
		}
	}
	
}
