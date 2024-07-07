package com.tuhf.project16.payload.vo;

import java.util.Date;

public record TransOutVO(
        String name,

        String carrierName,

        Date transInAt
) {
}
