package com.besmartexim.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.besmartexim.database.entity.TeamMembers;
import com.besmartexim.database.repository.TeamMemberRepository;

import com.besmartexim.dto.response.TeamMember;
import com.besmartexim.dto.response.TeamMemberResponse;

@Service
public class TeamMemberService {
	
	@Autowired
	private TeamMemberRepository teamMemberRepository;

	public TeamMemberResponse teamMemberList() throws Exception{
		
		
		TeamMemberResponse teamMemberResponse = new TeamMemberResponse();
		
		List<TeamMembers> srclist = teamMemberRepository.findAllByOrderByIdDesc();
		
		List<TeamMember> targetList = new ArrayList<TeamMember>();
		
		if(null!=srclist && !srclist.isEmpty()) {
			
			for(TeamMembers teamMembers:srclist) {
				TeamMember  tm= new TeamMember();
				BeanUtils.copyProperties(teamMembers, tm);		
				targetList.add(tm);
			}
		}
		
		teamMemberResponse.setTemMemberList(targetList);
		
		return teamMemberResponse;
	}

}
