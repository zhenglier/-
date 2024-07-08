package com.tuhf.project16.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 30805
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProgramReviewRequest {
    int sourceType;
    Long sourceId;
    int destinationType;
    Long destinationId;
    Long applicationId;
    String data;
}
