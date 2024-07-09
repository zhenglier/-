package com.tuhf.project16.payload.request;

import java.util.Date;

/* 重大信息变更请求 */
public record ChangeInfoRequest (
        String type,
        String after,
        String material,
        Date date
){
}
