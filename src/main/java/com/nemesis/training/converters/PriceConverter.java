package com.nemesis.training.converters;

import com.nemesis.training.types.Price;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PriceConverter implements AttributeConverter<Price, String> {

    @Override
    public String convertToDatabaseColumn(Price price) {
        return price == null ? null : price.value();
    }

    @Override
    public Price convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new Price(dbData);
    }
}
