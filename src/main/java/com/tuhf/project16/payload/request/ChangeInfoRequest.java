package com.tuhf.project16.payload.request;

import java.util.Date;

public record ChangeInfoRequest (
        String type,
        String after,
        String material,
        Date date
){
}
