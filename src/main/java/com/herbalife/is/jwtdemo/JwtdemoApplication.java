package com.herbalife.is.jwtdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
public class JwtdemoApplication extends SpringBootServletInitializer {

    //
    public static void main(String[] args) {
        SpringApplication.run(JwtdemoApplication.class, args);

        //Dec 26, 2020 7:54:23 PM
        //LocalDateTime dateTime = LocalDateTime.parse("2020-12-26T15:54:23");
        //Instant instant = dateTime.atZone(ZoneId.of("Asia/Shanghai")).toInstant();
        //System.out.println(dateTime.atZone(ZoneOffset.UTC).toEpochSecond());
        //Instant instant = dateTime.toInstant(TimeZone.getTimeZone("ECT"));
        //Date date = Date.from()

        output(JwtdemoApplication.class);
    }

    public static void output(Class clazz){
        System.out.println(clazz.getName());
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }
}
