package com.tuhf.project16.model;

import lombok.*;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Policy {
    /* 政策id */
    private Long id;

    /* 标签 */
    private Set<String> tags;

    /* 发布者id，这里为政务对象id */
    private Long issuerId;

    /* 发布者名称，这里为冗余数据，方便查询 */
    private String issuerName;

    /* 政策层级 */
    private String level;

    /* 文号 */
    private String serial;

    /* 标题 */
    private String title;

    /* 发布日期 */
    private Date createAt;

    /* 浏览量 */
    private int clicks;

    /* 正文内容 */
    private String content;

    /* 附件列表 */
    private String fileList;

}
