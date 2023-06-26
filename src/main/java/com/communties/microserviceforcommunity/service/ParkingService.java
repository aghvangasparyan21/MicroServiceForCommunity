package com.communties.microserviceforcommunity.service;

import com.communties.microserviceforcommunity.entities.Parking;

public interface ParkingService {
    Parking save(Long communityId, int parkingQuantity);

    void book(Long residentId, Long parkingId);
}
