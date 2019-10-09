package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
/**
 * This is the main class of the program
 * @author jimenezc1
 *
 */
public class Route {
	public Station[] stations;
	public int numStations;
	
	public Route(String fileName) {
		
		//Setup stations with names from file
		try {
			File orange = new File("orange.txt");
			Scanner read = new Scanner(orange);
			numStations = 0;
			
			while(read.hasNextLine()) {
				String val = read.nextLine(); // Reading the file
				numStations++;
			}
			
			// Closing the Scanner class
			read.close();
			
			stations = new Station[numStations];
			Scanner read2 = new Scanner(orange);
			int i = 0;
			
			while(read2.hasNextLine()) {
				String name = read2.nextLine();
				stations[i] = new Station(name);
				i++;
			}
			// Closing the Scanner class
			read2.close();
			
		}
		catch (FileNotFoundException ex) {
			System.out.println ("orange.txt not found");
			throw new AssertionError();
		}
		
		// Add passenger to station
		Random rand = new Random();
		int randVal = 0;
		
		for(int i = 0; i < stations.length; i++) {
			randVal = rand.nextInt(5);
			for(int k = 0; k < randVal; k++) {
				Passenger newPass = new Passenger(stations);
				stations[i].passengerArrival(newPass);
			}
		}
		
		// Print each station and their passengers
		for(int i = 0; i < stations.length; i++) {
			// Printing the format from the word document of lab3
			System.out.println("---------------------------");
			System.out.println(stations[i].getName());
			System.out.println(" Passengers:\n");
			
			while(stations[i].isNotEmpty()) {
				Passenger p = stations[i].passengerLeave();
				System.out.println(p);
			}
			
			System.out.println("===========================\n");
		}
	}
}
