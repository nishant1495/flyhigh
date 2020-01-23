package com.app.pojos;

import com.app.pojos.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="flights")
public class Flight 
{
	private Integer flightId;
	private String sourceCity;
	private String destinationCity;
	@DateTimeFormat(pattern = "HH:mm")
	private Date  departureTime;
	@DateTimeFormat(pattern = "HH:mm")
	private Date arrivalTime;
	private Integer capacity;
	private Integer seatsAvailable;
	private Integer version;
	private Byte isActive=1;
	private Airline airline;
	
	public Flight() {
	System.out.println("In Flight pojo");
	}
	
	public Flight(String sourceCity, String destinationCity, Date departureTime, Date arrivalTime, Integer capacity,
			Integer seatsAvailable, Integer version, Byte isActive, Airline airline) 
	{
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.capacity = capacity;
		this.seatsAvailable = seatsAvailable;
		this.version = version;
		this.isActive = isActive;
		this.airline = airline;
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
	
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", sourceCity=" + sourceCity + ", destinationCity=" + destinationCity
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", capacity=" + capacity
				+ ", seatsAvailable=" + seatsAvailable + ", airline=" + airline + "]";
	}
	
	
	
	
	
}
