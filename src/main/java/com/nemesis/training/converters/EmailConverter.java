package com.nemesis.training.converters;

import jakarta.persistence.Converter;
import com.nemesis.training.types.Email;

import javax.persistence.AttributeConverter;

@Converter(autoApply = true)
public class EmailConverter implements AttributeConverter<Email, String> {

    @Override
    public String convertToDatabaseColumn(Email email) {
        return email == null ? null : email.value();
    }

    @Override
    public Email convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new Email(dbData);
    }

}
