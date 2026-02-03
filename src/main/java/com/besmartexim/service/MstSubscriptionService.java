package com.besmartexim.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.besmartexim.database.entity.MstSubscription;
import com.besmartexim.database.entity.SubscriptionCountries;
import com.besmartexim.database.entity.SubscriptionDetails;
import com.besmartexim.database.repository.MstSubscriptionDetailsRepository;
import com.besmartexim.database.repository.MstSubscriptionRepository;
import com.besmartexim.database.repository.SupportedCountryRepository;
import com.besmartexim.dto.request.KeyObject;
import com.besmartexim.dto.request.MstSubscriptionRequest;
import com.besmartexim.dto.response.FullSubscription;
import com.besmartexim.dto.response.MstSubscriptionResponse;
import com.besmartexim.dto.response.Subscription;

@Service
public class MstSubscriptionService {

	@Autowired
	private MstSubscriptionRepository mstSubscriptionRepository;
	@Autowired
	private MstSubscriptionDetailsRepository mstSubscriptionDetailsRepository;
	@Autowired
	private SupportedCountryRepository supportedCountryRepository;

	public void subscriptionCreate(MstSubscriptionRequest request, Long accessedBy) throws Exception {
		MstSubscription mstSubscription = new MstSubscription();
		mstSubscription.setName(request.getName());
		mstSubscription.setDescription(request.getDescription());
		mstSubscription.setIsActive(request.getIsActive());
		mstSubscription.setPrice(request.getPrice());
		mstSubscription.setValidityInDay(request.getValidityDay());
		mstSubscription.setIsCustom(request.getIsCustom());
		mstSubscription.setIndepthAccess(request.getIndepthAccess());
		mstSubscription.setCreatedBy(accessedBy);
		mstSubscription.setCreatedDate(new Date());

		mstSubscription = mstSubscriptionRepository.save(mstSubscription);

		List<SubscriptionDetails> subDetailList = new ArrayList<SubscriptionDetails>();

		for (Map.Entry<String, KeyObject> keyObject : request.getOtherAttributes().entrySet()) {
			SubscriptionDetails sbd = new SubscriptionDetails();
			sbd.setSubscriptionid(mstSubscription.getId());
			sbd.setShort_key(keyObject.getKey());

			KeyObject ko = keyObject.getValue();
			sbd.setKey_desc(ko.getKeyDesc());
			sbd.setKey_fullform(ko.getKeyFullName());
			sbd.setKey_value(ko.getKeyValue());
			sbd.setValue_desc(ko.getValueDesc());

			subDetailList.add(sbd);

		}
		mstSubscriptionDetailsRepository.saveAll(subDetailList);

		SubscriptionCountries subscriptionCountries = new SubscriptionCountries();
		subscriptionCountries.setSubscriptionid(mstSubscription.getId());
		subscriptionCountries.setContinent_id(request.getContinentId().toString());
		subscriptionCountries.setCountry_id(request.getCountryId().toString());

		supportedCountryRepository.save(subscriptionCountries);
	}

	@Transactional
	public String subscriptionUpdate(@Valid MstSubscriptionRequest request, Long subscriptionId, Long accessedBy) {

		String msg = null;
		try {
			
			MstSubscription mstSubscription = new MstSubscription();
			mstSubscription.setId(subscriptionId);
			
			mstSubscription.setName(request.getName());
			mstSubscription.setDescription(request.getDescription());
			mstSubscription.setIsActive(request.getIsActive());
			mstSubscription.setPrice(request.getPrice());
			mstSubscription.setIsCustom(request.getIsCustom());
			mstSubscription.setModifiedBy(accessedBy);
			mstSubscription.setModifiedDate(new Date());
			mstSubscription.setValidityInDay(request.getValidityDay());
			mstSubscription.setIndepthAccess(request.getIndepthAccess());
			mstSubscriptionRepository.save(mstSubscription);

			mstSubscriptionDetailsRepository.deleteBySubscriptionid(subscriptionId);

			List<SubscriptionDetails> subDetailList = new ArrayList<SubscriptionDetails>();

			for (Map.Entry<String, KeyObject> keyObject : request.getOtherAttributes().entrySet()) {
				SubscriptionDetails sbd = new SubscriptionDetails();
				sbd.setSubscriptionid(mstSubscription.getId());
				sbd.setShort_key(keyObject.getKey());

				KeyObject ko = keyObject.getValue();
				sbd.setKey_desc(ko.getKeyDesc());
				sbd.setKey_fullform(ko.getKeyFullName());
				sbd.setKey_value(ko.getKeyValue());
				sbd.setValue_desc(ko.getValueDesc());

				subDetailList.add(sbd);

			}

			mstSubscriptionDetailsRepository.saveAll(subDetailList);

			supportedCountryRepository.deleteBySubscriptionid(subscriptionId);
			SubscriptionCountries subscriptionCountries = new SubscriptionCountries();
			subscriptionCountries.setSubscriptionid(mstSubscription.getId());
			subscriptionCountries.setContinent_id(request.getContinentId().toString());
			subscriptionCountries.setCountry_id(request.getCountryId().toString());

			supportedCountryRepository.save(subscriptionCountries);
			
			msg = "Update successfully";
			
		} catch (Exception e) {
			msg = "Somthing wrong. Please try again";
		}
		return msg;
	}

