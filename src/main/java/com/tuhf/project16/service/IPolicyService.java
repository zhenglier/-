package com.tuhf.project16.service;

import com.tuhf.project16.model.Policy;
import com.tuhf.project16.payload.response.PolicyBriefResponse;

import java.util.Collection;

public interface IPolicyService {
    int addPolicy(Policy policy);

    Policy getPolicyById(long id);
    Collection<Policy> getAllPolicies();
    Collection<Policy> getPoliciesByTags(Collection<String> tags);

    PolicyBriefResponse getBriefByTags(Collection<String> tags);
    Collection<PolicyBriefResponse> getAllBriefs();
    Collection<PolicyBriefResponse> getBriefsByPage(int page);

    int increaseClicks(long id);
}
