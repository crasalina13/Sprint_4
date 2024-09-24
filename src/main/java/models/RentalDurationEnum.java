package models;

public enum RentalDurationEnum {

    ONE_DAY,
    TWO_DAYS,
    THREE_DAYS,
    FOUR_DAYS,
    FIVE_DAYS,
    SIX_DAYS,
    SEVEN_DAYS;

    public int getValue() {
        return this.ordinal();
    }
}
