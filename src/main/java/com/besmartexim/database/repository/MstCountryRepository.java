package com.besmartexim.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.besmartexim.database.entity.MstCountry;

@Repository
public interface MstCountryRepository extends JpaRepository<MstCountry, Long> {
	
	List<MstCountry> findByIsExportAndIsActive(String trade_type,String isActive);
	List<MstCountry> findByIsImportAndIsActive(String trade_type,String isActive);
	List<MstCountry> findByIsActiveOrderByIdDesc(String isActive);

}
