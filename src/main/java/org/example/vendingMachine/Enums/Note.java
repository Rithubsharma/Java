package org.example.vendingMachine.Enums;

public enum Note {
    ONE(1),
    FIVE(5),
    TEN(10),
    TWENTY(20);


    private Integer value;

    Note(Integer value){
        this.value = value;
    }

    public Integer getValue(){
        return this.value;
    }

}
