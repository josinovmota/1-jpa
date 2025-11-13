package com.nemesis.training.types;

import java.math.BigDecimal;

public class Price {
    // Should auto-format like this: "R$ XX,XX"
    private final BigDecimal price;

    public Price(String price) {
        String normalized = normalize(price);
        validate(normalized);
        this.price = transform(normalized);
    }


    private String normalize(String price) {

        price = price.replace("R$", "").replace(" ", "").replace(",", ".").trim();

        return price;
    }


    private BigDecimal transform(String normalized) {

        return new BigDecimal(normalized);

    }


    private void validate(String normalized) {

        if (!normalized.matches("^\\d+\\.\\d{2}$")) {
            throw new IllegalArgumentException("ERROR: Price currency must be in BRL format");
        }
    }


    public BigDecimal value() {
        return this.price;
    }
}
