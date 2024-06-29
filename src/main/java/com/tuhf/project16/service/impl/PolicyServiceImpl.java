package com.tuhf.project16.service.impl;

import com.tuhf.project16.mapper.PolicyMapper;
import com.tuhf.project16.model.Policy;
import com.tuhf.project16.service.IPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyServiceImpl implements IPolicyService {

    @Autowired
    PolicyMapper policyMapper;

    @Override
    public int addPolicy(Policy policy) {
        return policyMapper.addPolicy(policy);
    }

    @Override
    public Policy getPolicyById(long id) {
        return policyMapper.getPolicy(id);
    }
}
