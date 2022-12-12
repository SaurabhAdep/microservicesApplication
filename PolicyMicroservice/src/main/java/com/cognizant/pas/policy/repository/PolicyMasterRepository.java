package com.cognizant.pas.policy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.pas.policy.models.PolicyMaster;

/**
 * Repository for adding, fetching and manipulating Policy Master Repository
 */
@Repository
@Transactional
public interface PolicyMasterRepository extends JpaRepository<PolicyMaster, Long> {

	PolicyMaster findByPid(String policyId);

	Boolean existsByPid(String policyId);
	
	List<PolicyMaster> findByPropertyTypeAndConsumerTypeAndPropertyValueAndBusinessValueAndType(String propertyType,
			String consumerType,Long propertyValue,Long businessValue,String type);

}
