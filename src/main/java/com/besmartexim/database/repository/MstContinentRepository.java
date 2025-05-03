package com.besmartexim.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.besmartexim.database.entity.MstContinent;


@Repository
public interface MstContinentRepository extends JpaRepository<MstContinent, Long> {

}
