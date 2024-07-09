package com.tuhf.project16.payload.vo;

import java.util.Map;

/**
 * 填写入驻申请时，展示可选的载体
 * @param carrierList
 */
public record TransInVO(
        /* 载体名称和id对应 */
        Map<Long, String> carrierList
) {
}
