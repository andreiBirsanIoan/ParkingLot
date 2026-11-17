package org.example.parkinglot.common;

public class CarDto {
    Long id;
    String licensePlate;
    String parkingSpot;
    String ownerName;

    public CarDto(String licensePlate, Long id, String parkingSpot, String ownerName) {
        this.licensePlate = licensePlate;
        this.id = id;
        this.parkingSpot = parkingSpot;
        this.ownerName = ownerName;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Long getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }
}
