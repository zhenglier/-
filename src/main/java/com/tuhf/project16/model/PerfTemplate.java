package com.tuhf.project16.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 绩效考察模板
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("pf_template")
public class PerfTemplate implements Serializable {
    @TableId
    private Long id;

    private String name;

    private String data;
}
