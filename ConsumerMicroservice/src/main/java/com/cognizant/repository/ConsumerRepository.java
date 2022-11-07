package com.cognizant.repository;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Consumer;

/**
 * Repository class for storing, fetching and manipulating Consumer Model class
 */

@Repository
@DynamicUpdate
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
	public boolean existsById(long id);
	public boolean existsByPanDetails(String panDetails);
}
