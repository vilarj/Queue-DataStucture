package classes;

public class Station {
	private String name;
	private LinkedQueue<Passenger> passengers;
	
	public Station(String name){
		this.name = name;
		this.passengers = new LinkedQueue<Passenger>();
	}
	
	public boolean isNotEmpty() {
		if(!passengers.isEmpty()) {
			return true;
		} 
		
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {return this.name;}
	public String getName() {return this.name;}
	public void passengerArrival(Passenger p) {this.passengers.enqueue(p);}
	public Passenger passengerLeave() {return this.passengers.dequeue();}
}
