package com.besmartexim.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.besmartexim.database.entity.MstCountry;
import com.besmartexim.database.repository.MstCountryRepository;
import com.besmartexim.dto.request.CountryByTradeRequest;
import com.besmartexim.dto.request.MstCountryRequest;
import com.besmartexim.dto.response.Country;
import com.besmartexim.dto.response.MstCountryResponse;
import com.besmartexim.exception.ServiceException;

@Service
public class MstCountryService {
	
	@Autowired
	private MstCountryRepository mstCountryRepository;
	
	public void countryCreate (MstCountryRequest request, Long accessedBy) throws Exception{
		
		Long continentId = request.getContinentId();
		String isExport = request.getIsExport();
		String isImport = request.getIsImport();
		String name = request.getName();
		String shortcode = request.getShortcode();
		String description = request.getDescription();
		String image = request.getImage();
		String sampleFileImport = request.getSampleFileImport();
		String sampleFileExport = request.getSampleFileExport();
		String isActive = request.getIsActive();
		
		
		MstCountry mstCountryEntity = new MstCountry();
		mstCountryEntity.setContinentId(continentId);
		mstCountryEntity.setIsExport(isExport);
		mstCountryEntity.setIsImport(isImport);
		mstCountryEntity.setName(name);
		mstCountryEntity.setShortcode(shortcode);
		mstCountryEntity.setDescription(description);
		mstCountryEntity.setImage(image);
		mstCountryEntity.setSampleFileImport(sampleFileImport);
		mstCountryEntity.setSampleFileExport(sampleFileExport);
		mstCountryEntity.setIsActive(isActive);
		mstCountryEntity.setExportFrom(request.getExportFrom());
		mstCountryEntity.setExportUpto(request.getExportUpto());
		mstCountryEntity.setExportRecords(request.getExportRecords());
		mstCountryEntity.setImportFrom(request.getImportFrom());
		mstCountryEntity.setImportUpto(request.getImportUpto());
		mstCountryEntity.setImportRecords(request.getImportRecords());
		mstCountryEntity.setImportPointWeightage(request.getImportPointWeightage());
		mstCountryEntity.setExportPointWeightage(request.getExportPointWeightage());
		mstCountryEntity.setExporterForImport(request.getExporterForImport());
		mstCountryEntity.setImporterForExport(request.getImporterForExport());
		mstCountryEntity.setCreatedBy(accessedBy);
		mstCountryEntity.setCreatedDate(new Date());
		
		mstCountryRepository.save(mstCountryEntity);
	}
	
	public void countryUpdate (MstCountryRequest request, Long countryId, Long accessedBy) throws Exception {
		
		MstCountry mstCountryEntity = mstCountryRepository.findById(countryId).get();		
		
		if(mstCountryEntity==null ) {
			throw new ServiceException("Country is not registered");
		}
		else
		{
			if(null!=request.getContinentId()) mstCountryEntity.setContinentId(request.getContinentId());
			if(null!=request.getIsExport()) mstCountryEntity.setIsExport(request.getIsExport());
			if(null!=request.getIsImport()) mstCountryEntity.setIsImport(request.getIsImport());
			if(null!=request.getName()) mstCountryEntity.setName(request.getName());
			if(null!=request.getShortcode()) mstCountryEntity.setShortcode(request.getShortcode());
			if(null!=request.getDescription()) mstCountryEntity.setDescription(request.getDescription());
			if(null!=request.getIsActive()) mstCountryEntity.setIsActive(request.getIsActive());
			if(null!=request.getExportFrom()) mstCountryEntity.setExportFrom(request.getExportFrom());
			if(null!=request.getExportUpto()) mstCountryEntity.setExportUpto(request.getExportUpto());
			if(null!=request.getExportRecords()) mstCountryEntity.setExportRecords(request.getExportRecords());
			if(null!=request.getImportFrom()) mstCountryEntity.setImportFrom(request.getImportFrom());
			if(null!=request.getImportUpto()) mstCountryEntity.setImportUpto(request.getImportUpto());
			if(null!=request.getImportRecords()) mstCountryEntity.setImportRecords(request.getImportRecords());	
			if(null!=request.getImportPointWeightage()) mstCountryEntity.setImportPointWeightage(request.getImportPointWeightage());	
			if(null!=request.getExportPointWeightage()) mstCountryEntity.setExportPointWeightage(request.getExportPointWeightage());	
			if(null!=request.getExporterForImport()) mstCountryEntity.setExporterForImport(request.getExporterForImport());
			if(null!=request.getImporterForExport()) mstCountryEntity.setImporterForExport(request.getImporterForExport());
			
			mstCountryEntity.setModifiedBy(accessedBy);
			mstCountryEntity.setModifiedDate(new Date());
			mstCountryRepository.save(mstCountryEntity);
		}
		
	}
	
	public MstCountryResponse countryList() throws Exception{	
		
		MstCountryResponse mstCountryResponse = new MstCountryResponse();
		
		List<MstCountry> srclist = mstCountryRepository.findByIsActiveOrderByIdDesc("Y");
		
		List<Country> targetList = new ArrayList<Country>();
		
		if(null!=srclist && !srclist.isEmpty()) {
			
			for(MstCountry mstCountry:srclist) {
				Country  country= new Country();
				BeanUtils.copyProperties(mstCountry, country);		
				targetList.add(country);
			}
		}
		
		mstCountryResponse.setCountryList(targetList);
		
		return mstCountryResponse;
			
	}
	
	public MstCountryResponse countryListByTrade(String tradeType,Long accessedBy) throws Exception{	
			
			MstCountryResponse mstCountryResponse = new MstCountryResponse();
			
			List<MstCountry> srclist = null;
			
			if(tradeType.equalsIgnoreCase("I"))
			{
				srclist = mstCountryRepository.findByIsImportAndIsActive("Y","Y");
			}
			else
			{
				srclist = mstCountryRepository.findByIsExportAndIsActive("Y","Y");
			}
			
			
			List<Country> targetList = new ArrayList<Country>();
			
			if(null!=srclist && !srclist.isEmpty()) {
				
				for(MstCountry mstCountry:srclist) {
					Country  country= new Country();
					BeanUtils.copyProperties(mstCountry, country);		
					targetList.add(country);
				}
			}
			
			mstCountryResponse.setCountryList(targetList);
			
			return mstCountryResponse;
				
		}

}
