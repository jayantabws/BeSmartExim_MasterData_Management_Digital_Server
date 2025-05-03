package com.besmartexim.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.besmartexim.database.entity.SiteSettings;
import com.besmartexim.database.repository.SiteSettingsRepository;
import com.besmartexim.dto.response.SiteSettingsData;
import com.besmartexim.dto.response.SiteSettingsResponse;

@Service
public class SiteSettingsService {
	
	@Autowired
	private SiteSettingsRepository siteSettingsRepository;

	public SiteSettingsResponse settingsList() throws Exception{	
			
		SiteSettingsResponse siteSettingsResponse = new SiteSettingsResponse();
		
		List<SiteSettings> srclist = siteSettingsRepository.findAll();
		
		List<SiteSettingsData> targetList = new ArrayList<SiteSettingsData>();
		
		if(null!=srclist && !srclist.isEmpty()) {
			
			for(SiteSettings siteSettings:srclist) {
				SiteSettingsData  siteSettingsData= new SiteSettingsData();
				BeanUtils.copyProperties(siteSettings, siteSettingsData);		
				targetList.add(siteSettingsData);
			}
		}
	
		siteSettingsResponse.setSettingsList(targetList);
		
		return siteSettingsResponse;
		
	}

}
