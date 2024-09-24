package models;

public class Scooter {

    String deliveryDate;
    RentalDurationEnum rentalDuration;
    ColorScooterEnum color;
    String deliveryComment;

    public Scooter(String deliveryDate, RentalDurationEnum rentalDuration, ColorScooterEnum color, String deliveryComment) {
        this.deliveryDate = deliveryDate;
        this.rentalDuration = rentalDuration;
        this.color = color;
        this.deliveryComment = deliveryComment;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public RentalDurationEnum getRentalDuration() {
        return rentalDuration;
    }

    public ColorScooterEnum getColor() {
        return color;
    }

    public String getDeliveryComment() {
        return deliveryComment;
    }
}
