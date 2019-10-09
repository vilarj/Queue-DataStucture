package classes;

import java.util.Random;
public class Passenger {
	private int id;
	private Station destination;

	public Passenger(Station[] stations) {
		destination = getRandomStation(stations);
		id = getRandomID();
	}

	private Station getRandomStation(Station[] stations) {
		Random random = new Random();
		int station_val = random.nextInt(stations.length);
		
		return stations[station_val];
	}
	
	public int getRandomID() {
		id = (int) (50000 * Math.random());
		return id;
	}
	
	@Override
	public String toString() {
		return String.format("%d, %s",this.id,this.destination.toString());
	}
}
