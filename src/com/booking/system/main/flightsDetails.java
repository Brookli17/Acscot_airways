package com.booking.system.main;

public class flightsDetails {
	
	private int flightno;
	private String pickup;
	private String Destinnation;
	private String Arrival;
	private String Departure;
	private int cost;
	

	public int getFlightno() {
		return flightno;
	}


	public void setFlightno(int flightno) {
		this.flightno = flightno;
	}


	public String getPickup() {
		return pickup;
	}


	public void setPickup(String pickup) {
		this.pickup = pickup;
	}


	public String getDestinnation() {
		return Destinnation;
	}


	public void setDestination(String destinnation) {
		Destinnation = destinnation;
	}


	public String getArrival() {
		return Arrival;
	}


	public void setArrival(String arrival) {
		Arrival = arrival;
	}


	public String getDeparture() {
		return Departure;
	}


	public void setDeparture(String departure) {
		Departure = departure;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}



	@Override
	public String toString() {
		return "**********************************************************************"+"\n"
				+"flightno=" + flightno + ", pickup=" + pickup + ", Destinnation=" + Destinnation+"\n"
				+ "Arrival=" + Arrival + ", Departure=" + Departure + ", cost=" + cost +"\n"
				+"*********************************************************************"+
				"                                                                          ";
		       
	}


	public static void main(String[] args) {
		
		

	}


	

}
