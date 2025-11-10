package com.besmartexim.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
