package org.example.parkinglot;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private Integer floor;
    private List<ParkingSpot> parkingSpots;

    public ParkingFloor(Integer floor, List<ParkingSpot> parkingSpots){
        this.floor = floor;
        this.parkingSpots = parkingSpots;
    }

    public Optional<ParkingSpot> findParkingSpot(VehicleType vehicleType){
        return parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.getVehicleType().equals(vehicleType))
                .findFirst();
    }

    public List<ParkingSpot> getAvailableSpots(VehicleType vehicleType){
        return parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.getVehicleType().equals(vehicleType))
                .toList();
    }

    public Integer getFloor() {
        return floor;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}
