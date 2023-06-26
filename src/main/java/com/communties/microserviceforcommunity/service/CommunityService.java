package com.communties.microserviceforcommunity.service;

import com.communties.microserviceforcommunity.entities.Community;

import java.util.Optional;

public interface CommunityService {
    Community save(Community community);

    Community findCommunityById(Long communityId);

    Optional<Community> findCommunityByParkingIdWithAvailability(Long parkingId);
}
