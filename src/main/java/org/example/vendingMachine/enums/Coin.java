package org.example.vendingMachine.enums;

public enum Coin {
    PENNY(0.01),
    NICKEL(0.05),
    DIME(0.1),
    QUARTER(0.25);


    private Double value;

    Coin(Double value){
        this.value = value;
    }

    public Double getValue(){
        return this.value;
    }

}
