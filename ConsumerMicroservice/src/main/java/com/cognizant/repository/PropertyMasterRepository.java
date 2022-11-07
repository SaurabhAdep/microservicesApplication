package com.cognizant.repository;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.PropertyMaster;

/**
 * Repository class for storing, fetching and manipulating PropertyMaster model class
 */

@Repository
@DynamicUpdate
public interface PropertyMasterRepository extends JpaRepository<PropertyMaster, Long> {

	PropertyMaster findByPropertyTypeAndInsuranceTypeAndBuildingType(String propertyType, String insuranceType,
			String buildingType);

}
