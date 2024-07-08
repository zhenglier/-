package com.tuhf.project16.model;

import com.tuhf.project16.payload.request.AddProgramReviewRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 30805
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramReview {
    Long id;
    int sourceType;
    Long sourceId;
    int destinationType;
    Long destinationId;
    Long applicationId;
    String data;
    public ProgramReview(AddProgramReviewRequest addProgramReviewRequest) {
        sourceId=addProgramReviewRequest.getSourceId();
        sourceType=addProgramReviewRequest.getSourceType();
        destinationId=addProgramReviewRequest.getDestinationId();
        destinationType=addProgramReviewRequest.getDestinationType();
        applicationId=addProgramReviewRequest.getApplicationId();
        data=addProgramReviewRequest.getData();
    }
}
