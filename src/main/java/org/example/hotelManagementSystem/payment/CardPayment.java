package org.example.hotelManagementSystem.payment;

public class CardPayment implements Payment {
    @Override
    public boolean processPayment(Double amount) {
        return true;
    }
}
