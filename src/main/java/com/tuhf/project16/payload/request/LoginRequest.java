package com.tuhf.project16.payload.request;

public record LoginRequest(
        String username,
        String password
) {
}
