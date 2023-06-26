package com.communties.microserviceforcommunity.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "bookedparkings")
public class BookedParkings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resident_id")
    private Resident resident;

    @ManyToOne
    @JoinColumn(name = "parking_id")
    private Parking parking;

    public BookedParkings() {
    }

    public BookedParkings(Resident resident, Parking parking) {
        this.resident = resident;
        this.parking = parking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
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
        BookedParkings that = (BookedParkings) o;
        return Objects.equals(id, that.id) && Objects.equals(resident, that.resident) && Objects.equals(parking, that.parking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resident, parking);
    }

    @Override
    public String toString() {
        return "BookedParkings{" +
                "id=" + id +
                ", resident=" + resident +
                ", parking=" + parking +
                '}';
    }
}
