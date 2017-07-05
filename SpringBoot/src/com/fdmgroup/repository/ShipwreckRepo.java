package com.fdmgroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.model.Shipwreck;

@Repository
public interface ShipwreckRepo extends JpaRepository<Shipwreck, Long> {

	
	
}
