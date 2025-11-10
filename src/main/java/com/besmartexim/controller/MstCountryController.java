package com.besmartexim.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.besmartexim.dto.request.MstCountryRequest;
import com.besmartexim.dto.response.CountryByContinentResponse;
import com.besmartexim.dto.response.MstCountryResponse;
import com.besmartexim.service.MstCountryService;

@CrossOrigin
@RestController
@RequestMapping(path = "/masterdata-management")
public class MstCountryController {

	private static final Logger logger = LoggerFactory.getLogger(MstCountryController.class);

	@Autowired
	private MstCountryService mstCountryService;

	@RequestMapping(value = "/country", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> countryCreate(@RequestBody @Valid MstCountryRequest mstCountryRequest,
			@RequestHeader(value = "accessedBy", required = true) Long accessedBy) throws Exception {
		logger.info("Request : /masterdata-management/country");
		mstCountryService.countryCreate(mstCountryRequest, accessedBy);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/country/{countryId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity countryUpdate(@RequestBody @Valid MstCountryRequest mstCountryRequest,
			@PathVariable Long countryId, @RequestHeader(value = "accessedBy", required = true) Long accessedBy)
			throws Exception {
		logger.info("accessedBy = " + accessedBy);

		mstCountryService.countryUpdate(mstCountryRequest, countryId, accessedBy);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@RequestMapping(value = "/country/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity countryList(@RequestHeader(value = "accessedBy", required = true) Long accessedBy)
			throws Exception {
		logger.info("accessedBy = " + accessedBy);

		MstCountryResponse mstCountryResponse = mstCountryService.countryList();

		return new ResponseEntity<>(mstCountryResponse, HttpStatus.OK);

	}

	@RequestMapping(value = "/countrylistbytrade/{tradeType}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity countryListByTrade(@PathVariable String tradeType,
			@RequestHeader(value = "accessedBy", required = true) Long accessedBy) throws Exception {
		logger.info("accessedBy = " + accessedBy);

		MstCountryResponse mstCountryResponse = mstCountryService.countryListByTrade(tradeType, accessedBy);

		return new ResponseEntity<>(mstCountryResponse, HttpStatus.OK);

	}

	@RequestMapping(value = "/countrylistbycontinent/{tradeType}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> countryListByContinent(@PathVariable String tradeType,
			@RequestHeader(value = "accessedBy", required = true) Long accessedBy) throws Exception {
		logger.info("url = countrylistbycontinent accessedBy= " + accessedBy);

		List<CountryByContinentResponse> countryResponse = mstCountryService.countryListContinentWise(tradeType);

		return new ResponseEntity<>(countryResponse, HttpStatus.OK);

	}

}
