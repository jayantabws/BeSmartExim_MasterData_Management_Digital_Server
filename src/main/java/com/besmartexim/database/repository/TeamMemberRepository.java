package com.besmartexim.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.besmartexim.database.entity.TeamMembers;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMembers, Long> {

	List<TeamMembers> findAllByOrderByIdDesc();

}
