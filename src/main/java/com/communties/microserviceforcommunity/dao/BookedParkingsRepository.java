package com.communties.microserviceforcommunity.dao;

import com.communties.microserviceforcommunity.entities.BookedParkings;
import com.communties.microserviceforcommunity.entities.Parking;
import com.communties.microserviceforcommunity.entities.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookedParkingsRepository extends JpaRepository<BookedParkings, Long> {
    @Query("SELECT bp FROM BookedParkings bp WHERE bp.resident = ?1 AND bp.parking = ?2")
    Optional<BookedParkings> findParkingByResidentAndParking(Resident resident, Parking parking);
}

