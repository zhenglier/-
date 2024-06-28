package com.tuhf.project16.payload.response;

public record LoginResponse(
        String token,
        String username,
        String role
) {
}
