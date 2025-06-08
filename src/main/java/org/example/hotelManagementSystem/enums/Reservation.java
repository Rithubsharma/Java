package org.example.hotelManagementSystem.enums;

import org.example.hotelManagementSystem.Guest;
import org.example.hotelManagementSystem.Room;

import java.time.LocalDate;

public class Reservation {
    private final String id;
    private final Guest guest;
    private final Room room;
    private ReservationStatus reservationStatus;
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;

    public Reservation(String id, Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.reservationStatus = ReservationStatus.CONFIRMED;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public synchronized void cancel() {
        if (ReservationStatus.CONFIRMED.equals(reservationStatus)) {
            reservationStatus = ReservationStatus.CANCELLED;
            room.checkOut();
        } else {
            throw new IllegalStateException("Reservation is not confirmed.");
        }
    }

    public String getId() {
        return id;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
}
