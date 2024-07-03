package com.tuhf.project16.service;

import com.tuhf.project16.model.Policy;
import com.tuhf.project16.payload.response.PolicyBriefResponse;

import java.util.Collection;

public interface IPolicyService {
    public int addPolicy(Policy policy);

    public Policy getPolicyById(long id);
    public Collection<Policy> getAllPolicies();
    public Collection<Policy> getPoliciesByTags(Collection<String> tags);

    public PolicyBriefResponse getBriefByTags(Collection<String> tags);
    public Collection<PolicyBriefResponse> getAllBriefs();

    public int increaseClicks(long id);
}
