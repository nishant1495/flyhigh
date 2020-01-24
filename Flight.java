package com.app.pojos;

import com.app.pojos.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="flights")
public class Flight 
{
	private Integer flightId;
	private String sourceCity;
	private String destinationCity;
	@JsonFormat(pattern = "HH:mm")
	private Date  departureTime;
	@JsonFormat(pattern = "HH:mm")
	private Date arrivalTime;
	private Integer capacity;
	private Integer seatsAvailable;
	private Integer version;
	private Byte isActive=1;
	private Airline airline;
	private Double ticketfare;
	@JsonBackReference
	private List<Reservation> reservationdetails;
	
	public Flight() {
	System.out.println("In Flight pojo");
	}
	

	public Flight(String sourceCity, String destinationCity, Date departureTime, Date arrivalTime, Integer capacity,
			Integer seatsAvailable, Integer version, Byte isActive, Airline airline, Double ticketfare,
			List<Reservation> reservationdetails) {
		super();
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.capacity = capacity;
		this.seatsAvailable = seatsAvailable;
		this.version = version;
		this.isActive = isActive;
		this.airline = airline;
		this.ticketfare = ticketfare;
		this.reservationdetails = reservationdetails;
	}




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getFlightId() {
		return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
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
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(Integer seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	@Version
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	@ManyToOne
	@JoinColumn(name="airline")
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	
	
	public Byte getIsActive() {
		return isActive;
	}
	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}
	public Double getTicketfare() {
		return ticketfare;
	}
	public void setTicketfare(Double ticketfare) {
		this.ticketfare = ticketfare;
	}
	@OneToMany(mappedBy="flight",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	public List<Reservation> getReservationdetails() {
		return reservationdetails;
	}

	public void setReservationdetails(List<Reservation> reservationdetails) {
		this.reservationdetails = reservationdetails;
	}


	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", sourceCity=" + sourceCity + ", destinationCity=" + destinationCity
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", capacity=" + capacity
				+ ", seatsAvailable=" + seatsAvailable + ", version=" + version + ", isActive=" + isActive
				+ ", airline=" + airline + ", ticketfare=" + ticketfare + "]";
	}


	
	
	
	
	
	
}
