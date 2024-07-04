package com.tuhf.project16.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@TableName("pf_item")
public class PerformanceAppraisalItem implements Serializable {//绩效考察项
    @TableId
    private int id;
    private int template_id=-1;
    //basicInfo
    private String name;
    private String type;
    private Date begin_date;
    private Date end_date;
    private String pf_year;
    private String description;

    public PerformanceAppraisalItem(int id, int template_id, String name, String type, Date begin_date, Date end_date, String performance_year, String description) {
        this.id = id;
        this.template_id = template_id;
        this.name = name;
        this.type = type;
        this.begin_date = begin_date;
        this.end_date = end_date;
        this.pf_year = performance_year;
        this.description = description;
    }
}
