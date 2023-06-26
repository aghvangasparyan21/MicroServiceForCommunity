package com.communties.microserviceforcommunity.service;

import com.communties.microserviceforcommunity.entities.Resident;

public interface ResidentService {
    Resident findResidentById(Long residentId);

    Resident save(Resident resident);

    void join(Long residentId, Long communityId);
}
