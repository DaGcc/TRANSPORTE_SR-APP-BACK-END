package com.org.tr.util;


import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

//este utilitario es con fecha
@Converter(autoApply=true)
public class MyLocalDateConverter implements AttributeConverter<java.time.LocalDate,java.sql.Date> {

    @Override
    public java.sql.Date convertToDatabaseColumn(java.time.LocalDate attribute) {
        return attribute ==null? null: java.sql.Date.valueOf(attribute);
    }

    @Override
    public java.time.LocalDate convertToEntityAttribute(java.sql.Date dbData) {
        return dbData == null? null: dbData.toLocalDate();
    }
    
    
    
}
