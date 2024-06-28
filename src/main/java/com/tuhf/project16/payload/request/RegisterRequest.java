package com.tuhf.project16.payload.request;

public record RegisterRequest(
        String username,
        String password,
        String role
) {
}
