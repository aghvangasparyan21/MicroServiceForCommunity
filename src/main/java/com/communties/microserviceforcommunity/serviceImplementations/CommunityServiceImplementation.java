package com.communties.microserviceforcommunity.serviceImplementations;

import com.communties.microserviceforcommunity.dao.CommunityRepository;
import com.communties.microserviceforcommunity.entities.Community;
import com.communties.microserviceforcommunity.exceptions.CommunityAlreadyExistsException;
import com.communties.microserviceforcommunity.exceptions.CommunityNotFoundException;
import com.communties.microserviceforcommunity.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CommunityServiceImplementation implements CommunityService {
    private CommunityRepository communityRepository;

    @Autowired
    public CommunityServiceImplementation(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @Override
    public Community save(Community community) {
        if (checkIfExisted(community)) {
            throw new CommunityAlreadyExistsException("Community already existed");
        }
        return communityRepository.save(community);
    }

    @Override
    public Community findCommunityById(Long communityId) {
        Optional<Community> community = communityRepository.findCommunityById(communityId);
        if (!community.isPresent()) {
            throw new CommunityNotFoundException("There is no such community");
        }
        return community.get();
    }

    @Override
    public Optional<Community> findCommunityByParkingIdWithAvailability(Long parkingId) {
        return communityRepository.findCommunityByParkingIdWithAvailability(parkingId);
    }

    private boolean checkIfExisted(Community community) {
        Optional<Community> existedCommunity = communityRepository.findCommunityByCommunityNumber(community.getCommunityNumber());
        return existedCommunity.isPresent();
    }
}
