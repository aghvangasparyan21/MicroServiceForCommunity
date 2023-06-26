package com.communties.microserviceforcommunity.dao;

import com.communties.microserviceforcommunity.entities.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface CommunityRepository extends JpaRepository<Community, Long> {
    @Query("SELECT c FROM Community c WHERE c.id = :communityId")
    Optional<Community> findCommunityById(Long communityId);

    @Query("SELECT c FROM Community c WHERE c.communityNumber = :communityNumber")
    Optional<Community> findCommunityByCommunityNumber(Long communityNumber);

    @Query("SELECT c FROM Community c JOIN FETCH c.parking p WHERE p.id = :parkingId AND p.availableQuantity > 0")
    Optional<Community> findCommunityByParkingIdWithAvailability(@Param("parkingId") Long parkingId);
}
