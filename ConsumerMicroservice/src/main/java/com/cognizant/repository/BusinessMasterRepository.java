package com.cognizant.repository;

import org.hibernate.annotations.DynamicUpdate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.BusinessMaster;

/**
 * Repository class for storing, fetching and manipulating BusinessMaster class
 */

@Repository
@DynamicUpdate
public interface BusinessMasterRepository extends JpaRepository<BusinessMaster, Long> {

	BusinessMaster findByBusinessCategoryAndBusinessType(String businessCategory, String businessType);

}
