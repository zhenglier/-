package com.tuhf.project16.mapper;

import com.tuhf.project16.model.ChangeInfoApplication;

import java.util.Collection;

public interface ChangeInfoApplicationMapper {
    int addApplication(ChangeInfoApplication application);

    Collection<ChangeInfoApplication> getApplicationsByCarrierId(long carrierId);
}
