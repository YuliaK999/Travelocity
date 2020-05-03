package com.travelocity.beans;

public class Flight {
	
		private String departureTime;
		private String arrivalTime;
		private String airline;
		private String rating;
		private String duration;
		private String numberOfStops;
		private String fromAirport;
		private String toAirport;
		private String price;
		private String typeOfTrip;
		
			
		
		public Flight(String departureTime, String arrivalTime, String airline, String rating, String duration,
				String numberOfStops, String fromAirport, String toAirport, String price, String typeOfTrip) {
			super();
			this.departureTime = departureTime;
			this.arrivalTime = arrivalTime;
			this.airline = airline;
			this.rating = rating;
			this.duration = duration;
			this.numberOfStops = numberOfStops;
			this.fromAirport = fromAirport;
			this.toAirport = toAirport;
			this.price = price;
			this.typeOfTrip = typeOfTrip;
		}




		public String getDepartureTime() {
			return departureTime;
		}




		public void setDepartureTime(String departureTime) {
			this.departureTime = departureTime;
		}




		public String getArrivalTime() {
			return arrivalTime;
		}




		public void setArrivalTime(String arrivalTime) {
			this.arrivalTime = arrivalTime;
		}




		public String getAirline() {
			return airline;
		}




		public void setAirline(String airline) {
			this.airline = airline;
		}




		public String getRating() {
			return rating;
		}




		public void setRating(String rating) {
			this.rating = rating;
		}




		public String getDuration() {
			return duration;
		}




		public void setDuration(String duration) {
			this.duration = duration;
		}




		public String getNumberOfStops() {
			return numberOfStops;
		}




		public void setNumberOfStops(String numberOfStops) {
			this.numberOfStops = numberOfStops;
		}




		public String getFromAirport() {
			return fromAirport;
		}




		public void setFromAirport(String fromAirport) {
			this.fromAirport = fromAirport;
		}




		public String getToAirport() {
			return toAirport;
		}




		public void setToAirport(String toAirport) {
			this.toAirport = toAirport;
		}




		public String getPrice() {
			return price;
		}




		public void setPrice(String price) {
			this.price = price;
		}




		public String getTypeOfTrip() {
			return typeOfTrip;
		}




		public void setTypeOfTrip(String typeOfTrip) {
			this.typeOfTrip = typeOfTrip;
		}


		
		
		
		
		

	


}
