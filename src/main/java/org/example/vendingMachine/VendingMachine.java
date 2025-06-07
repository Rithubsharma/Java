package org.example.vendingMachine;

import org.example.vendingMachine.Enums.Coin;
import org.example.vendingMachine.Enums.Note;
import org.example.vendingMachine.states.DispenseState;
import org.example.vendingMachine.states.IdleState;
import org.example.vendingMachine.states.ReadyState;
import org.example.vendingMachine.states.ReturnChangeState;

public class VendingMachine {
    private static VendingMachine vendingMachineInstance;
    private Inventory inventory;
    private Product selectedProduct;
    private VendingState currentState;
    private Double totalPayment;
    private final VendingState idleState;
    private final VendingState readyState;
    private final VendingState dispenseState;
    private final VendingState returnChangeState;

    private VendingMachine(){
        inventory = new Inventory();
        selectedProduct = null;
        totalPayment = 0.0;
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        currentState = idleState;
    }

    public static synchronized VendingMachine getInstance(){
        if(vendingMachineInstance == null){
            vendingMachineInstance = new VendingMachine();
        }
        return  vendingMachineInstance;
    }

    public Product addProduct(String name, double price, int quantity) {
        Product product = new Product(name, price);
        inventory.addAndUpdateProduct(product, quantity);
        return product;
    }

    public void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        currentState.insertNote(note);
    }

    public void dispenseProduct(Product product) {
        currentState.dispenseProduct(product);
    }

    public void returnChange() {
        currentState.returnChange();
    }

    public void setState(VendingState state) {
        currentState = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public VendingState getIdleState() {
        return idleState;
    }

    public VendingState getReadyState() {
        return readyState;
    }

    public VendingState getDispenseState() {
        return dispenseState;
    }

    public VendingState getReturnChangeState() {
        return returnChangeState;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product product) {
        selectedProduct = product;
    }

    public void resetSelectedProduct() {
        selectedProduct = null;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void addCoin(Coin coin) {
        totalPayment += coin.getValue();
    }

    public void addNote(Note note) {
        totalPayment += note.getValue();
    }

    public void resetPayment() {
        totalPayment = 0.0;
    }
}
