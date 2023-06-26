package com.communties.microserviceforcommunity.dao;

import com.communties.microserviceforcommunity.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
