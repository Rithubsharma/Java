package org.example.vendingMachine.constants;

public abstract class VMConstants {

    public static final String IDLE_STATE_COMMENT = "Please select a product first.";

    public static final String READY_STATE_COMMENT = "Please make payment first.";
    public static final String PRE_DISPENSE_STATE_COMMENT = "Product already selected. Please make payment.";

    public static final String DISPENSE_STATE_COMMENT = "Payment already made. Please collect the dispensed product.";
    public static final String POST_DISPENSE_STATE_COMMENT = "Please collect the dispensed product first.";

    public static final String RETURN_CHANGE_STATE_COMMENT = "Please collect the change first.";
}
