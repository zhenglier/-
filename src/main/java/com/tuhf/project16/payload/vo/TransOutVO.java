package com.tuhf.project16.payload.vo;

import java.util.Date;

/**
 * 搬离申请界面展示的信息
 * @param name
 * @param carrierName
 * @param transInAt
 */
public record TransOutVO(
        String name,

        String carrierName,

        Date transInAt
) {
}
