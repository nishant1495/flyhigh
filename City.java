package com.app.pojos;
import com.app.pojos.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="cities")
public class City 
{
	private Integer cityId;
	private String cityName;
	@JsonIgnore
	private State state;
	
	public City() {
	System.out.println("In City Constructor");
	}

	public City(Integer cityid, String cityName, State state) {
		super();
		this.cityName = cityName;
		this.state = state;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCityid() {
		return cityId;
	}

	public void setCityid(Integer cityid) {
		this.cityId = cityid;
	}

	public String getCityname() {
		return cityName;
	}

	public void setCityname(String cityname) {
		this.cityName = cityname;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="stateid")
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
}
