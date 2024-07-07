package com.tuhf.project16.model;

import com.tuhf.project16.payload.request.TransOutRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransOutApplication {
    private Long id;

    private Long enterpriseId;

    private Long carrierId;

    private Date transOutAt;

    private String comment;

    private String additionalData;

    private String status;
}
