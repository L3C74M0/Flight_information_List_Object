package model;

import java.util.ArrayList;

public class Flights {
	private ArrayList<Flight> flights;
	private String[] cities;
	private String[] airlines;

	public Flights(ArrayList<Flight> flights) {
		this.flights = flights;
		cities = new String[10];
		airlines = new String[10];
		
		cities[0]="Bogota";
		cities[2]="Medellin";
		cities[3]="Cali";
		cities[4]="Lima";
		cities[5]="Cartagena";
		cities[6]="Cucuta";
		cities[7]="Texas";
		cities[8]="Braga";
		cities[9]="Mescu";
		
		airlines[0] = "Avianca";
		airlines[1] = "LATAM";
		airlines[2] = "EASYFLY";
		airlines[3] = "Wingo";
		airlines[4] = "SATENA";
		airlines[5] = "VivaColombia";
		airlines[6] = "IBERIA";
		airlines[7] = "AmericanAirlines";
		airlines[8] = "AirFrance";
		airlines[9] = "DELTA";
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}

	/*
	 * El metodo genera una lista de vuelos aleatoriamente
	 * return ArrayList<Flight>
	 */
	public ArrayList<Flight> generateFlightsList() {
		flights = new ArrayList<Flight>();

		return flights;
	}
	/*
	 * El metodo organiza el arraylist por fecha
	 */
	public void SortByDate() {
		
	}
	
	public void sortByDeparture() {
		
	}

	public void SortByAirline() {
		
	}
	
	public void sortById() {
		
	}
	
	public void SortByDesnitationCity() {
		
	}
	
	public void sortByBoardingGate() {
		
	}
	/*
	 * El metodo calcula el tiempo que tardó en realizar una búsqueda u ordenamiento
	 */
	public long calculateTime() {
		long time=0;
		
		return time;
	}
	/*
	 * El metodo busca en un arreglo un vuelo
	 * return el primer Flight encontrado
	 */
	public Flight searchFly(String characteristic) {
		Flight temp = null;
		return temp;
		
	}
}
