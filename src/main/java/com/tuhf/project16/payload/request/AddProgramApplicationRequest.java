package com.tuhf.project16.payload.request;

import com.tuhf.project16.model.ProgramApplication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 30805
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProgramApplicationRequest{
    String programApplicationName;
    Long sourceId;
    int sourceType;
    Long destinationId;
    int destinationType;
    Long programTemplateId;
    String data;
}
