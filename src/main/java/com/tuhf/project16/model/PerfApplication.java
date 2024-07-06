package com.tuhf.project16.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 绩效考察申请项
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("pf_apply_item")
public class PerfApplication implements Serializable {
    @TableId
    private Long itemId;

    private Long carrierId;

    private String status;

    private String data;

}
