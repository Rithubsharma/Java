package org.example.parkinglot;

public class ParkingSpot {
    private Integer spotNumber;
    private VehicleType vehicleType;
    private Vehicle vehicle;
    private Boolean isOccupied;

    public ParkingSpot(Integer spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        this.isOccupied = false;
    }

    public Boolean park(Vehicle vehicle) {
        if (isOccupied || vehicle.getVehicleType() != vehicleType) {
            return false;
        }
        this.vehicle = vehicle;
        isOccupied = true;
        return true;
    }

    public void unPark(){
        vehicle=null;
        isOccupied=false;
    }

    public Boolean isAvailable(){
        return !isOccupied;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Integer getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
