package com.platform.common.web.base.config.converter;

import java.time.LocalDate;

import com.platform.common.base.type.LocalDateFormat;
import org.springframework.core.convert.converter.Converter;


public class LocalDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(final String value) {
        return LocalDate.parse(value, LocalDateFormat.DATE.getFormatter());
    }
}