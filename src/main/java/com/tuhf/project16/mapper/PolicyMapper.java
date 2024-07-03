package com.tuhf.project16.mapper;

import com.tuhf.project16.model.Policy;
import com.tuhf.project16.payload.response.PolicyBriefResponse;

import java.util.Collection;
import java.util.Set;

public interface PolicyMapper {
    public int addPolicyWithoutTags(Policy policy);
    public int setTags(Long policyId, Set<String> tags);

    public Collection<Policy> getPolicies();
    public Collection<Policy> getPoliciesByTags(Collection<String> tags);
    public Policy getPolicyById(long id);

    public PolicyBriefResponse getBriefByTags(Collection<String> tags);
    public Collection<PolicyBriefResponse> getAllBriefs();

    public int increaseClicks(long id);
}
