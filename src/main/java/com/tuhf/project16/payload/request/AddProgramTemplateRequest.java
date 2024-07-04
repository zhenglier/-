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
public class AddProgramTemplateRequest {
    private String programTemplateName;
    private Long originGovernmentId;
    private int type;
    private String data;
}
