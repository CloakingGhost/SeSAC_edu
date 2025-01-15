package com.example.relation.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // application.properties 값 가져오기
    // 시그니처를 위한 시크릿 키
    // 서비스 때는 시간 짧게
    @Value("${jwt.secret}")
    private String secretKey;


    // application.properties 값 만들어서 사용할 수 있음
//    private final long tokenValidityInMilliseconds = 1000L * 60 * 60 ; // 1시간
    private final long tokenValidityInMilliseconds = 1000L * 60 * 60 * 24; // 24시간

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(Authentication authentication) {
        // 유저 식별
        String username = authentication.getName();

        // 값(payload)을 넣어주기 위한 장치
        // 이름 넣어 줌
        Claims claims = Jwts.claims().setSubject(username);

        // 유효기간
        Date now = new Date();
        Date validity = new Date(now.getTime() + tokenValidityInMilliseconds);

        return Jwts.builder()
                // payload, pk??
                .setClaims(claims)
                // 만든 시간
                .setIssuedAt(now)
                // 만료시간
                .setExpiration(validity)
                // signature
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                    .build()
                    .parseClaimsJws(token); // 서명과 비교
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}