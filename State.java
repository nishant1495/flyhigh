package com.app.pojos;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="states")
public class State 
{
	private Integer stateId;
	private String stateName;
	private Country country;
	@JsonIgnore
	private List<City> citieslist;
	
	public State() {
	System.out.println("In State Constructor");
	}
	
	public State(String stateName, Country country, List<City> citieslist) {
		super();
		this.stateName = stateName;
		this.country = country;
		this.citieslist = citieslist;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getStateid() {
		return stateId;
	}

	public void setStateid(Integer stateid) {
		this.stateId = stateid;
	}

	public String getStatename() {
		return stateName;
	}

	public void setStatename(String statename) {
		this.stateName = statename;
	}

	@ManyToOne
	@JoinColumn(name="countryId")
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@OneToMany(mappedBy="state",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	public List<City> getCitieslist() {
		return citieslist;
	}

	public void setCitieslist(List<City> citieslist) {
		this.citieslist = citieslist;
	}
	
	
	
}
