package org.example.vendingMachine;

import org.example.vendingMachine.Enums.*;

public interface VendingState {
    void selectProduct(Product product);
    void insertCoin(Coin coin);
    void insertNote(Note note);
    void dispenseProduct(Product product);
    void returnChange();
}
