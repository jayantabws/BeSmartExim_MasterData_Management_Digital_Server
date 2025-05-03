package com.besmartexim.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.besmartexim.database.entity.MstSubscription;



public interface MstSubscriptionRepository  extends CrudRepository<MstSubscription, Long> {

	List<MstSubscription> findByIsCustomAndIsActive(String isCustom, String isActive);

	List<MstSubscription> findAllByOrderByIdDesc();

	List<MstSubscription> findByIsCustomAndIsActiveOrderByIdDesc(String isCustom, String isActive);

	List<MstSubscription> findByIsCustomOrderByIdDesc(String isCustom);

	List<MstSubscription> findByIsActiveOrderByIdDesc(String isActive);
}
