package com.communties.microserviceforcommunity.serviceImplementations;

import com.communties.microserviceforcommunity.dao.ResidentRepository;
import com.communties.microserviceforcommunity.entities.Community;
import com.communties.microserviceforcommunity.entities.Resident;
import com.communties.microserviceforcommunity.exceptions.CommunityAlreadyExistsException;
import com.communties.microserviceforcommunity.exceptions.ResidentAlreadyExistsException;
import com.communties.microserviceforcommunity.exceptions.ResidentNotFoundException;
import com.communties.microserviceforcommunity.service.CommunityService;
import com.communties.microserviceforcommunity.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResidentServiceImplementation implements ResidentService {
    private ResidentRepository residentRepository;
    private CommunityService communityService;

    @Autowired
    public ResidentServiceImplementation(ResidentRepository residentRepository, CommunityService communityService) {
        this.residentRepository = residentRepository;
        this.communityService = communityService;
    }

    @Override
    public Resident findResidentById(Long residentId) {
        Optional<Resident> resident = residentRepository.findResidentById(residentId);
        if (!resident.isPresent()) {
            throw new ResidentNotFoundException("There is no such resident");
        }
        return resident.get();
    }

    @Override
    public Resident save(Resident resident) {
        if (checkIfResidentExisted(resident)) {
            throw new ResidentAlreadyExistsException("Resident is already existed");
        }
        return residentRepository.save(resident);
    }

    @Override
    public void join(Long residentId, Long communityId) {
        Community community = communityService.findCommunityById(communityId);
        Resident resident = this.findResidentById(residentId);
        if (resident.getCommunities().contains(community)) {
            throw new CommunityAlreadyExistsException("You are already in this community");
        }
        Resident forLinkingTable = resident;
        forLinkingTable.getCommunities().add(community);
        residentRepository.save(forLinkingTable);
    }


    private boolean checkIfResidentExisted(Resident resident) {
        Optional<Resident> existedResident = residentRepository.findResidentByEmail(resident.getEmail());
        return existedResident.isPresent();
    }

}
