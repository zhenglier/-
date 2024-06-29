package com.tuhf.project16.mapper;

import com.tuhf.project16.model.Policy;

public interface PolicyMapper {
    public int addPolicy(Policy policy);

    public Policy getPolicy(long id);
}
