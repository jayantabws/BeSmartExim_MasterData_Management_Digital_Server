package com.besmartexim.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.besmartexim.dto.response.TeamMemberResponse;
import com.besmartexim.service.TeamMemberService;

@CrossOrigin
@RestController
@RequestMapping(path = "/masterdata-management")

public class MstTeamMemberController {

	private static final Logger logger = LoggerFactory.getLogger(MstTeamMemberController.class);

	@Autowired
	private TeamMemberService teamMemberService;

	@GetMapping(value = "/team-member/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> teamMemberList(@RequestHeader(required = true) Long accessedBy)
			throws Exception {
		logger.info("accessedBy = " + accessedBy);

		TeamMemberResponse teamMemberResponse = teamMemberService.teamMemberList();

		return new ResponseEntity<>(teamMemberResponse, HttpStatus.OK);

	}

}
