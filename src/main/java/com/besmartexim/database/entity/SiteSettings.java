package com.besmartexim.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "site_settings")
public class SiteSettings {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "is_maintanance")
	private String isMaintanance;

	@Column(name = "site_message")
	private String siteMessage;
	
	@Column(name = "site_msg")
	private String loginMsg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsMaintanance() {
		return isMaintanance;
	}

	public void setIsMaintanance(String isMaintanance) {
		this.isMaintanance = isMaintanance;
	}

	public String getSiteMessage() {
		return siteMessage;
	}

	public void setSiteMessage(String siteMessage) {
		this.siteMessage = siteMessage;
	}

	public String getLoginMsg() {
		return loginMsg;
	}

	public void setLoginMsg(String loginMsg) {
		this.loginMsg = loginMsg;
	}

}
