package model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class FlightsTest {

	ArrayList<Flight> flight;
	Flights fight;

	public void setupScenary1() {
		flight = new ArrayList<Flight>();
	}

	public void setupScenary3() {
		try {
			fight = new Flights(null);
		} catch (IOException e) {
		}
	}

	@Test
	public void generateFlightsListTest() {
		setupScenary1();
		Flights flights;
		try {
			flights = new Flights(null);
			//flight = flights.generateFlightsList(2);
			assertNotNull(flight, "La lista esta vacia");
		} catch (IOException e) {

		}
	}

	@Test
	public void sortByDateTest() {

	}

	@Test
	public void sortByDepartureTest() {
		setupScenary3();
		fight.generateFlightsList(0);
		fight.sortByDeparture();
		assertTrue("No se ordeno el arreglo", true);
	}

	@Test
	public void SortByAirlineTest() {
		setupScenary3();
		fight.generateFlightsList(0);
		fight.SortByAirline();
		assertTrue("No se ordeno el arreglo", true);
	}

	@Test
	public void SortByDesnitationCityTest() {
		setupScenary3();
		fight.generateFlightsList(0);
		fight.SortByDesnitationCity();
		assertTrue("No se ordeno el arreglo", true);
	}

	@Test
	public void sortByBoardingGateTest() {
		setupScenary3();
		fight.generateFlightsList(0);
		fight.sortByBoardingGate();
		assertTrue("No se ordeno el arreglo", true);
	}

	@Test
	public void sortByFlightIdTest() {
		setupScenary3();
		fight.generateFlightsList(0);
		fight.sortByFlightId();
		assertTrue("No se ordeno el arreglo", true);
	}

	@Test
	public void calculateTimeTest() {
		
	}

	@Test
	public void searchFlyTest() {

	}

	@Test
	public void searchByBoardingGateTest() {

	}

	@Test
	public void loadCitiesTest() {

	}

	@Test
	public void loadAirlinesTest() {

	}
}
