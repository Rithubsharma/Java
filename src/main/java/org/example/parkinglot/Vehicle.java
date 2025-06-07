package org.example.parkinglot;

public abstract class Vehicle {
    private String numberPlate;
    private VehicleType vehicleType;

    public Vehicle(String numberPlate, VehicleType vehicleType){
        this.vehicleType = vehicleType;
        this.numberPlate =  numberPlate;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
