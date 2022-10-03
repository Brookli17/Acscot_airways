package com.booking.system.main;

public class Flights{
        private String fname;
        private String lname;
        private int age;
        private String destination;
        private int date;
    	private int Seats;
    	
        public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public int getDate() {
			return date;
		}

		public void setDate(int date) {
			this.date = date;
		}

		public int getSeats() {
			return Seats;
		}

		public void setSeats(int seats) {
			Seats = seats;
		}

		@Override
		public String toString() {
			return "******************Ticket details********************"+ "\n"+
		          "Passenger" +" " +fname  +" "+lname + " Whose age is "+ age + "\n"+
		            "Flying to " + destination + "\n" 
		            +"On the date " + date+" " + "Whose Seat no is " + Seats +"\n"
		            +"******************THANK YOU*************************";
			
		
		}

	
        
        
        
        
}
