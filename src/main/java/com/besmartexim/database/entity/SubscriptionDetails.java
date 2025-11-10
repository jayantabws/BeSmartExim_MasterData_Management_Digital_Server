package com.besmartexim.database.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subscription_details")
public class SubscriptionDetails {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "subscription_id")
	private Long subscriptionid;

	@Column(name = "short_key")
	private String short_key;

	@Column(name = "key_fullform")
	private String key_fullform;

	@Column(name = "key_desc")
	private String key_desc;

	@Column(name = "key_value")
	private String key_value;

	@Column(name = "value_desc")
	private String value_desc;

	@Column(name = "created_by")
	private Long created_by;

	@Column(name = "created_date")
	private Date created_date;

	@Column(name = "modified_by")
	private Long modified_by;

	@Column(name = "modified_date")
	private Date modified_date;

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

	public String getShort_key() {
		return short_key;
	}

	public void setShort_key(String short_key) {
		this.short_key = short_key;
	}

	public String getKey_fullform() {
		return key_fullform;
	}

	public void setKey_fullform(String key_fullform) {
		this.key_fullform = key_fullform;
	}

	public String getKey_desc() {
		return key_desc;
	}

	public void setKey_desc(String key_desc) {
		this.key_desc = key_desc;
	}

	public String getKey_value() {
		return key_value;
	}

	public void setKey_value(String key_value) {
		this.key_value = key_value;
	}

	public String getValue_desc() {
		return value_desc;
	}

	public void setValue_desc(String value_desc) {
		this.value_desc = value_desc;
	}

	public Long getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Long created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Long getModified_by() {
		return modified_by;
	}

	public void setModified_by(Long modified_by) {
		this.modified_by = modified_by;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

}
