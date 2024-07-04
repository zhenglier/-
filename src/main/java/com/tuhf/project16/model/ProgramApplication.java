package com.tuhf.project16.model;

import com.tuhf.project16.payload.request.AddProgramApplicationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author 30805
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramApplication {
    Long id;
    String programApplicationName;
    Long sourceId;
    int sourceType;
    Long destinationId;
    int destinationType;
    Long programTemplateId;
    String data;

    public ProgramApplication(AddProgramApplicationRequest addProgramApplicationRequest) {
        programApplicationName = addProgramApplicationRequest.getProgramApplicationName();
        sourceId = addProgramApplicationRequest.getSourceId();
        sourceType = addProgramApplicationRequest.getSourceType();
        destinationId = addProgramApplicationRequest.getDestinationId();
        destinationType = addProgramApplicationRequest.getDestinationType();
        programTemplateId = addProgramApplicationRequest.getProgramTemplateId();
        data = addProgramApplicationRequest.getData();
    }
}
