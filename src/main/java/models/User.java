package models;

public class User {

    String firstNameField;
    String lastNameField;
    String addressField;
    String metroField;
    String phoneField;

    public User(String firstNameField, String lastNameField, String metroField, String addressField, String phoneField) {
        this.firstNameField = firstNameField;
        this.lastNameField = lastNameField;
        this.metroField = metroField;
        this.addressField = addressField;
        this.phoneField = phoneField;
    }

    public String getFirstNameField() {
        return firstNameField;
    }

    public String getLastNameField() {
        return lastNameField;
    }

    public String getAddressField() {
        return addressField;
    }

    public String getMetroField() {
        return metroField;
    }

    public String getPhoneField() {
        return phoneField;
    }
}
