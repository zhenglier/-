package com.tuhf.project16.service.impl;

import com.tuhf.project16.mapper.PolicyMapper;
import com.tuhf.project16.model.Policy;
import com.tuhf.project16.payload.response.PolicyBriefResponse;
import com.tuhf.project16.service.IPolicyService;
import com.tuhf.project16.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PolicyServiceImpl implements IPolicyService {
    private static final int PAGE_SIZE = 2;

    @Autowired
    PolicyMapper policyMapper;

    @Override
    public int addPolicy(Policy policy) {
        int rows = policyMapper.addPolicyWithoutTags(policy);
        policyMapper.setTags(policy.getId(), policy.getTags());
        return rows;
    }

    @Override
    public Policy getPolicyById(long id) {
        return policyMapper.getPolicyById(id);
    }

    @Override
    public Collection<Policy> getAllPolicies() {
        return policyMapper.getPolicies();
    }

    @Override
    public Collection<Policy> getPoliciesByTags(Collection<String> tags) {
        return policyMapper.getPoliciesByTags(tags);
    }

    @Override
    public PolicyBriefResponse getBriefByTags(Collection<String> tags) {
        return policyMapper.getBriefByTags(tags);
    }

    @Override
    public Collection<PolicyBriefResponse> getAllBriefs() {
        return policyMapper.getAllBriefs();
    }

    @Override
    public Collection<PolicyBriefResponse> getBriefsByPage(int page) {
        return policyMapper.getBriefsByPage(PageUtil.calOffset(page, PAGE_SIZE), PAGE_SIZE);
    }

    @Override
    public int increaseClicks(long id) {
        return policyMapper.increaseClicks(id);
    }
}
