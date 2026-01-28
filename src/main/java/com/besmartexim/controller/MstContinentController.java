package com.besmartexim.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.besmartexim.dto.request.MstContinentRequest;
import com.besmartexim.dto.response.MstContinentResponse;
import com.besmartexim.service.MstContinentService;

@CrossOrigin
@RestController
@RequestMapping(path = "/masterdata-management")
public class MstContinentController {

	private static final Logger logger = LoggerFactory.getLogger(MstContinentController.class);

	@Autowired
	private MstContinentService mstContinentService;

	@PostMapping(value = "/continent", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> continentCreate(@RequestBody @Valid MstContinentRequest mstContinentRequest,
			@RequestHeader(required = true) Long accessedBy) throws Exception {
		logger.info("Request : /masterdata-management/continent");
		mstContinentService.continentCreate(mstContinentRequest, accessedBy);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping(value = "/continent/{continentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> continentUpdate(@RequestBody @Valid MstContinentRequest mstContinentRequest,
			@PathVariable Long continentId, @RequestHeader(required = true) Long accessedBy)
			throws Exception {
		logger.info("accessedBy = " + accessedBy);

		mstContinentService.continentUpdate(mstContinentRequest, continentId, accessedBy);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping(value = "/continent/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> continentList(@RequestHeader( required = true) Long accessedBy)
			throws Exception {
		logger.info("accessedBy = " + accessedBy);

		MstContinentResponse mstContinentResponse = mstContinentService.continentList();

		return new ResponseEntity<>(mstContinentResponse, HttpStatus.OK);

	}

}
