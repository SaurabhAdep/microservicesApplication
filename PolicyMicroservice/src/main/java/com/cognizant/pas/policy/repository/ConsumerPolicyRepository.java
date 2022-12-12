package com.cognizant.pas.policy.repository;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.pas.policy.models.ConsumerPolicy;

/**
 * Repository for adding, fetching and manipulating Consumer Policy Repository
 */
@Repository
@Transactional
@DynamicUpdate
public interface ConsumerPolicyRepository extends JpaRepository<ConsumerPolicy, Long> {

	Boolean existsByConsumerId(Long consumerId);

	ConsumerPolicy findByConsumerId(Long consumerId);

	ConsumerPolicy findByConsumerIdAndBusinessIdAndPolicyId(Long consumerId, Long businessId,String policyId);
	ConsumerPolicy findByConsumerIdAndPolicyId(Long consumerId,String policyId);

}
