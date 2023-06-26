package com.communties.microserviceforcommunity.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "parking")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "available_quantity")
    private int availableQuantity = 50;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "community_id", unique = true)
    private Community community;

    public Parking() {
    }

    public Parking(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return availableQuantity == parking.availableQuantity && Objects.equals(id, parking.id) && Objects.equals(community, parking.community);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, availableQuantity, community);
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", availableQuantity=" + availableQuantity +
                ", community=" + community +
                '}';
    }
}
