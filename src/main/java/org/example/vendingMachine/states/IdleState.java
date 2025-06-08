package org.example.vendingMachine.states;

import org.example.vendingMachine.enums.Coin;
import org.example.vendingMachine.enums.Note;
import org.example.vendingMachine.Product;
import org.example.vendingMachine.VendingMachine;
import org.example.vendingMachine.VendingState;

import static org.example.vendingMachine.constants.VMConstants.IDLE_STATE_COMMENT;

public class IdleState implements VendingState {
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        if (vendingMachine.getInventory().isAvailable(product)) {
            System.out.println("Product selected: " + product.getName());
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setState(vendingMachine.getReadyState());
        } else {
            System.out.println("Product not available: " + product.getName());
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println(IDLE_STATE_COMMENT);
    }

    @Override
    public void insertNote(Note note) {
        System.out.println(IDLE_STATE_COMMENT);
    }

    @Override
    public void dispenseProduct(Product product) {
        System.out.println(IDLE_STATE_COMMENT);
    }

    @Override
    public void returnChange() {
        System.out.println(IDLE_STATE_COMMENT);
    }
}
