package org.example.hotelManagementSystem;

import org.example.hotelManagementSystem.enums.RoomStatus;
import org.example.hotelManagementSystem.enums.RoomType;

public class Room {
    private final String id;
    private final RoomType roomType;
    private RoomStatus roomStatus;
    private final Double price;

    public Room(String id, RoomType type, double price) {
        this.id = id;
        this.roomType = type;
        this.price = price;
        this.roomStatus = RoomStatus.AVAILABLE;
    }

    public synchronized void bookRoom(){
        if(RoomStatus.AVAILABLE.equals(roomStatus)){
            roomStatus = RoomStatus.RESERVED;
        } else {
            throw new IllegalStateException("Room is not available for booking.");
        }
    }

    public synchronized void checkIn(){
        if(RoomStatus.RESERVED.equals(roomStatus)){
            roomStatus = RoomStatus.OCCUPIED;
        } else {
            throw new IllegalStateException("Room is not booked.");
        }
    }

    public synchronized void checkOut(){
        if(RoomStatus.OCCUPIED.equals(roomStatus)){
            roomStatus = RoomStatus.AVAILABLE;
        } else {
            throw new IllegalStateException("Room is not occupied.");
        }
    }

    public String getId() {
        return id;
    }

    public RoomType getType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public RoomStatus getStatus() {
        return roomStatus;
    }
}
