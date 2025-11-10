package com.besmartexim.dto.response;

public class SiteSettingsData {

	private Long id;

	private String isMaintanance;

	private String siteMessage;

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

}
