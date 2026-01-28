package com.besmartexim.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

	@PostMapping(value = "/country", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> countryCreate(@RequestBody @Valid MstCountryRequest mstCountryRequest,
			@RequestHeader(required = true) Long accessedBy) throws Exception {
		logger.info("Request : /masterdata-management/country");
		mstCountryService.countryCreate(mstCountryRequest, accessedBy);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping(value = "/country/{countryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> countryUpdate(@RequestBody @Valid MstCountryRequest mstCountryRequest,
			@PathVariable Long countryId, @RequestHeader(required = true) Long accessedBy)
			throws Exception {
		logger.info("accessedBy = " + accessedBy);

		mstCountryService.countryUpdate(mstCountryRequest, countryId, accessedBy);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping(value = "/country/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> countryList(@RequestHeader(required = true) Long accessedBy)
			throws Exception {
		logger.info("accessedBy = " + accessedBy);

		MstCountryResponse mstCountryResponse = mstCountryService.countryList();

		return new ResponseEntity<>(mstCountryResponse, HttpStatus.OK);

	}

	@GetMapping(value = "/countrylistbytrade/{tradeType}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> countryListByTrade(@PathVariable String tradeType,
			@RequestHeader(required = true) Long accessedBy) throws Exception {
		logger.info("accessedBy = " + accessedBy);

		MstCountryResponse mstCountryResponse = mstCountryService.countryListByTrade(tradeType, accessedBy);

		return new ResponseEntity<>(mstCountryResponse, HttpStatus.OK);

	}

	@GetMapping(value = "/countrylistbycontinent/{tradeType}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> countryListByContinent(@PathVariable String tradeType,
			@RequestHeader(required = true) Long accessedBy) throws Exception {
		logger.info("url = countrylistbycontinent accessedBy= " + accessedBy);

		List<CountryByContinentResponse> countryResponse = mstCountryService.countryListContinentWise(tradeType);

		return new ResponseEntity<>(countryResponse, HttpStatus.OK);

	}

}
