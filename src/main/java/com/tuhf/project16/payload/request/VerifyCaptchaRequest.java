package com.tuhf.project16.payload.request;

public record VerifyCaptchaRequest(
        String uuid,
        String code
){
}
