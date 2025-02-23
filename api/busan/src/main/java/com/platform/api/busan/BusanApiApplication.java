package com.platform.api.busan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {
        "com.platform.common.web.base",
        "com.platform.common.datasource.base",
        "com.platform.api.busan",
})
public class BusanApiApplication {
    public static void main(final String[] args) {
        SpringApplication.run(BusanApiApplication.class, args);
    }
}
