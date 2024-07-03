package com.tuhf.project16.util;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {
    private static final byte[] JWT_KEY = "master1145141919810".getBytes();
//    private static final Long JWT_EXPIRE_TIME_MS = (long) (20 * 60 * 1000);
    private static final Long JWT_EXPIRE_TIME_MS = (long) (1 * 1000);

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public JWTSigner signer() {
        return JWTSignerUtil.hs256(JWT_KEY);
    }

    public String create(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        // Date now = new Date();

        JWT jwt = new JWT();
        jwt.setPayload("username", userDetails.getUsername());
        jwt.setPayload("role", userDetails.getAuthorities().iterator().next().getAuthority());
        /* expiration now implemented by redis cache
        jwt.setIssuedAt(now);
        jwt.setExpiresAt(new Date(now.getTime() + JWT_EXPIRE_TIME_MS));
        */
        String token = jwt.sign(signer());

        redisTemplate.opsForValue().set(
                token,
                "",
                JWT_EXPIRE_TIME_MS,
                TimeUnit.MILLISECONDS
                );

        return token;
    }

    public boolean verify(String token) {
        return redisTemplate.opsForValue().get(token) != null;
    }
}
