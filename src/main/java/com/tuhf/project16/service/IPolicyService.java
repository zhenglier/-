package com.tuhf.project16.service;

import com.tuhf.project16.model.Policy;
import com.tuhf.project16.payload.vo.PolicyTableVO;

import java.util.Collection;

public interface IPolicyService {
    int addPolicy(Policy policy);

    Policy getPolicyById(long id);
    Collection<Policy> getAllPolicies();
    Collection<Policy> getPoliciesByTags(Collection<String> tags);

    Collection<PolicyTableVO> getBriefsByTags(Collection<String> tags);
    Collection<PolicyTableVO> getAllBriefs();
    Collection<PolicyTableVO> getBriefsByPage(int page);

    int increaseClicks(long id);
}
