package com.tuhf.project16.service.impl;

import com.tuhf.project16.mapper.ChangeInfoApplicationMapper;
import com.tuhf.project16.model.ChangeInfoApplication;
import com.tuhf.project16.service.IChangeInfoApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ChangeInfoApplicationService implements IChangeInfoApplicationService {

    @Autowired
    ChangeInfoApplicationMapper changeInfoApplicationMapper;

    @Override
    public int addApplication(ChangeInfoApplication application) {
        return changeInfoApplicationMapper.addApplication(application);
    }

    @Override
    public Collection<ChangeInfoApplication> getApplicationsByCarrierId(long carrierId) {
        return changeInfoApplicationMapper.getApplicationsByCarrierId(carrierId);
    }
}
