package com.tuhf.project16.mapper;

import com.tuhf.project16.model.Policy;
import com.tuhf.project16.payload.response.PolicyBriefResponse;

import java.util.Collection;
import java.util.Set;

public interface PolicyMapper {
    int addPolicyWithoutTags(Policy policy);
    int setTags(Long policyId, Set<String> tags);

    Collection<Policy> getPolicies();
    Collection<Policy> getPoliciesByTags(Collection<String> tags);
    Policy getPolicyById(long id);

    PolicyBriefResponse getBriefByTags(Collection<String> tags);
    Collection<PolicyBriefResponse> getAllBriefs();
    Collection<PolicyBriefResponse> getBriefsByPage(int offset, int limit);

    int increaseClicks(long id);
}
