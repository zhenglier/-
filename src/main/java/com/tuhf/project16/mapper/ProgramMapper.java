package com.tuhf.project16.mapper;

import com.tuhf.project16.model.ProgramApplication;
import com.tuhf.project16.model.ProgramReview;
import com.tuhf.project16.model.ProgramTemplate;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author 30805
 */
public interface ProgramMapper {

    void addProgramTemplate(ProgramTemplate programTemplate);

    ProgramTemplate getProgramTemplateById(Long id);

    Collection<ProgramTemplate> getProgramTemplatesByType(int type);

    Collection<ProgramTemplate> getProgramTemplatesByGovernmentId(long governmentId);

    void addProgramApplication(ProgramApplication programApplication);

    ProgramApplication getProgramApplicationById(Long id);

    /**
        type企业enterprise为0，载体carrier为1，政务government为2
        id,type不受限制则填写-1
     */
    Collection<ProgramApplication> getProgramApplications(long sourceId, long sourceType,
                                                          long destinationId, long destinationType);
    ProgramReview getProgramReviewById(Long id);

    void addProgramReview(ProgramReview programReview);

}
