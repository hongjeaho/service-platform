package com.platform.common.web.base.config;

import com.platform.common.web.base.config.converter.LocalDateConverter;
import com.platform.common.web.base.config.converter.LocalDateTimeConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new LocalDateConverter());
        registry.addConverter(new LocalDateTimeConverter());
    }
}
