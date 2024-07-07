package com.tuhf.project16.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public record ChangeInfoRequest (
        String type,
        String after,
        String material,
        Date date
){
}
