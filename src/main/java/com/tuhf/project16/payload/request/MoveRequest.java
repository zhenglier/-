package com.tuhf.project16.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoveRequest {
    private Long enterpriseId;

    private Long carrierId;

    private Date moveAt;

    private String comment;
}
