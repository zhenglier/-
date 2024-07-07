package com.tuhf.project16.payload.request;

import java.util.Date;
import java.util.Set;

public record AddPolicyRequest(
        /* 标签 */
        Set<String>tags,

        /* 政策层级 */
        String level,

        /* 文号 */
        String serial,

        /* 标题 */
        String title,

        /* 正文内容 */
        String content,

        /* 附件列表 */
        String fileList
) {
}
