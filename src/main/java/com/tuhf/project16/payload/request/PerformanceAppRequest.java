package com.tuhf.project16.payload.request;

// 从浏览器交上来的填写的东西
public record PerformanceAppRequest(
        Long template_id,
        String data
) {

}
