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

		cities[0] = "Bogota";
		cities[2] = "Medellin";
		cities[3] = "Cali";
		cities[4] = "Lima";
		cities[5] = "Cartagena";
		cities[6] = "Cucuta";
		cities[7] = "Texas";
		cities[8] = "Braga";
		cities[9] = "Quito";

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
	 * El metodo genera una lista de vuelos aleatoriamente return ArrayList<Flight>
	 */
	public ArrayList<Flight> generateFlightsList(int value) {
		flights = new ArrayList<Flight>();

		for (int I = 0; I < value; I++) {
			int month = (int) (Math.random() * 12 + 1);
			int day = (int) (Math.random() * 30 + 1);
			String date = "2019";
			if (month < 10) {
				date += "-0" + month;
			} else {
				date += "-" + month;
			}
			if (day < 10) {
				date += "-0" + day;
			} else {
				date += "-" + day;
			}

			String departureTime = "";
			int hour = (int) (Math.random() * 12 + 1);
			int minutes = (int) (Math.random() * 59);
			int momentOfTheDay = (int) (Math.random() * 2);

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
			if (momentOfTheDay == 1) {
				departureTime += " AM";
			} else {
				departureTime += " PM";
			}

			int air = (int) (Math.random() * 10);
			String airline = airlines[air];

			int temp2 = (int) (Math.random() * 9999 + 1000);
			if (temp2 > 9999) {
				temp2 = (int) (Math.random() * 2000 + 1000);
			}
			String id = temp2 + "";

			int temp1 = (int) (Math.random() * 10);
			String destinationCity = cities[temp1];
			if (destinationCity == null) {
				destinationCity = cities[0];
			}

			int boardingGate = (int) (Math.random() * 20);

			Flight temp = new Flight(date, departureTime, airline, id, destinationCity, boardingGate);
			flights.add(temp);
		}
		return flights;
	}

	/*
	 * El metodo organiza el arraylist por fecha, sin completar
	 */

	public void sortByDate() {
		for (int I = 0; I < flights.size() - 1; I++) {
			String minorDate = flights.get(I).getDate();
			String[] separateDate = minorDate.split("-");
			String minMonth = separateDate[1];
		//	String minDay = separateDate[2];
			int minorPosition = I;

			for (int J = I + 1; J < flights.size(); J++) {
				String dateNext = flights.get(J).getDate();
				String[] separateDateNext = dateNext.split("-");
				String monthNex = separateDateNext[1];
			//	String dayNex = separateDateNext[2];

				if (monthNex.compareTo(minMonth) < 0) {
					minorPosition = J;
					minorDate = flights.get(J).getDate();
				}

				Flight temp = flights.get(minorPosition);
				flights.set(minorPosition, flights.get(I));
				flights.set(I, temp);
			}
		}
	}
	/**
	 * Organiza los vuelos por horas de salida
	 * 
	 */
	public void sortByDeparture() {
		for (int K = 0; K < flights.size(); K++) {
			String minorHour = flights.get(K).getDepartureTime();
			int minorPosition = K;
			
			String[] separateMoment = minorHour.split(" ");
			String[] separateHour = minorHour.split(":");
			String momentOfTheDay = separateMoment[1];
			
			String[] halfHour = separateHour[1].split(" ");
			String minutes = halfHour[0];
			String hourComplete = separateHour[0] + minutes;
			int minorTime = Integer.parseInt(hourComplete);
			
			if(momentOfTheDay.equals("PM")) {
				minorTime = minorTime+1200;
			}
			
			for (int J = K + 1; J < flights.size(); J++) {
				String currentFlight = flights.get(J).getDepartureTime();
				
				String[] separateMoment2 = currentFlight.split(" ");
				String[] separateHour2 = currentFlight.split(":");
				String momentOfTheDay2 = separateMoment2[1];
				
				String[] halfHour2 = separateHour2[1].split(" ");
				String minutes2 = halfHour2[0];
				String hourComplete2 = separateHour2[0] + minutes2;
				int currentHour = Integer.parseInt(hourComplete2);
				
				if(momentOfTheDay2.equals("PM")) {
					currentHour = currentHour+1200;
				}
				
				if (currentHour < minorTime) {
					minorTime = currentHour;
					minorPosition = J;
				}
			}
			Flight temp = flights.get(minorPosition);
			flights.set(minorPosition, flights.get(K));
			flights.set(K, temp);
		
		}		
	}

	public void SortByAirline() {
		for (int i = 0; i < flights.size() - 1; i++) {
			String minorFlight = flights.get(i).getAirline();
			int minorPosition = i;
			for (int j = i + 1; j < flights.size(); j++) {
				String currentFlight = flights.get(j).getAirline();
				if (currentFlight.compareTo(minorFlight) < 0) {
					minorFlight = currentFlight;
					minorPosition = j;
				}
			}
			Flight temp = flights.get(minorPosition);
			flights.set(minorPosition, flights.get(i));
			flights.set(i, temp);
		}
	}

	/*
	 * Ordena los vuelos segun ciudad de destino, ordenamiento por seleccion
	 */
	public void SortByDesnitationCity() {
		for (int I = 0; I < flights.size() - 1; I++) {
			String minorFlight = flights.get(I).getDestinationCity();
			int minorPosition = I;
			for (int J = I + 1; J < flights.size(); J++) {
				String currentFlight = flights.get(J).getDestinationCity();
				if (currentFlight.compareTo(minorFlight) < 0) {
					minorFlight = currentFlight;
					minorPosition = J;
				}
			}
			Flight temp = flights.get(minorPosition);
			flights.set(minorPosition, flights.get(I));
			flights.set(I, temp);
		}
	}

	/*
	 * Organiza los vuelos por puerta embarque, utiliza el metodo burubuja de
	 * ordenamiento
	 */
	public void sortByBoardingGate() {
		for (int I = 0; I < flights.size() - 1; I++) {
			for (int J = 0; J < flights.size() - 1; J++) {
				if (flights.get(J).getBoardingGate() > flights.get(J + 1).getBoardingGate()) {
					Flight tmp = flights.get(J + 1);
					flights.set(J + 1, flights.get(J));
					flights.set(J, tmp);
				}
			}
		}
	}

	/*
	 * El metodo calcula el tiempo que tardó en realizar una búsqueda u ordenamiento
	 */
	public long calculateTime() {
		long time = 0;

		return time;
	}

	/*
	 * El metodo busca en un arreglo un vuelo return el primer Flight encontrado
	 */
	public Flight searchFly(String characteristic) {
		Flight temp = null;
		return temp;
	}

	/*
	 * Organiza los vuelos por identificador, utiliza el metodo de seleccion
	 */
	public void sortByFlightId() {
		for (int i = 0; i < flights.size() - 1; i++) {
			String minorFlight = flights.get(i).getId();
			int minorPosition = i;
			for (int j = i + 1; j < flights.size(); j++) {
				String currentFlight = flights.get(j).getId();
				if (currentFlight.compareTo(minorFlight) < 0) {
					minorFlight = currentFlight;
					minorPosition = j;
				}
			}
			Flight temp = flights.get(minorPosition);
			flights.set(minorPosition, flights.get(i));
			flights.set(i, temp);
		}
	}

}
