package model;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class FlightTest {

	Flight flight;

	public void setupScenary2() {
		flight = new Flight("2019-01-31", "12:00 AM", "Avianca", "8742", "Braga", 5);
	}

	@Test
	public void getBoardingGateTest() {
		setupScenary2();
		int boardingGate = 5;
		assertTrue("No se tomo correctamente la fecha de un vuelo", boardingGate == flight.getBoardingGate());
	}

	@Test
	public void getDestinationCityTest() {
		setupScenary2();
		String destinationCity = "Braga";
		assertTrue("No se tomo correctamente la ciudad de destino de un vuelo",
				destinationCity.equalsIgnoreCase(flight.getDestinationCity()));
	}

	@Test
	public void getIdTest() {
		setupScenary2();
		String id = "8742";
		assertTrue("No se tomo correctamente el identificador de un vuelo", id.equalsIgnoreCase(flight.getId()));
	}

	@Test
	public void getAirlineTest() {
		setupScenary2();
		String airline = "Avianca";
		assertTrue("No se tomo correctamente la aerolinea de un vuelo", airline.equalsIgnoreCase(flight.getAirline()));
	}

	@Test
	public void getDepartureTimeTest() {
		setupScenary2();
		String departureTime = "12:00 AM";
		assertTrue("No se tomo correctamente la hora de partida de un vuelo",
				departureTime.equalsIgnoreCase(flight.getDepartureTime()));
	}

	@Test
	public void getDateTest() {
		setupScenary2();
		String date = "2019-01-31";
		assertTrue("No se tomo correctamente la fecha de un vuelo", date.equalsIgnoreCase(flight.getDate()));
	}
}
