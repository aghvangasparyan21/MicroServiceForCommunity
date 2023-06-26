package com.communties.microserviceforcommunity.controllers;

import com.communties.microserviceforcommunity.entities.Resident;
import com.communties.microserviceforcommunity.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/community/resident")
public class ResidentController {
    private ResidentService residentService;

    @Autowired
    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @PostMapping
    public Resident createResident(@RequestBody Resident resident) {
        return residentService.save(resident);
    }

    @PostMapping("/join/{residentId}/{communityId}")
    public void joinResidentToCommunity(@PathVariable Long residentId, @PathVariable Long communityId) {
        residentService.join(residentId, communityId);
    }
}
