package com.tuhf.project16.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * 绩效考察项
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("pf_item")
public class PerfItem implements Serializable {
    @TableId
    private Long id;

    private Long issuerId;

    private Long templateId;

    private String name;

    private String type;

    private Date beginDate;

    private Date endDate;

    private String year;

    private String description;

}
