package com.booking.system.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flight{
	
public void booktickets() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter passenger 1st name");
		String fname = sc.next();
		System.out.println("Enter passenger last name");
		String lname = sc.next();
		System.out.println("Enter passenger Age");
		int age = sc.nextInt();
		if(age>5) {
			System.out.println("Choose flight destination");
			List<String> li=new ArrayList<String>();  
			li.add("Mumbai");
			li.add("Delhi");
			li.add("Amritsar");
			li.add("Bnagluru");
			li.add("Hydrabad");
			li.add("Lukhnow");
			li.add("Gujrat");
			
			for(String destination : li)
				System.out.println(destination);
			
			String destination = sc.next();
			System.out.println("Enter date when u want to fly");
		     int date = sc.nextInt();
		     if(date < 31) {
		    	   System.out.println("Here are available seats on this flight");
		    	   List<String> li1=new ArrayList<String>();  
					li1.add("051");
					li1.add("032");
					li1.add("014");
					li1.add("035");
					li1.add("006");
					li1.add("011");
					li1.add("023");
					li1.add("018");
					li1.add("010");
					li1.add("012");
					li1.add("098");
					li1.add("034");
					
					for(String Seats: li1)
						System.out.println(Seats);
					int Seats = sc.nextInt();
					System.out.println("Your flight ticket has been booked succesfully!");
					System.out.println("*********************These are your ticket  details******************");
					System.out.println("Passenger " + fname +" "+ lname);
					System.out.println("Flying to " + destination );
					System.out.println("On the date "+ date);
					System.out.println( "On seat no "+ Seats );
					System.out.println("******************Thank you & have a safe journey*********************");
					
					boolean result = FlightDao.insertRecords(fname,lname,age,destination,date,Seats);
					if(result)
						  System.out.println("Inseted into db");
					else
						System.out.println("Not Inserted");
			
						
		     }else {
		    	 System.out.println("Invalid date !");
		    	 
		     }
	
		}else {
			System.out.println(" passenger is below age can't fly ! ");
		}
		
		
	}
	
	
public void availableFlights() {
	   
	List<flightsDetails> flights = FlightDao.getallflightdetails();
	System.out.println("*******************Available flights****************************");
	System.out.println(" ");
	for (flightsDetails f : flights) {
		System.out.println(f);
		
	}
	}

public void Cancleflight() {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("***********************Enter Seat no to cancel reservation******************");
     int seats = sc.nextInt();
	boolean result = FlightDao.CancleFlight(seats);
	if(result) {
		System.out.println("*********Your flight tickets has been Cancled Successfully!***********");
	}else {
		System.out.println("Can't cancel ticket");
	}
	 
	
	
}

public void viewFlightDetails() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Seat no to view ticket details");
	 int seats = sc.nextInt();
	  Flights flgh = FlightDao.viewDetails(seats);
	  if(flgh.getSeats()!=0)
		  System.out.println(flgh);
	  
	 
	
}

public void updatedetials() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Seat no to Update details");
	int seats = sc.nextInt();
	  Flights flgh = FlightDao.viewDetails(seats);
	  System.out.println("What do you want to update ?");
	  System.out.println("1. fname");
	  System.out.println("2. lname");
	  System.out.println("3. age");
	  System.out.println("4. destination");
	  System.out.println("5. date");
	  int update = sc.nextInt();
	  
	  switch(update) {
	  case 1 :
		  System.out.println("Enter new fname");
		        String fname = sc.next();
		         flgh.setFname(fname);
		  break;
	  case 2 :
		  System.out.println("Enter new lname");
	        String lname = sc.next();
	         flgh.setLname(lname);
		  break;
	  case 3 :
		  System.out.println("Enter new age");
	        int age = sc.nextInt();
	         flgh.setAge(age);
		  break;
	  case 4 :
		  System.out.println("Enter new Destination");
	        String destination = sc.next();
	         flgh.setDestination(destination);
		  break;
	  case 5 :
		  System.out.println("Enter new date");
	        int date = sc.nextInt();
	         flgh.setDate(date);
		  break;

	  
	  }
	
	  boolean result = FlightDao.updateDetails(flgh);
	 if(result) {
		  System.out.println("******Your Details has been updated Sucessfully!********");
	 }else {
		 System.out.println("Not Updated");
	 }
	
}
	
}



public class MianClass {

public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("****************************************************************************");
		System.out.println("*********************Welcome to Acscot AirWays****************************");
		System.out.println("****************************************************************************");
		System.out.println(" ");
		System.out.println("***************************Enter your choice********************************");
		System.out.println("************************1.Book flight tickets*******************************");
		System.out.println("************************2.view available flights****************************");
		System.out.println("************************3.Upadte ticket details*****************************");
		System.out.println("************************4.View ticket details*******************************");
		System.out.println("************************5.Cancel flight Ticket******************************");
		System.out.println("********************************6.Exit**************************************");
		
		 int Choice = sc.nextInt();
		 
		 switch(Choice) {
		 
		 case 1:
			   Flight f = new Flight();
			   f.booktickets();
			 break;
		 case 2:
			  Flight f2 = new Flight();
			   f2.availableFlights();
			 break;
		 case 3:
			 Flight f3 = new Flight();
			   f3.updatedetials();;
			 break;
		 case 4:
			 Flight f4 = new Flight();
			 f4.viewFlightDetails();	 
			 break;
		 case 5:
			 Flight f5 = new Flight();
			 f5.Cancleflight();
			 break; 
		 default :
			 System.out.println("Terminated!");
			 break;
		    
		 }
	}

}
