package com.communties.microserviceforcommunity.controllers.dto;

public class CreateParkingRequest {
    private Long communityId;
    private int parkingQuantity;

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public int getParkingQuantity() {
        return parkingQuantity;
    }

    public void setParkingQuantity(int parkingQuantity) {
        this.parkingQuantity = parkingQuantity;
    }
}
