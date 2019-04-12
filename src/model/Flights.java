package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Flights {
	private ArrayList<Flight> flights;
	private String[] cities;
	private String[] airlines;
	private final static String CITIES_FILE = "resourses/cities.txt";
	private final static String AIRLINES_FILE = "resourses/airlines.txt";

	public Flights(ArrayList<Flight> flights) throws IOException {
		this.flights = flights;
		cities = new String[10];
		airlines = new String[10];

		loadCities(CITIES_FILE);
		loadAirlines(AIRLINES_FILE);
	}
	/**
	 * the method returns an arrangement of flights
	 * @return
	 */
	public ArrayList<Flight> getFlights() {
		return flights;
	}


	/**
	 * The method generates a list of flights randomly return ArrayList <Flight>
	 * @param value
	 * @return
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
	 * The method organizes flights by date
	 */
	public void sortByDate() {
		Collections.sort(flights,new DateAndTimeComparator());
	}
	
	/**
	 * The method organizes flights by departure time
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
	/**
	 * The method organizes flights by airline
	 */
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
	 * The method organizes flights by destination city
	 */
	public void SortByDesnitationCity() {
		Collections.sort(flights);
	}

	/*
	 * The method organizes flights by boarding gate
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
	 * The method organizes flights by identifier
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
	
	/**
	 * The method calculates the time it took to perform a search or order
	 * @param delayedTime
	 * @return
	 */
	public long calculateTime(long delayedTime) {
		long timeRelease = System.currentTimeMillis();
		long timeElapsed = timeRelease - delayedTime;
		return timeElapsed;
	}

	/**
	 * The method looks for in a fix a flight return the first Flight found
	 * @param characteristic
	 * @return
	 * @throws NumberFormatException
	 */
	public Flight searchFly(String characteristic) throws NumberFormatException{
		Flight temp = null;
		try {
			int value = Integer.parseInt(characteristic);
			if (value < 1000) {
				int boardingGate = value;
				if (searchByBoardingGate(boardingGate) != -1) {
					temp = flights.get(boardingGate);
				}
			} else {
				System.out.println("Es identificador");		
			}
		}catch (Exception e){
			if(characteristic.equalsIgnoreCase("")) {
				throw new NumberFormatException();
			}else {
				System.out.println("Es String");
			}
		}
		flights.clear();
        flights.add(temp);
		return temp;
	}
	/**
	 * The method searches for the first flight, by boarding gate, uses a biannier search
	 * @param boardingGate
	 * @return 
	 */
	public int searchByBoardingGate(int boardingGate) {		
		int valueToLookFor = boardingGate;
		int start = 0;
		int end = flights.size() - 1;
		int position;

		while (start <= end) {
			position = (start + end) / 2;

			if (flights.get(position).getBoardingGate() == valueToLookFor) {
				return position;
			} else if (valueToLookFor > flights.get(position).getBoardingGate()) {
				start = position + 1;
			} else {
				end = position - 1;
			}
		}
		return -1;
	}
	/**
	 * The method loads a list of cities from a text file
	 * @param path
	 * @throws IOException
	 */
	public void loadCities(String path) throws IOException {
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		String line = br.readLine();
		while (line != null) {
			cities = line.split(" ");
			line = br.readLine();
		}
		br.close();
		fr.close();
	}
	/**
	 * The method loads a list of airlines from a text file
	 * @param path
	 * @throws IOException
	 */
	public void loadAirlines(String path) throws IOException {
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		String line = br.readLine();
		while (line != null) {
			airlines = line.split(" ");
			line = br.readLine();
		}
		br.close();
		fr.close();
	}
}
