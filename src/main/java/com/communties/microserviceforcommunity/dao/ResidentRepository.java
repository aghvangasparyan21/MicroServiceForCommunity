package com.communties.microserviceforcommunity.dao;

import com.communties.microserviceforcommunity.entities.Community;
import com.communties.microserviceforcommunity.entities.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {
    @Query("SELECT r FROM Resident r WHERE r.id = :residentId")
    Optional<Resident> findResidentById(Long residentId);

    @Query("SELECT r FROM Resident r WHERE r.email = :email")
    Optional<Resident> findResidentByEmail(String email);

    @Query("SELECT u.communities FROM Resident u WHERE u.email = :residentEmail")
    List<Community> findCommunitiesByUserEmail(@Param("residentEmail") String residentEmail);
}
