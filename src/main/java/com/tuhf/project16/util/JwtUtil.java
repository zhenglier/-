package com.tuhf.project16.util;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public class JwtUtil {
    private static final byte[] JWT_KEY = "master1145141919810".getBytes();
    private static final Long JWT_EXPIRE_TIME_MS = (long) (20 * 60 * 1000);

    public static JWTSigner signer() {
        return JWTSignerUtil.hs256(JWT_KEY);
    }

    public static String create(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Date now = new Date();

        JWT jwt = new JWT();
        jwt.setPayload("username", userDetails.getUsername());
        jwt.setIssuedAt(now);
        jwt.setExpiresAt(new Date(now.getTime() + JWT_EXPIRE_TIME_MS));
        return jwt.sign(signer());
    }

    public static boolean verify(String token) {
        return JWTUtil.verify(token, signer());
    }
}
