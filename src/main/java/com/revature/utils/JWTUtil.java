package com.revature.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTUtil {
	
    private static final String secret ="Random words so I can pretend I didn't copy/paste ben's code";
    private static final Algorithm algorithm = Algorithm.HMAC256(secret);

  
    public static String generate(String username, String password){

        // builder design pattern
        String token = JWT.create()
                .withClaim("username", username) 
                .withClaim("password", password)
                .sign(algorithm); 

        return  token;
    }

    public static DecodedJWT isValidJWT(String token){
            DecodedJWT jwt = JWT.require(algorithm).build().verify(token);
            return  jwt;
    }
}
