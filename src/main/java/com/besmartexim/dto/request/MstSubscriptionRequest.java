package com.besmartexim.dto.request;

import java.util.List;
import java.util.Map;

public class MstSubscriptionRequest {
	
	private String name;
	
	private String description;
	
	private Long price;
	
	private Integer validityDay;
	
	private String isCustom;
	
	private String isActive;
	
	private List<String> countryId;
	
	private List<String> continentId;
	
	/* private Long dataAccessMonth;
	
	private Long downloadLimit; */
	
	private Map<String, KeyObject> OtherAttributes;
	
	/*
	 * private Long maxDownloadPerDay;
	 * 
	 * private Long workspaceLimit;
	 * 
	 * private String support;
	 * 
	 * private String ticketManager;
	 * 
	 * private Long recordPerWorkspace;
	 * 
	 * private Long subUserCount;
	 * 
	 * private String displayFields;
	 * 
	 * private Long searchQueryPerDay;
	 */



	public String getName() {
		return name;
	}

	public Map<String, KeyObject> getOtherAttributes() {
		return OtherAttributes;
	}

	public void setOtherAttributes(Map<String, KeyObject> otherAttributes) {
		OtherAttributes = otherAttributes;
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



	public Integer getValidityDay() {
		return validityDay;
	}

	public void setValidityDay(Integer validityDay) {
		this.validityDay = validityDay;
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

}