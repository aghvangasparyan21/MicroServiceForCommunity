package com.communties.microserviceforcommunity.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "community")
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "community_number", unique = true)
    private Long communityNumber;

    @OneToOne(mappedBy = "community")
    private Parking parking;


    public Community() {
    }

    public Community(Long communityNumber) {
        this.communityNumber = communityNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommunityNumber() {
        return communityNumber;
    }

    public void setCommunityNumber(Long communityNumber) {
        this.communityNumber = communityNumber;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Community community = (Community) o;
        return Objects.equals(id, community.id) && Objects.equals(communityNumber, community.communityNumber) && Objects.equals(parking, community.parking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, communityNumber, parking);
    }

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", communityNumber=" + communityNumber +
                ", parking=" + parking +
                '}';
    }
}
