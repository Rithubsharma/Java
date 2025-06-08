package org.example.vendingMachine.states;

import org.example.vendingMachine.enums.Coin;
import org.example.vendingMachine.enums.Note;
import org.example.vendingMachine.Product;
import org.example.vendingMachine.VendingMachine;
import org.example.vendingMachine.VendingState;

import static org.example.vendingMachine.constants.VMConstants.*;

public class DispenseState implements VendingState {
    private VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println(PRE_DISPENSE_STATE_COMMENT);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println(DISPENSE_STATE_COMMENT);
    }

    @Override
    public void insertNote(Note note) {
        System.out.println(DISPENSE_STATE_COMMENT);
    }

    @Override
    public void dispenseProduct(Product product) {
        product = vendingMachine.getSelectedProduct();
        vendingMachine.getInventory().addAndUpdateProduct(product, vendingMachine.getInventory().getInventory(product) - 1);
        System.out.println("Product dispensed: " + product.getName());
        vendingMachine.setState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println(POST_DISPENSE_STATE_COMMENT);
    }
}
