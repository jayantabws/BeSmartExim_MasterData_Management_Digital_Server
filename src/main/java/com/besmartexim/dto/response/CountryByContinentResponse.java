package com.besmartexim.dto.response;

import java.util.List;

import com.besmartexim.database.entity.MstCountry;

public class CountryByContinentResponse {

	private Long continentId;
	private String continentName;
	private List<MstCountry> countryList;

	public Long getContinentId() {
		return continentId;
	}

	public void setContinentId(Long continentId) {
		this.continentId = continentId;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public List<MstCountry> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<MstCountry> countryList) {
		this.countryList = countryList;
	}

}
