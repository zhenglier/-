package com.tuhf.project16.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
@Data
@NoArgsConstructor
public class PerformanceExamineItem implements Serializable {
    private String pf_name;
    private String carrier_name;
    private Date end_date;
    private int score;

    public PerformanceExamineItem(String pf_name, String carrier_name, Date end_date, int score) {
        this.pf_name = pf_name;
        this.carrier_name = carrier_name;
        this.end_date = end_date;
        this.score = score;
    }
}
