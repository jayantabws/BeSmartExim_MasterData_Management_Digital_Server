package com.besmartexim.dto.response;

import java.util.List;
import java.util.Map;

import com.besmartexim.dto.request.KeyObject;

public class FullSubscription {
	
	
	// Properties from mst_subscription table...........
	private Long id;

	private String name;

	private String description;

	private Long price;

	private Integer validityInDay;

	private String isCustom;

	private String isActive;
	
	private String indepthAccess;
	
	
	// Properties from subscription_countries table...........
	private List<String> countryId;

	private List<String> continentId;
	
	

	// Properties from subscription_details table...........
	
	private Map<String, KeyObject> OtherAttributes;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Long getPrice() {
		return price;
	}



	public void setPrice(Long price) {
		this.price = price;
	}



	public Integer getValidityInDay() {
		return validityInDay;
	}



	public void setValidityInDay(Integer validityInDay) {
		this.validityInDay = validityInDay;
	}



	public String getIsCustom() {
		return isCustom;
	}



	public void setIsCustom(String isCustom) {
		this.isCustom = isCustom;
	}



	public String getIsActive() {
		return isActive;
	}



	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}



	public String getIndepthAccess() {
		return indepthAccess;
	}



	public void setIndepthAccess(String indepthAccess) {
		this.indepthAccess = indepthAccess;
	}



	public List<String> getCountryId() {
		return countryId;
	}



	public void setCountryId(List<String> countryId) {
		this.countryId = countryId;
	}



	public List<String> getContinentId() {
		return continentId;
	}



	public void setContinentId(List<String> continentId) {
		this.continentId = continentId;
	}



	public Map<String, KeyObject> getOtherAttributes() {
		return OtherAttributes;
	}



	public void setOtherAttributes(Map<String, KeyObject> otherAttributes) {
		OtherAttributes = otherAttributes;
	}
	
	

}