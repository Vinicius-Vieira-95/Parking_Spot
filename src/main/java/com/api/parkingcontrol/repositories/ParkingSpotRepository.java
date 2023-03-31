package com.api.parkingcontrol.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.parkingcontrol.entities.ParkingSpot;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, UUID>{

	
}
