package com.besmartexim.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.besmartexim.database.entity.SiteSettings;

@Repository
public interface SiteSettingsRepository extends JpaRepository<SiteSettings, Long> {

}