	public MstSubscriptionResponse subscriptionList(String isCustom, String isActive, Long accessedBy) {

		MstSubscriptionResponse mstSubscriptionResponse = new MstSubscriptionResponse();

		List<MstSubscription> srclist = null;

		if (isCustom != null && isActive != null) {
			srclist = mstSubscriptionRepository.findByIsCustomAndIsActiveOrderByIdDesc(isCustom, isActive);
		} else if (isCustom != null && isActive == null) {
			srclist = (List<MstSubscription>) mstSubscriptionRepository.findByIsCustomOrderByIdDesc(isCustom);
		} else if (isCustom == null && isActive != null) {
			srclist = (List<MstSubscription>) mstSubscriptionRepository.findByIsActiveOrderByIdDesc(isActive);
		} else {
			srclist = (List<MstSubscription>) mstSubscriptionRepository.findAllByOrderByIdDesc();
		}

		List<Subscription> targetList = new ArrayList<Subscription>();

		if (null != srclist && !srclist.isEmpty()) {

			for (MstSubscription mstSubscription : srclist) {
				Subscription subscription = new Subscription();
				BeanUtils.copyProperties(mstSubscription, subscription);
				List<SubscriptionDetails> subDlist = mstSubscriptionDetailsRepository
						.findBySubscriptionid(mstSubscription.getId());
				for (SubscriptionDetails mstSubdetails : subDlist) {
					if ("DATA_ACCCESS".equalsIgnoreCase(mstSubdetails.getShort_key())) {
						subscription.setDataAccess(mstSubdetails.getKey_value());
					}
					if ("DOWNLOAD_LIMIT".equalsIgnoreCase(mstSubdetails.getShort_key())) {
						subscription.setDownloadLimit(mstSubdetails.getKey_value());
					}
					if ("MAX_DOWNLOAD_DAY".equalsIgnoreCase(mstSubdetails.getShort_key())) {
						subscription.setMaxDownloadPerDay(mstSubdetails.getKey_value());
					}
					if ("WORKSPACE".equalsIgnoreCase(mstSubdetails.getShort_key())) {
						subscription.setWorkspaceLimit(mstSubdetails.getKey_value());
					}
					if ("SUPPORT".equalsIgnoreCase(mstSubdetails.getShort_key())) {
						subscription.setSupport(mstSubdetails.getKey_value());
					}
					if ("TICKET_MANAGER".equalsIgnoreCase(mstSubdetails.getShort_key())) {
						subscription.setTicketManager(mstSubdetails.getKey_value());
					}
					if ("RECORD_PER_WORKSPACE".equalsIgnoreCase(mstSubdetails.getShort_key())) {
						subscription.setRecordPerWorkspace(mstSubdetails.getKey_value());
					}
					if ("SUB_USER".equalsIgnoreCase(mstSubdetails.getShort_key())) {
						subscription.setSubUserCount(mstSubdetails.getKey_value());
					}
					if ("DISPLAY_FIELDS".equalsIgnoreCase(mstSubdetails.getShort_key())) {
						subscription.setDisplayFields(mstSubdetails.getKey_value());
					}
					if ("QUERY_PER_DAY".equalsIgnoreCase(mstSubdetails.getShort_key())) {
						subscription.setSearchQueryPerDay(mstSubdetails.getKey_value());
					}
					if ("ALLOWED_CHAPTER".equalsIgnoreCase(mstSubdetails.getShort_key())) {
						subscription.setAllowedChapter(mstSubdetails.getKey_value());
					}
				}

				List<SubscriptionCountries> countList = supportedCountryRepository
						.findBySubscriptionid(mstSubscription.getId());

				for (SubscriptionCountries mstcdetails : countList) {
					subscription.setContinentId(convertStringToList(mstcdetails.getContinent_id()));
					subscription.setCountryId(convertStringToList(mstcdetails.getCountry_id()));
				}
				targetList.add(subscription);
			}
		}

		mstSubscriptionResponse.setSubscriptionList(targetList);

		return mstSubscriptionResponse;
	}

