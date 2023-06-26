package com.communties.microserviceforcommunity.controllers;

import com.communties.microserviceforcommunity.entities.Community;
import com.communties.microserviceforcommunity.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/community")
public class CommunityController {
    private CommunityService communityService;

    @Autowired
    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @PostMapping
    public Community createCommunity(@RequestBody Community community) {
        return communityService.save(community);
    }
}
