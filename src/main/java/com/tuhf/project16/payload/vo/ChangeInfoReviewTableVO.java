package com.tuhf.project16.payload.vo;

import java.util.Date;

public record ChangeInfoReviewTableVO (
        int number,
        String name,
        Date date,
        String kind,
        String result,
        Long appId
){
}