	private List<String> convertStringToList(String s1) {
		if (s1 != null) {
			// String s1="[a,b,c,d]";
			String replace = s1.replace("[", "");
			System.out.println(replace);
			String replace1 = replace.replace("]", "");
			System.out.println(replace1);
			List<String> myList = new ArrayList<String>(Arrays.asList(replace1.split(",")));
			System.out.println(myList.toString());
			return myList;
		}
		return null;

	}

	public Subscription getSubscriptionDetails(Long subscriptionId, Long accessedBy) {

		MstSubscription mstSub = mstSubscriptionRepository.findById(subscriptionId).get();
		Subscription subscription = new Subscription();
		BeanUtils.copyProperties(mstSub, subscription);
		if (null != mstSub) {
			List<SubscriptionDetails> subDlist = mstSubscriptionDetailsRepository.findBySubscriptionid(subscriptionId);
			for (SubscriptionDetails mstSubdetails : subDlist) {
				if ("DATA_ACCCESS".equalsIgnoreCase(mstSubdetails.getShort_key())) {
					subscription.setDataAccess(mstSubdetails.getKey_value());
				}
				if ("DOWNLOAD_LIMIT".equalsIgnoreCase(mstSubdetails.getShort_key())) {
					subscription.setDownloadLimit(mstSubdetails.getKey_value());
				}
				if ("MAX_DOWNLOAD_DAY".equalsIgnoreCase(mstSubdetails.getShort_key())) {
					subscription.setMaxDownloadPerDay(mstSubdetails.getKey_value());
				}
				if ("WORKSPACE".equalsIgnoreCase(mstSubdetails.getShort_key())) {
					subscription.setWorkspaceLimit(mstSubdetails.getKey_value());
				}
				if ("SUPPORT".equalsIgnoreCase(mstSubdetails.getShort_key())) {
					subscription.setSupport(mstSubdetails.getKey_value());
				}
				if ("TICKET_MANAGER".equalsIgnoreCase(mstSubdetails.getShort_key())) {
					subscription.setTicketManager(mstSubdetails.getKey_value());
				}
				if ("RECORD_PER_WORKSPACE".equalsIgnoreCase(mstSubdetails.getShort_key())) {
					subscription.setRecordPerWorkspace(mstSubdetails.getKey_value());
				}
				if ("SUB_USER".equalsIgnoreCase(mstSubdetails.getShort_key())) {
					subscription.setSubUserCount(mstSubdetails.getKey_value());
				}
				if ("DISPLAY_FIELDS".equalsIgnoreCase(mstSubdetails.getShort_key())) {
					subscription.setDisplayFields(mstSubdetails.getKey_value());
				}
				if ("QUERY_PER_DAY".equalsIgnoreCase(mstSubdetails.getShort_key())) {
					subscription.setSearchQueryPerDay(mstSubdetails.getKey_value());
				}
				if ("ALLOWED_CHAPTER".equalsIgnoreCase(mstSubdetails.getShort_key())) {
					subscription.setAllowedChapter(mstSubdetails.getKey_value());
				}

			}

			List<SubscriptionCountries> countList = supportedCountryRepository.findBySubscriptionid(subscriptionId);

			for (SubscriptionCountries mstcdetails : countList) {
				subscription.setContinentId(convertStringToList(mstcdetails.getContinent_id()));
				subscription.setCountryId(convertStringToList(mstcdetails.getCountry_id()));
			}
		}

		return subscription;
	}
	
	
	public FullSubscription getFullSubscriptionDetails(Long subscriptionId, Long accessedBy) {

		MstSubscription mstSub = mstSubscriptionRepository.findById(subscriptionId).get();
		FullSubscription subscription = new FullSubscription();
		BeanUtils.copyProperties(mstSub, subscription);

		if (null != mstSub) {
			List<SubscriptionDetails> subDlist = mstSubscriptionDetailsRepository.findBySubscriptionid(subscriptionId);

			Map<String, KeyObject> map = new HashMap<String, KeyObject>();

			for (SubscriptionDetails mstSubdetails : subDlist) {
				KeyObject key = new KeyObject();
				key.setKeyFullName(mstSubdetails.getKey_fullform());
				key.setKeyDesc(mstSubdetails.getKey_desc());
				key.setKeyValue(mstSubdetails.getKey_value());
				key.setValueDesc(mstSubdetails.getValue_desc());

				map.put(mstSubdetails.getShort_key(), key);
			}
			subscription.setOtherAttributes(map);

			List<SubscriptionCountries> countList = supportedCountryRepository.findBySubscriptionid(subscriptionId);

			for (SubscriptionCountries mstcdetails : countList) {
				subscription.setContinentId(convertStringToList(mstcdetails.getContinent_id()));
				subscription.setCountryId(convertStringToList(mstcdetails.getCountry_id()));
			}
		}

		return subscription;
	}
}
