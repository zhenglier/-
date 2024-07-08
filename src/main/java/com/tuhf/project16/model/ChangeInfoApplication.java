package com.tuhf.project16.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeInfoApplication {
    private Long id;

    private Long enterpriseId;

    private Long carrierId;

    private String before;

    private String after;

    private String material;

    private Date date;
}
