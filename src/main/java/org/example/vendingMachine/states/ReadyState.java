package org.example.vendingMachine.states;

import org.example.vendingMachine.Enums.Coin;
import org.example.vendingMachine.Enums.Note;
import org.example.vendingMachine.Product;
import org.example.vendingMachine.VendingMachine;
import org.example.vendingMachine.VendingState;

import static org.example.vendingMachine.constants.VMConstants.READY_STATE_COMMENT;

public class ReadyState implements VendingState {
    private VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected. Please make payment.");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("Coin inserted: " + coin);
        checkPaymentStatus();
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        System.out.println("Note inserted: " + note);
        checkPaymentStatus();
    }

    @Override
    public void dispenseProduct(Product product) {
        System.out.println(READY_STATE_COMMENT);
    }

    @Override
    public void returnChange() {
        System.out.println(READY_STATE_COMMENT);
    }

    private void checkPaymentStatus() {
        if (vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getPrice()) {
            vendingMachine.setState(vendingMachine.getDispenseState());
        }
    }
}
