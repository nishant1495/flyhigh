package com.app.pojos;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="airlines")
public class Airline 
{
	private Integer airlineId;
	private String airlineName;
	private AirlineType airlineType;
	@JsonBackReference
	private List<Flight> flightslist;
	
	public Airline() {
	System.out.println("In AirLine Pojo");
	}
	public Airline(String airlineName, List<Flight> flightslist) {
		super();
		this.airlineName = airlineName;
		this.flightslist = flightslist;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(Integer airlineId) {
		this.airlineId = airlineId;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	@OneToMany(mappedBy="airline",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	public List<Flight> getFlightslist() {
		return flightslist;
	}
	public void setFlightslist(List<Flight> flightslist) {
		this.flightslist = flightslist;
	}
	
	public void addFlight(Flight f)
	{
		this.flightslist.add(f);
		f.setAirline(this);
	}
	@Enumerated(EnumType.STRING)
	public AirlineType getAirlineType() {
		return airlineType;
	}
	public void setAirlineType(AirlineType airlineType) {
		this.airlineType = airlineType;
	}
	
	@Override
	public String toString() {
		return "Airline [airlineId=" + airlineId + ", airlineName=" + airlineName + ", airlineType=" + airlineType
				+ "]";
	}
	
	
	
	
}
