package com.tuhf.project16.payload.request;

import java.util.Date;

public record TransOutRequest(
    Date transOutAt,

    /* 搬离类型 */
    String type,

    /* 原因 */
    String comment,

    /* JSON 享受政策类型放这里 */
    String additionalData
) {
}
