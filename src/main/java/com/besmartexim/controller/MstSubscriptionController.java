package com.besmartexim.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.besmartexim.dto.request.MstSubscriptionRequest;
import com.besmartexim.dto.request.SubscriptionListRequest;
import com.besmartexim.dto.response.MstSubscriptionResponse;
import com.besmartexim.dto.response.Subscription;
import com.besmartexim.service.MstSubscriptionService;

@CrossOrigin
@RestController
@RequestMapping(path="/masterdata-management")
public class MstSubscriptionController {
	
	private static final Logger logger = LoggerFactory.getLogger(MstSubscriptionController.class);
	
	@Autowired
	private MstSubscriptionService mstSubscriptionService;
	
	@RequestMapping(value = "/subscription", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> subscriptionCreate(@RequestBody  @Valid MstSubscriptionRequest mstSubscriptionRequest, @RequestHeader(value="accessedBy", required=true) Long accessedBy ) throws Exception{
		logger.info("Request : /masterdata-management/subscription");
		mstSubscriptionService.subscriptionCreate(mstSubscriptionRequest, accessedBy);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/subscription/{subscriptionId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity subscriptionUpdate(@RequestBody  @Valid MstSubscriptionRequest mstSubscriptionRequest,@PathVariable Long subscriptionId,@RequestHeader(value="accessedBy", required=true) Long accessedBy ) throws Exception{
		logger.info("accessedBy = "+accessedBy);
			
		mstSubscriptionService.subscriptionUpdate(mstSubscriptionRequest,subscriptionId,accessedBy);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/subscription/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity subscriptionList(@RequestParam(required=false) String isCustom, @RequestParam(required=false) String isActive, @RequestHeader(value="accessedBy", required=true) Long accessedBy ) throws Exception{
			
		logger.info("accessedBy = "+accessedBy);
			
		MstSubscriptionResponse mstSubscriptionResponse = mstSubscriptionService.subscriptionList(isCustom,isActive,accessedBy);
		
		return new ResponseEntity<>(mstSubscriptionResponse, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/subscription/{subscriptionId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity subscriptionList(@PathVariable Long subscriptionId, @RequestHeader(value="accessedBy", required=true) Long accessedBy ) throws Exception{
		logger.info("/subscription/{subscriptionId}");	
		logger.info("accessedBy = "+accessedBy);
			
		Subscription subscription = mstSubscriptionService.getSubscriptionDetails(subscriptionId,accessedBy);
		
		return new ResponseEntity<>(subscription, HttpStatus.OK);
		
	}

}
