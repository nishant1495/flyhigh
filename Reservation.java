package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

@Entity
@Table(name="reservations")
public class Reservation 
{
	private Integer pnr;
	private String passengerName;
	private Integer noOfPassengers;
	private String sourceCity;
	private String destinationCity;
	@JsonFormat(pattern = "HH:mm",timezone="Etc/GMT+12")
	private Date departureTime;
	@JsonFormat(pattern = "HH:mm")
	private Date arrivalTime;
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date dateOfJourney;
	private Double ticketfare;
	private Flight flight;
	private Users user;
	
	public Reservation() {
	System.out.println("In Reservation Pojo");
	}
	
	
	public Reservation(String passengerName, Integer noOfPassengers, String sourceCity, String destinationCity,
			Date departureTime, Date arrivalTime, Date dateOfJourney, Double ticketfare, Flight flight, Users user) {
		super();
		this.passengerName = passengerName;
		this.noOfPassengers = noOfPassengers;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.dateOfJourney = dateOfJourney;
		this.ticketfare = ticketfare;
		this.flight = flight;
		this.user = user;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getPnr() {
		return pnr;
	}
	public void setPnr(Integer pnr) {
		this.pnr = pnr;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public String getSourceCity() {
		return sourceCity;
	}
	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	@Temporal(TemporalType.TIME)
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	@Temporal(TemporalType.TIME)
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	@Temporal(TemporalType.DATE)
	public Date getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
	public Double getTicketfare() {
		return ticketfare;
	}
	public void setTicketfare(Double ticketfare) {
		this.ticketfare = ticketfare;
	}
	
	@ManyToOne
	@JoinColumn(name="flightId")
	public Flight getFlight() {
		return flight;
	}


	public void setFlight(Flight flight) {
		this.flight = flight;
	}


	@ManyToOne
	@JoinColumn(name="userId")
	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Reservation [pnr=" + pnr + ", passengerName=" + passengerName + ", noOfPassengers=" + noOfPassengers
				+ ", sourceCity=" + sourceCity + ", destinationCity=" + destinationCity + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", dateOfJourney=" + dateOfJourney + ", ticketfare="
				+ ticketfare + ", flight=" + flight + ", user=" + user + "]";
	}
	
	
	
}
