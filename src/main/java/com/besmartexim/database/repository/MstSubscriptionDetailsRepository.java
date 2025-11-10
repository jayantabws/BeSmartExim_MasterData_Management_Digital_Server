package com.besmartexim.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.besmartexim.database.entity.SubscriptionDetails;

@Repository
public interface MstSubscriptionDetailsRepository extends JpaRepository<SubscriptionDetails, Long> {

	void deleteBySubscriptionid(Long subscription_id);

	List<SubscriptionDetails> findBySubscriptionid(Long subscription_id);
}
