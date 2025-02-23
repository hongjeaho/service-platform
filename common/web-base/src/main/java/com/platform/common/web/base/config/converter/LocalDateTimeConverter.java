package com.platform.common.web.base.config.converter;

import java.time.LocalDateTime;

import com.platform.common.base.type.LocalDateFormat;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {

    @Override
    public LocalDateTime convert(final @NonNull String value) {
        return LocalDateTime.parse(value, LocalDateFormat.DATE_TIME.getFormatter());
    }
}