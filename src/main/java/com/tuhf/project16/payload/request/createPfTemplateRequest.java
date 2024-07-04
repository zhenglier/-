package com.tuhf.project16.payload.request;

public record createPfTemplateRequest(
        int id,
         String name,
         String json_data) {
}
