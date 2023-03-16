package com.herbalife.is.jwtdemo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class TokenService {

    @Resource
    @Qualifier("qaPrivateKey")
    private PrivateKey privateKey;

    @Resource
    @Qualifier("uatPrivateKey")
    private PrivateKey uatPrivateKey;

    @Resource
    @Qualifier("prodPrivateKey")
    private PrivateKey prodPrivateKey;

    @Resource
    @Qualifier("localPrivateKey")
    private PrivateKey localPrivateKey;

    public String createToken() throws JsonProcessingException {

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("alg", "RS256");
        headerMap.put("typ", "JWT");

        long millis = System.currentTimeMillis();

        return Jwts.builder()
                .setHeader(headerMap)
                .claim("iss", "admin-issuer-qa")
                //.setPayload(om.writeValueAsString(payload))
                .setExpiration(new Date(millis + 1200*1000))
                .setNotBefore(new Date(millis - 10*1000))
                .setIssuedAt(new Date(millis))
                .signWith(SignatureAlgorithm.RS256, privateKey)
                .compact();

    }

    public String createUATToken() throws JsonProcessingException {

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("alg", "RS256");
        headerMap.put("typ", "JWT");

        long millis = System.currentTimeMillis();

        return Jwts.builder()
                .setHeader(headerMap)
                .claim("iss", "admin-issuer-uat")
                //.setPayload(om.writeValueAsString(payload))
                .setExpiration(new Date(millis + 3600*1000))
                .setNotBefore(new Date(millis - 10*1000))
                .setIssuedAt(new Date(millis))
                .signWith(SignatureAlgorithm.RS256, uatPrivateKey)
                .compact();

    }

    public String createProdToken() throws JsonProcessingException {

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("alg", "RS256");
        headerMap.put("typ", "JWT");

        long millis = System.currentTimeMillis();

        return Jwts.builder()
                .setHeader(headerMap)
                .claim("iss", "admin-issuer-prod")
                //.setPayload(om.writeValueAsString(payload))
                .setExpiration(new Date(millis + 900*1000))
                .setNotBefore(new Date(millis - 10*1000))
                .setIssuedAt(new Date(millis))
                .signWith(SignatureAlgorithm.RS256, prodPrivateKey)
                .compact();

    }

    public String createLocalToken() throws JsonProcessingException {

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("alg", "RS256");
        headerMap.put("typ", "JWT");

        long millis = System.currentTimeMillis();

        return Jwts.builder()
                .setHeader(headerMap)
                .claim("iss", "jwt-deom")
                .setAudience("backend-api-application")
                .setIssuedAt(new Date(millis))
                .setSubject("test jwt")
                //.setPayload(om.writeValueAsString(payload))
                //.setExpiration(new Date(millis + 1200*1000))
                //.setNotBefore(new Date(millis - 10*1000))
                //.setIssuedAt(new Date(millis))
                .signWith(SignatureAlgorithm.RS256, localPrivateKey)
                .compact();

        /*{
            "jti": "123456",
                "iat": 1644384902,
                "sub": "test jwt",
                "iss": "jwt-deom",
                "aud": "backend-api-application"
        }*/

    }
}
