package com.nemesis.training.converters;

import com.nemesis.training.types.TotalPrice;
import javax.persistence.Converter;

import javax.persistence.AttributeConverter;

@Converter(autoApply = true)
public class TotalPriceConverter implements AttributeConverter<TotalPrice, String> {

    @Override
    public String convertToDatabaseColumn(TotalPrice totalPrice) {
        return totalPrice == null ? null : totalPrice.toString();
    }

    @Override
    public TotalPrice convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new TotalPrice(dbData);
    }
}
