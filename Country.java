package com.app.pojos;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="countries")
public class Country 
{
	private Integer countryId;
	private String countryCode;
	private String countryName;
	@JsonIgnore
	private List<State> statelist;
	
	public Country() {
	System.out.println("In Country Pojo");
	}

	public Country(String countryCode, String countryName) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@OneToMany(mappedBy="country",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	public List<State> getStatelist() {
		return statelist;
	}

	public void setStatelist(List<State> statelist) {
		this.statelist = statelist;
	}
	
}
