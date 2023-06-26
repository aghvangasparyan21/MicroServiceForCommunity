package com.communties.microserviceforcommunity.serviceImplementations;

import com.communties.microserviceforcommunity.dao.ParkingRepository;
import com.communties.microserviceforcommunity.entities.Community;
import com.communties.microserviceforcommunity.entities.Parking;
import com.communties.microserviceforcommunity.entities.Resident;
import com.communties.microserviceforcommunity.exceptions.CommunityNotFoundException;
import com.communties.microserviceforcommunity.exceptions.ParkingAlreadyExistsException;
import com.communties.microserviceforcommunity.exceptions.ParkingNotFoundException;
import com.communties.microserviceforcommunity.service.BookedParkingsService;
import com.communties.microserviceforcommunity.service.CommunityService;
import com.communties.microserviceforcommunity.service.ParkingService;
import com.communties.microserviceforcommunity.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkingServiceImplementation implements ParkingService {
    private ParkingRepository parkingRepository;
    private CommunityService communityService;
    private ResidentService residentService;
    private BookedParkingsService bookedParkingsService;

    @Autowired
    public ParkingServiceImplementation(ParkingRepository parkingRepository,
                                        CommunityService communityService,
                                        ResidentService residentService,
                                        BookedParkingsService bookedParkingsService) {
        this.parkingRepository = parkingRepository;
        this.communityService = communityService;
        this.residentService = residentService;
        this.bookedParkingsService = bookedParkingsService;
    }

    @Override
    public Parking save(Long communityId, int parkingQuantity) {
        Parking dbParking = createParking(communityId, parkingQuantity);
        if (dbParking == null) {
            throw new ParkingAlreadyExistsException("Community already had parking");
        }
        parkingRepository.save(dbParking);
        return dbParking;
    }

    @Override
    public void book(Long residentId, Long parkingId) {
        bookParking(residentId, parkingId);
    }


    private Parking createParking(Long communityId, int parkingQuantity) {
        Community community = communityService.findCommunityById(communityId);
        if (community.getParking() == null) {
            Parking parking = new Parking(parkingQuantity);
            parking.setCommunity(community);
            return parking;
        }
        return null;
    }

    private void bookParking(Long residentId, Long parkingId) {
        Optional<Community> community = communityService.findCommunityByParkingIdWithAvailability(parkingId);
        Resident resident = residentService.findResidentById(residentId);
        if (!community.isPresent()) {
            throw new ParkingNotFoundException("The community has no parking");
        }
        if (resident.getCommunities().contains(community.get())) {
            Optional<Parking> existedParking = parkingRepository.findById(parkingId);
            Parking parking = existedParking.get();
            bookedParkingsService.save(resident, parking);
            int currentQuantity = parking.getAvailableQuantity();
            parking.setAvailableQuantity(--currentQuantity);
            parkingRepository.save(parking);

        } else {
            throw new CommunityNotFoundException("You are not resident for chosen community");
        }

    }
}
