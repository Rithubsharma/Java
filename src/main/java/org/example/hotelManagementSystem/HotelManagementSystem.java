package org.example.hotelManagementSystem;

import org.example.hotelManagementSystem.enums.Reservation;
import org.example.hotelManagementSystem.enums.ReservationStatus;
import org.example.hotelManagementSystem.enums.RoomStatus;
import org.example.hotelManagementSystem.payment.CardPayment;
import org.example.hotelManagementSystem.payment.Payment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HotelManagementSystem {
    private static HotelManagementSystem instance;
    private final Payment payment;
    private final Map<String, Guest> guests;
    private final Map<String, Room> rooms;
    private final Map<String, Reservation> reservations;

    private HotelManagementSystem() {
        guests = new ConcurrentHashMap<>();
        rooms = new ConcurrentHashMap<>();
        reservations = new ConcurrentHashMap<>();
        payment = new CardPayment();
    }

    public static synchronized HotelManagementSystem getInstance() {
        if (instance == null) {
            instance = new HotelManagementSystem();
        }
        return instance;
    }

    public synchronized Reservation reserveRoom(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        if (RoomStatus.AVAILABLE.equals(room.getStatus())) {
            room.bookRoom();
            Reservation reservation = new Reservation(UUID.randomUUID().toString(), guest, room, checkInDate, checkOutDate);
            reservations.put(reservation.getId(), reservation);
            return reservation;
        }
        return null;
    }

    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if (reservation != null) {
            reservation.cancel();
            reservations.remove(reservationId);
        }
    }

    public synchronized void checkIn(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if (reservation != null && ReservationStatus.CONFIRMED.equals(reservation.getReservationStatus())) {
            Room room = reservation.getRoom();
            room.checkIn();
        } else {
            throw new IllegalStateException("Invalid reservation or reservation not confirmed.");
        }
    }

    public synchronized void checkOut(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if (reservation != null && ReservationStatus.CONFIRMED.equals(reservation.getReservationStatus())) {
            Room room = reservation.getRoom();
            Double amount = room.getPrice() * ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());
            if (payment.processPayment(amount)) {
                room.checkOut();
                reservations.remove(reservationId);
            } else {
                throw new IllegalStateException("Payment failed.");
            }
        } else {
            throw new IllegalStateException("Invalid reservation or reservation not confirmed.");
        }
    }

    public Map<String, Guest> getGuests() {
        return guests;
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }

    public Map<String, Reservation> getReservations() {
        return reservations;
    }


    public void addGuest(Guest guest1) {
        guests.put(guest1.getId(), guest1);
    }

    public void addRoom(Room room1) {
        rooms.put(room1.getId(), room1);
    }
}
