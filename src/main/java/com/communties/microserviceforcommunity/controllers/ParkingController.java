package com.communties.microserviceforcommunity.controllers;

import com.communties.microserviceforcommunity.controllers.dto.CreateParkingRequest;
import com.communties.microserviceforcommunity.entities.Parking;
import com.communties.microserviceforcommunity.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/community/resident/parking")
public class ParkingController {
    private ParkingService parkingService;

    @Autowired
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @PostMapping
    public Parking createParking(@RequestBody CreateParkingRequest createParkingRequest) {
        Long communityId = createParkingRequest.getCommunityId();
        int parkingQuantity = createParkingRequest.getParkingQuantity();
        return parkingService.save(communityId, parkingQuantity);
    }

    @PostMapping("/book/{residentId}/{parkingId}")
    public void bookParking(@PathVariable Long residentId, @PathVariable Long parkingId) {
        parkingService.book(residentId, parkingId);
    }
}
