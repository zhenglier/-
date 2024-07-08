package com.tuhf.project16.payload.vo;

import java.util.Date;

/** 入驻审批的两个表格 */
public record TransInOutReviewTableVO(
    Integer index,

    /* 统一信用代码 */
    String unicode,

    String name,

    Date date,

    /* 不需要用到时忽略 */
    String applyCondition,

    /* 申请对象的id，不显示，但需要保存，发请求时需要用到 */
    Long appId
){
}
