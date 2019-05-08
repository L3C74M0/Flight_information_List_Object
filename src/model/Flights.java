package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Flights {
	private Flight first;
	private String[] cities;
	private String[] airlines;
	private final static String CITIES_FILE = "resourses/cities.txt";
	private final static String AIRLINES_FILE = "resourses/airlines.txt";

	public Flights(Flight first) throws IOException {
		this.first=first;
		cities = new String[10];
		airlines = new String[10];

		loadCities(CITIES_FILE);
		loadAirlines(AIRLINES_FILE);
	}
	
	public Flight getFlights() {
		return first;
	}
	
	public Flight generateFlightsList(int value) {
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
			addFly(temp);
		}
		return first;
	}

	public void sortByDate() {
		
	}
	
	
	public void sortByDeparture() {	
		for (int K = 0; K < getSize(); K++) {
			String minorHour = getFlight(K).getDepartureTime();
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
			
			for (int J = K + 1; J < getSize(); J++) {
				String currentFlight = getFlight(J).getDepartureTime();
				
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
		}		
	}


	public void SortByAirline() {
		for (int i = 0; i < getSize() ; i++) {
			String minorFlight = getFlight(i).getAirline();
			int minorPosition = i;
			for (int j = i + 1; j < getSize(); j++) {
				String currentFlight = getFlight(j).getAirline();
				if (currentFlight.compareTo(minorFlight) < 0) {
					minorFlight = currentFlight;
					minorPosition = j;
				}
			}
		}
	}

	public void SortByDesnitationCity() {
		if (getSize() > 1) {
			Flight current = first;
			//Flight temp;
			
			while(current.getNext() != null) {
				Flight higherFlight = current;
				if(current.getDestinationCity().compareTo(current.getNext().getDestinationCity()) > 0) {
					
				}
			}
			
			for (int i = 0; i < getSize(); i++) {
				String minorFlight = getFlight(i).getId();
				int minorPosition = i;
				for (int j = i + 1; j < getSize(); j++) {
					String currentFlight = getFlight(j).getId();
					if (currentFlight.compareTo(minorFlight) < 0) {
						minorFlight = currentFlight;
						minorPosition = j;
					}
				}
				
			}
			
			/**Flight inf;
			while (current != null) {
				temp = current.getNext();
				while (temp != null) {
					if (current.getDestinationCity().compareTo(temp.getDestinationCity()) < 0) {
						inf = temp;
						temp = current;
						current = inf;
					}
					temp = temp.getNext();
				}
				current = current.getNext();
				
			}
		
			if (current.getDestinationCity().compareTo(current.getNext().getDestinationCity()) > 0) {
				temp = current;
				current.setNext(current.getNext());
				current.setNext(temp);
			}
			current = current.getNext();
			first = first.getNext();
		*/
		}
	}	

	public void sortByBoardingGate() {
		for (int I = 0; I < getSize(); I++) {
			for (int J = 0; J < getSize(); J++) {
				if (getFlight(J).getBoardingGate() > getFlight(J + 1).getBoardingGate()) {
					
				}
			}
		}
	}

	public void sortByFlightId() {
		for (int i = 0; i < getSize(); i++) {
			String minorFlight = getFlight(i).getId();
			int minorPosition = i;
			for (int j = i + 1; j < getSize(); j++) {
				String currentFlight = getFlight(j).getId();
				if (currentFlight.compareTo(minorFlight) < 0) {
					minorFlight = currentFlight;
					minorPosition = j;
				}
			}
			
		}
	}	

	public long calculateTime(long delayedTime) {

		long timeRelease = System.currentTimeMillis();
		long timeElapsed = timeRelease - delayedTime;
		return timeElapsed;
	}

	public Flight searchFly(String characteristic) throws NumberFormatException{

		Flight temp = null;
		try {
			int value = Integer.parseInt(characteristic);
			if (value < 1000) {
				int boardingGate = value;
				if (searchByBoardingGate(boardingGate) != -1) {
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
		return temp;
	}
	
	public int searchByBoardingGate(int boardingGate) {		
		int valueToLookFor = boardingGate;
		int start = 0;
		int end = getSize();
		int position;

		while (start <= end) {
			position = (start + end) / 2;

			if (getFlight(position).getBoardingGate() == valueToLookFor) {
				return position;
			} else if (valueToLookFor > getFlight(position).getBoardingGate()) {
				start = position + 1;
			} else {
				end = position - 1;
			}
		}
		return -1;
	}
	
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
	
	public Flight getFirst() {

		return first;
	}

	public void setFirst(Flight first) {
		this.first = first;
	}
	
	public void addFly(Flight toAdd) {
		if (first == null) {
			first = toAdd;
			first.setNext(null);
		} else {
			Flight current = first;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(toAdd);
			toAdd.setNext(null);
		}
	}

	public Flight getFlight(int position) {
		if(position==0) {
			return first;
		}else {
			Flight current = first;
			for (int i = 0; i < position; i++) {
                current = current.getNext();
            }
			return current;
		}
	}
	
	public int getSize() {
		int amountFlights = 1;
		if (first == null) {
			return 0;
		} else {
			Flight current = first;
			while (current.getNext() != null) {
				current = current.getNext();
				amountFlights++;
			}
			return amountFlights;
		}
	}
}