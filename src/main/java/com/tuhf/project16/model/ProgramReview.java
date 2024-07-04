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
    String data;
    public ProgramReview(AddProgramReviewRequest addProgramReviewRequest) {
        sourceId=addProgramReviewRequest.getSourceId();
        sourceType=addProgramReviewRequest.getSourceType();
        data=addProgramReviewRequest.getData();
    }
}
