package com.nemesis.training.types;

public class Phone {
    String phone;

    public Phone(String phone) {
        this.phone = validate(phone);
    }

    private String validate(String phone) {

        // +55 85 98191 0431 -> +5585981910431
        phone = phone.replaceAll("[^+\\d]", "");

        if (!Character.toString(phone.charAt(0)).equals("+")) {
            throw new IllegalArgumentException("ERROR: The '+' symbol was not found in the beginning of the Country Code");
        }

        if (phone.length() != 14) {
            throw new IllegalArgumentException("ERROR: Phone number must follow the Brazilian Number format: '+55 (XX) 9XXXX-XXXX'");
        }

        return phone;
    }
}
