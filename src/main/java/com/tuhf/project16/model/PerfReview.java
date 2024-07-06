package com.tuhf.project16.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerfReview implements Serializable {
    private Long id;

    private Long appId;

    private int score;

    private String comment;

}
