package com.booking.system.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class FlightDao {
		
	  static Connection con = flight_db_connect.connect();
		   	
public static boolean insertRecords(String fname, String lname, int age, String destination, int date, int seats) {
		
		String sql = "insert into flight_details values (?,?,?,?,?,?)";
		
		   try {
			   PreparedStatement ps = con.prepareStatement(sql);
			   ps.setString(1 , fname);
			   ps.setString(2, lname);
			   ps.setInt(3, age);
			   ps.setString(4 , destination);
			   ps.setInt(5, date);
			   ps.setInt(6, seats);
			   int i = ps.executeUpdate();
			   if(i>0) 
				   return true;   
		   }catch(Exception e){
			   e.printStackTrace();
			   
		   }
		
		return false;
	}



public static List< flightsDetails> getallflightdetails() {
		List< flightsDetails> flights = new ArrayList<>();
		try {
			java.sql.Statement stat =  con.createStatement();
			ResultSet rs = stat.executeQuery("select * from Available_flights");
			while (rs.next()) {
			 flightsDetails f = new  flightsDetails();
				f.setFlightno(rs.getInt("flightno"));
				f.setPickup(rs.getString("pickup"));
				f.setDestination(rs.getString("Destination"));
				f.setArrival(rs.getString("Arrival"));
				f.setDeparture(rs.getString("Departure"));
				f.setCost(rs.getInt("cost"));
				flights.add(f);			
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flights;
	}
	
	

public static boolean CancleFlight(int seats) {
		String sql = "delete from flight_details where Seatno=?";
		try {
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setInt(1, seats);
			 int i= ps.executeUpdate();
			 if(i>0)
				 return true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return false;
	}
	

public static Flights viewDetails(int seats) {
	Flights f = null;
	try {
		 PreparedStatement ps = con.prepareStatement("select * from flight_details where Seatno=?");
		 ps.setInt(1, seats);
		 ResultSet rs = ps.executeQuery();
		 f= new Flights();
		 rs.next();
		 f.setFname(rs.getString("fname"));
		 f.setLname(rs.getString("lname"));
		 f.setAge(rs.getInt("age"));
		 f.setDestination(rs.getString("destination"));
		 f.setDate(rs.getInt("date"));
		 f.setSeats(rs.getInt("Seatno"));
		 
		 
		 
	}catch(Exception e) {
		
	}
	
		return f;
	}



public static boolean updateDetails(Flights flgh) {
	String sql = "update flight_details set fname=? , lname=?, age=?, destination=? , date=? where Seatno=? ";
	
	try {
		 PreparedStatement ps = con.prepareStatement(sql);
		   ps.setString(1 , flgh.getFname());
		   ps.setString(2,  flgh.getLname());
		   ps.setInt(3, flgh.getAge());
		   ps.setString(4 , flgh.getDestination());
		   ps.setInt(5, flgh.getDate());
		   ps.setInt(6, flgh.getSeats());
		   
		   int i = ps.executeUpdate();
		   if(i>0) {
			   return true;
		   }
	}
		catch(Exception e) {
			 e.printStackTrace();
		}
	return false;
}



}
