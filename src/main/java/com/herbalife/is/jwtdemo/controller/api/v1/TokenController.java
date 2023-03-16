package com.herbalife.is.jwtdemo.controller.api.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.herbalife.is.jwtdemo.util.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class TokenController {

    @Autowired
    private TokenService tokenService;


    private static final String h = "Bearer ";

    @GetMapping("/token")
    public String generateToken() throws JsonProcessingException {
        return h + tokenService.createToken();
    }

    @GetMapping("/uattoken")
    public String generateUATToken() throws JsonProcessingException {
        return h + tokenService.createUATToken();
    }

    @GetMapping("/prodtoken")
    public String generateProdToken() throws JsonProcessingException {
        return h + tokenService.createProdToken();
    }

}
