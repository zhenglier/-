package com.tuhf.project16.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoveApplication {
    private Long id;

    private Long enterpriseId;

    private Long carrierId;

    private Date moveAt;

    private String comment;

    private String status;
}
