package com.tuhf.project16.payload.vo;

public record CaptchaVO(
        String code,
        byte[] image
){
}
