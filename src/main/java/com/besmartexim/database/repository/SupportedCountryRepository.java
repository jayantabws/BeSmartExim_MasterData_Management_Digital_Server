package com.besmartexim.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.besmartexim.database.entity.SubscriptionCountries;

@Repository
public interface SupportedCountryRepository extends JpaRepository<SubscriptionCountries, Long> {

	void deleteBySubscriptionid(Long subscription_id);

	List<SubscriptionCountries> findBySubscriptionid(Long subscription_id);
}
