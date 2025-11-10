package com.besmartexim.dto.response;

import java.util.List;

public class SiteSettingsResponse {

	List<SiteSettingsData> settingsList;

	public List<SiteSettingsData> getSettingsList() {
		return settingsList;
	}

	public void setSettingsList(List<SiteSettingsData> settingsList) {
		this.settingsList = settingsList;
	}

}
