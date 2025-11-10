package com.besmartexim.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subscription_countries")

public class SubscriptionCountries {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "subscription_id")
	private Long subscriptionid;

	@Column(name = "country_id")
	private String country_id;

	@Column(name = "continent_id")
	private String continent_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSubscriptionid() {
		return subscriptionid;
	}

	public void setSubscriptionid(Long subscriptionid) {
		this.subscriptionid = subscriptionid;
	}

	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public String getContinent_id() {
		return continent_id;
	}

	public void setContinent_id(String continent_id) {
		this.continent_id = continent_id;
	}

}
