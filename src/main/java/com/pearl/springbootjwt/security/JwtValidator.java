package com.pearl.springbootjwt.security;

import com.pearl.springbootjwt.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    private String Secret = "pearl";

    public JwtUser validate(String token) {


        JwtUser jwtUser = null;

        try {
        Claims claims = Jwts.parser()
                .setSigningKey(Secret)
                .parseClaimsJws(token)
                .getBody();

        jwtUser = new JwtUser();

        jwtUser.setUserName(claims.getSubject());
        jwtUser.setId(Long.parseLong((String) claims.get("userId")));

            jwtUser.setRole((String)claims.get("role"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jwtUser;
    }
}
