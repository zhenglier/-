package com.tuhf.project16.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProgramReviewRequest {
    int sourceType;
    Long sourceId;
    String data;
}
