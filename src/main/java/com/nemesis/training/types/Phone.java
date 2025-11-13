package com.nemesis.training.types;

public class Phone {
    private final String phone;

    public Phone(String phone) {
        this.phone = normalize(phone);
        validate(this.phone);
    }


    private String normalize(String phone) {
        // Phone model: Brazilian Format +XX (XX) XXXXX-XXXX Input should auto-format +, () and -

        phone = phone.replaceAll("[^\\d]", "");

        return phone;
    }


    private void validate(String phone) {

        if (phone.length() != 13) {
            throw new IllegalArgumentException("ERROR: Phone number must follow the Brazilian Number format with 13 Digits. " +
                    "Your phone number has '" + phone.length() + "' Digits, be sure to enter '13' Digits");
        }
    }


    public String value() {
        return this.phone;
    }
}
