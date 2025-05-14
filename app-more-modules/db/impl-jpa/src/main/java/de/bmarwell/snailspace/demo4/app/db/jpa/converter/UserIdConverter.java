package de.bmarwell.snailspace.demo4.app.db.jpa.converter;

import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class UserIdConverter implements AttributeConverter<UserId, String> {

    @Override
    public String convertToDatabaseColumn(UserId attribute) {
        return attribute.value();
    }

    @Override
    public UserId convertToEntityAttribute(String dbData) {
        return new UserId(dbData);
    }
}
