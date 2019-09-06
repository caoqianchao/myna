package com.ecpess.myna.testport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = "com.ecpess.myna")
@PropertySource("file:/web/profile/myna/configure.properties")
@ServletComponentScan
public class BootstrapApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BootstrapApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }

}

