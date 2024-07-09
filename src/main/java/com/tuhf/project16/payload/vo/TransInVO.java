package com.tuhf.project16.payload.vo;

import java.util.Map;

public record TransInVO(
        /* 载体名称和id对应 */
        Map<Long, String> carrierList
) {
}
