package com.tuhf.project16.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolicyBriefResponse {
    /* 政策id */
    private Long id;

    /* 标签 */
    private Set<String> tags;

    /* 发布者名称，这里为冗余数据，方便查询 */
    private String issuerName;

    /* 政策层级 */
    private String level;

    /* 标题 */
    private String title;

    /* 发布日期 */
    private Date createAt;

    /* 浏览量 */
    private int clicks;

}
