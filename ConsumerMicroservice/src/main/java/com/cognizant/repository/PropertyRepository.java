package com.cognizant.repository;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Property;

/**
 * Repository class for storing, fetching and manipulating Property Model class
 */

@Repository
@DynamicUpdate
public interface PropertyRepository extends JpaRepository<Property, Long> {

}
