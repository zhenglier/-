package com.tuhf.project16.model;

import com.tuhf.project16.payload.request.AddProgramTemplateRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录和权限管理部分的自定义用户对象
 * @author 30805
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramTemplate {
    private Long id;
    private String programTemplateName;
    private Long originGovernmentId;
    private int type;
    private String data;

    public ProgramTemplate(AddProgramTemplateRequest addProgramTemplateRequest) {
        this.programTemplateName = addProgramTemplateRequest.getProgramTemplateName();
        this.originGovernmentId = addProgramTemplateRequest.getOriginGovernmentId();
        this.type = addProgramTemplateRequest.getType();
        this.data = addProgramTemplateRequest.getData();
    }
}
