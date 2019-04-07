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
	public ArrayList<Flight> generateFlightsList(int value) {
		flights = new ArrayList<Flight>();

		for (int I = 0; I < value; I++) {
			int month = (int) (Math.random() * 12 + 1);
			int day = (int) (Math.random() * 30 + 1);
			String date = "2019";
			if (month < 10 && day < 10) {
				date += "-0" + month + "-0" + day;
			} else if (month < 10 && day > 10) {
				date += "-0" + month + "-" + day;
			} else if (month > 10 && day < 10) {
				date += "-" + month + "-0" + day;
			} else {
				date += "-" + month + "-" + day;
			}

			String departureTime = "";
			int hour = (int) (Math.random() * 12 + 1);
			int minutes = (int) (Math.random() * 59);
			int momentOfTheDay = (int) (Math.random() * 1);

			if (hour < 10) {
				departureTime += "0" + hour + ":";
			} else {
				departureTime += hour + ":";
			}
			if (minutes < 10) {
				departureTime += "0" + minutes;
			} else {
				departureTime += minutes;
			}
			if (momentOfTheDay == 0) {
				departureTime += " AM";
			} else {
				departureTime = " PM";
			}

			int air = (int) (Math.random() * 10);
			String airline = airlines[air];

			int temp2 = (int) (Math.random() * 9999);
			String id = temp2 + "";

			int temp1 = (int) (Math.random() * 10);
			String destinationCity = cities[temp1];

			int boardingGate = (int) (Math.random() * 20);

			Flight temp = new Flight(date, departureTime, airline, id, destinationCity, boardingGate);
			flights.add(temp);
		}
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
