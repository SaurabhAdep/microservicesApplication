package com.cognizant.repository;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Business;

/**
 * Repository class for storing, fetching and manipulating Business Model class
 */

@Repository
@DynamicUpdate
public interface BusinessRepository extends JpaRepository<Business, Long> {
}
