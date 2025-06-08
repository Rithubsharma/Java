package org.example;

import org.example.hotelManagementSystem.Guest;
import org.example.hotelManagementSystem.HotelManagementSystem;
import org.example.hotelManagementSystem.Room;
import org.example.hotelManagementSystem.enums.Reservation;
import org.example.hotelManagementSystem.enums.RoomType;
import org.example.hotelManagementSystem.payment.CardPayment;
import org.example.hotelManagementSystem.payment.Payment;

import java.time.LocalDate;

public class HotelManagementDemo {
    public static void runHmDemo() {
        HotelManagementSystem hotelManagementSystem = HotelManagementSystem.getInstance();

        // Create guests
        Guest guest1 = new Guest("G001", "John Doe", "john@example.com", "1234567890");
        Guest guest2 = new Guest("G002", "Jane Smith", "jane@example.com", "9876543210");
        hotelManagementSystem.addGuest(guest1);
        hotelManagementSystem.addGuest(guest2);

        // Create rooms
        Room room1 = new Room("R001", RoomType.SINGLE, 100.0);
        Room room2 = new Room("R002", RoomType.DOUBLE, 200.0);
        hotelManagementSystem.addRoom(room1);
        hotelManagementSystem.addRoom(room2);

        // Book a room
        LocalDate checkInDate = LocalDate.now();
        LocalDate checkOutDate = checkInDate.plusDays(3);
        Reservation reservation1 = hotelManagementSystem.reserveRoom(room1, guest1, checkInDate, checkOutDate);
        if (reservation1 != null) {
            System.out.println("Reservation created: " + reservation1.getId());
        } else {
            System.out.println("Room not available for booking.");
        }

        // Check-in
        hotelManagementSystem.checkIn(reservation1.getId());
        System.out.println("Checked in: " + reservation1.getId());

        // Check-out and process payment
        Payment payment = new CardPayment();
        hotelManagementSystem.checkOut(reservation1.getId());
        System.out.println("Checked out: " + reservation1.getId());

        // Cancel a reservation
        hotelManagementSystem.cancelReservation(reservation1.getId());
        System.out.println("Reservation cancelled: " + reservation1.getId());
    }
}
