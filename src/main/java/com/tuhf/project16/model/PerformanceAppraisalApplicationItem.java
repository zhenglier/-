package com.tuhf.project16.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@TableName("pf_apply_item")
public class PerformanceAppraisalApplicationItem implements Serializable {//绩效考察申请项
    @TableId
    private int pf_item_id;
    private String fill_in_data;
    private String carrier_name;
    private int score;

    public PerformanceAppraisalApplicationItem(int pf_item_id, String fill_in_data, String carrier_name, int score) {
        this.pf_item_id = pf_item_id;







































































        this.fill_in_data = fill_in_data;
        this.carrier_name = carrier_name;
        this.score = score;
    }
}
