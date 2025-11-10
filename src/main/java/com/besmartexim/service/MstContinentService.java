package com.besmartexim.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.besmartexim.database.entity.MstContinent;
import com.besmartexim.database.repository.MstContinentRepository;
import com.besmartexim.dto.request.MstContinentRequest;
import com.besmartexim.dto.response.Continent;
import com.besmartexim.dto.response.MstContinentResponse;

@Service
public class MstContinentService {

	@Autowired
	private MstContinentRepository mstContinentRepository;

	public void continentCreate(MstContinentRequest request, Long accessedBy) throws Exception {

		String name = request.getName();
		String is_active = request.getIs_active();

		MstContinent mstContinentEntity = new MstContinent();

		mstContinentEntity.setName(name);
		mstContinentEntity.setIs_active(is_active);
		mstContinentEntity.setCreated_by(accessedBy);
		mstContinentEntity.setCreated_date(new Date());
		mstContinentRepository.save(mstContinentEntity);

	}

	public void continentUpdate(MstContinentRequest request, Long continentId, Long accessedBy) throws Exception {

		Optional<MstContinent> list = mstContinentRepository.findById(continentId);

		MstContinent mstContinentEntity = list.get();

		String name = request.getName();
		String is_active = request.getIs_active();

		mstContinentEntity.setName(name);
		mstContinentEntity.setIs_active(is_active);
		mstContinentEntity.setModified_by(accessedBy);
		mstContinentEntity.setModified_date(new Date());
		mstContinentRepository.save(mstContinentEntity);

	}

	public MstContinentResponse continentList() throws Exception {

		MstContinentResponse mstContinentResponse = new MstContinentResponse();

		List<MstContinent> srclist = mstContinentRepository.findAll();

		List<Continent> targetList = new ArrayList<Continent>();

		if (null != srclist && !srclist.isEmpty()) {

			for (MstContinent mstContinent : srclist) {
				Continent continent = new Continent();
				BeanUtils.copyProperties(mstContinent, continent);
				targetList.add(continent);
			}
		}

		mstContinentResponse.setContinentList(targetList);

		return mstContinentResponse;

	}

}
