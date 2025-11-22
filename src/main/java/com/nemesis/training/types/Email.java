package com.nemesis.training.types;

import java.util.regex.Pattern;

public class Email {
    private final String email;

    public Email(String email) {
        validate(email);
        this.email = email;
    }

    private void validate(String email) {
        if (!Pattern.matches(".*@gmail.com", email)) {
            throw new IllegalArgumentException("ERROR: Your email should match the following format '<username>@gmail.com'");
        }
    }

    public String value() {
        return email;
    }
}
