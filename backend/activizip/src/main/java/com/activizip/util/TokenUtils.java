package com.activizip.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@AllArgsConstructor
public class TokenUtils {

    private static final long EXPIRE_TIME = 120 * 60 * 1000;
    private static final String TOKEN_SECRET = "act1v1Z1pasS";

    public static String createToken(String email, String password) {
        //Method to create a token
        return JWT.create()
                .withHeader(Map.of("typ", "JWT", "alg", "HS256"))
                .withClaim("email", email)
                .withClaim("password", password)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .sign(Algorithm.HMAC256(TOKEN_SECRET));
    }

    public static Pair<String, String> getTokenInfo(String token) {
        //Method to verify the token information returning the user email and password
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            String tokenEmail = decodedJWT.getClaim("email").asString();
            String tokenPassword = decodedJWT.getClaim("password").asString();
            return Pair.of(tokenEmail, tokenPassword);
        } catch (Exception e) {
            return Pair.of("null", "null");
        }
    }
}
