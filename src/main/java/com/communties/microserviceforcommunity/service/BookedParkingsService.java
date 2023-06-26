package com.communties.microserviceforcommunity.service;

import com.communties.microserviceforcommunity.entities.Parking;
import com.communties.microserviceforcommunity.entities.Resident;

public interface BookedParkingsService {
    void save(Resident resident, Parking parking);
}
