package com.besmartexim.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.besmartexim.database.entity.SiteSettings;
import com.besmartexim.dto.response.SiteSettingsResponse;
import com.besmartexim.service.SiteSettingsService;

@CrossOrigin
@RestController
@RequestMapping(path = "/masterdata-management")
public class SiteSettingsController {

	private static final Logger logger = LoggerFactory.getLogger(SiteSettingsController.class);

	@Autowired
	private SiteSettingsService siteSettingsService;

	@RequestMapping(value = "/sitesettings", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> siteSettings() throws Exception {
		logger.info("Request : /masterdata-management/sitesettings");
		SiteSettingsResponse siteSettingsResponse = siteSettingsService.settingsList();
		return new ResponseEntity<>(siteSettingsResponse, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/updatesitesetting", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateSiteSettingsMsg(@RequestBody(required = true) @Valid SiteSettings siteSettings, 
			@RequestHeader(required = true) Long accessedBy) throws Exception {
		logger.info("Request : /masterdata-management/updatesitemsg");
		String msg = null;
		
		if(siteSettings.getId() == null)
			msg = "Invalid ID for Update";
		else {
			Long count = this.siteSettingsService.updateSiteSettings(siteSettings);
			if(count > 0)
				msg = "Site Settings are Updated";
			else
				msg = "Not Update, Please try again";
		}
		
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	
	

}
