package com.tuhf.project16.service;

import com.tuhf.project16.model.Policy;

public interface IPolicyService {
    public int addPolicy(Policy policy);

    public Policy getPolicyById(long id);
}
