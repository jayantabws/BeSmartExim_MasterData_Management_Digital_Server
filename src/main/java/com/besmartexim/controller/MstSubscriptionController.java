package com.besmartexim.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.besmartexim.dto.request.MstSubscriptionRequest;
import com.besmartexim.dto.response.FullSubscription;
import com.besmartexim.dto.response.MstSubscriptionResponse;
import com.besmartexim.dto.response.Subscription;
import com.besmartexim.service.MstSubscriptionService;

@CrossOrigin
@RestController
@RequestMapping(path = "/masterdata-management")
public class MstSubscriptionController {

	private static final Logger logger = LoggerFactory.getLogger(MstSubscriptionController.class);

	@Autowired
	private MstSubscriptionService mstSubscriptionService;

	@PostMapping(value = "/subscription", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> subscriptionCreate(@RequestBody @Valid MstSubscriptionRequest mstSubscriptionRequest,
			@RequestHeader(required = true) Long accessedBy) throws Exception {
		logger.info("Request : /masterdata-management/subscription create");
		mstSubscriptionService.subscriptionCreate(mstSubscriptionRequest, accessedBy);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping(value = "/subscription/{subscriptionId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> subscriptionUpdate(@RequestBody @Valid MstSubscriptionRequest mstSubscriptionRequest,
			@PathVariable Long subscriptionId, @RequestHeader(required = true) Long accessedBy) throws Exception {
		logger.info("Request : /masterdata-management/subscription Update");
		logger.info("accessedBy = " + accessedBy);
		String msg = null;

		if (subscriptionId > 0) {
			msg = mstSubscriptionService.subscriptionUpdate(mstSubscriptionRequest, subscriptionId, accessedBy);
		} else {
			msg = "Invalid subscription Id";
		}
		return ResponseEntity.ok(msg);

	}

	@GetMapping(value = "/subscription/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MstSubscriptionResponse> subscriptionList(@RequestParam(required = false) String isCustom,
			@RequestParam(required = false) String isActive, @RequestHeader(required = true) Long accessedBy)
			throws Exception {
		logger.info("Request : /masterdata-management/subscriptions list");
		logger.info("accessedBy = " + accessedBy);

		MstSubscriptionResponse mstSubscriptionResponse = mstSubscriptionService.subscriptionList(isCustom, isActive,
				accessedBy);

		return new ResponseEntity<MstSubscriptionResponse>(mstSubscriptionResponse, HttpStatus.OK);

	}

	@GetMapping(value = "/subscription/{subscriptionId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Subscription> subscriptionList(@PathVariable Long subscriptionId,
			@RequestHeader(required = true) Long accessedBy) throws Exception {
		logger.info("/subscription/{subscriptionId}  => get subscription");
		logger.info("accessedBy = " + accessedBy);

		Subscription subscription = mstSubscriptionService.getSubscriptionDetails(subscriptionId, accessedBy);

		return new ResponseEntity<Subscription>(subscription, HttpStatus.OK);

	}

	@GetMapping(value = "/subscription/full/{subscriptionId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FullSubscription> getFullSubscriptionDetails(@PathVariable Long subscriptionId,
			@RequestHeader(required = true) Long accessedBy) throws Exception {
		logger.info("/subscription/full/{subscriptionId} => get full subscription");

		FullSubscription subscription = mstSubscriptionService.getFullSubscriptionDetails(subscriptionId, accessedBy);

		return new ResponseEntity<FullSubscription>(subscription, HttpStatus.OK);

	}

}
