package com.herbalife.is.jwtdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.herbalife.is.jwtdemo.util.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class JwtdemoApplicationTests {

    @Autowired
    private TokenService tokenService;

    @Test
    void qaToken() throws JsonProcessingException {
        log.info(tokenService.createToken());
    }

    @Test
    void uatToken() throws JsonProcessingException {
        log.info(tokenService.createUATToken());
    }

    @Test
    void prodToken() throws JsonProcessingException {
        log.info(tokenService.createProdToken());
    }

    @Test
    void localToken() throws JsonProcessingException {
        log.info(tokenService.createLocalToken());
    }
}
