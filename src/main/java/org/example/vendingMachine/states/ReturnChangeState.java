package org.example.vendingMachine.states;

import org.example.vendingMachine.Enums.Coin;
import org.example.vendingMachine.Enums.Note;
import org.example.vendingMachine.Product;
import org.example.vendingMachine.VendingMachine;
import org.example.vendingMachine.VendingState;

import static org.example.vendingMachine.constants.VMConstants.RETURN_CHANGE_STATE_COMMENT;

public class ReturnChangeState implements VendingState {
    private VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println(RETURN_CHANGE_STATE_COMMENT);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println(RETURN_CHANGE_STATE_COMMENT);
    }

    @Override
    public void insertNote(Note note) {
        System.out.println(RETURN_CHANGE_STATE_COMMENT);

    }

    @Override
    public void dispenseProduct(Product product) {
        System.out.println(RETURN_CHANGE_STATE_COMMENT);
    }

    @Override
    public void returnChange() {
        double change = vendingMachine.getTotalPayment() - vendingMachine.getSelectedProduct().getPrice();
        if (change > 0) {
            System.out.println("Change returned: $" + change);
        } else {
            System.out.println("No change to return.");
        }

        vendingMachine.resetPayment();
        vendingMachine.resetSelectedProduct();
        vendingMachine.setState(vendingMachine.getIdleState());
    }
}
