package com.tuhf.project16.payload.vo;

import java.util.Date;

public record EnterpriseInfoVO(
        Long companyId,

        String creditCode,

        String companyName,

        Integer registeredCapital,

        String essence,

        String industry,

        String address,

        Date registerAt,

        String operatorName,

        String owingCarrier,

        String business,

        Date incubationDate,

        String incubationStatus,

        String additionalData

) {
}
