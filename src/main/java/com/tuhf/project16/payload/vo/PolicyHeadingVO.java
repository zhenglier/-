package com.tuhf.project16.payload.vo;

import java.util.Date;

/* 政策兑现界面的最简展示 */
public record PolicyHeadingVO(
    Long id,
    String title,
    Date date
){}
