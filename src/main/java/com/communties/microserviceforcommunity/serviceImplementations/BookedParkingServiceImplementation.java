package com.communties.microserviceforcommunity.serviceImplementations;

import com.communties.microserviceforcommunity.dao.BookedParkingsRepository;
import com.communties.microserviceforcommunity.entities.BookedParkings;
import com.communties.microserviceforcommunity.entities.Parking;
import com.communties.microserviceforcommunity.entities.Resident;
import com.communties.microserviceforcommunity.exceptions.ParkingAlreadyExistsException;
import com.communties.microserviceforcommunity.service.BookedParkingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookedParkingServiceImplementation implements BookedParkingsService {
    private BookedParkingsRepository bookedParkingsRepository;

    @Autowired
    public BookedParkingServiceImplementation(BookedParkingsRepository bookedParkingsRepository) {
        this.bookedParkingsRepository = bookedParkingsRepository;
    }

    @Override
    public void save(Resident resident, Parking parking) {
        Optional<BookedParkings> bookedParking = bookedParkingsRepository.findParkingByResidentAndParking(resident, parking);
        if (bookedParking.isPresent()) {
            throw new ParkingAlreadyExistsException("You had already booked that parking");
        }
        BookedParkings parkingForDB = new BookedParkings(resident, parking);
        bookedParkingsRepository.save(parkingForDB);
    }
}
