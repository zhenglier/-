package com.tuhf.project16.service.impl;

import com.tuhf.project16.mapper.TransApplicationMapper;
import com.tuhf.project16.model.TransInApplication;
import com.tuhf.project16.model.TransOutApplication;
import com.tuhf.project16.service.ITransApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TransApplicationService implements ITransApplicationService {

    @Autowired
    TransApplicationMapper transApplicationMapper;

    @Override
    public int addTransOutApplication(TransOutApplication transOutApplication) {
        return 0;
    }

    @Override
    public int addTransInApplication(TransInApplication transInApplication) {
        return 0;
    }

    @Override
    public Collection<TransInApplication> getInByCarrierId(long carrierId) {
        return transApplicationMapper.getInByCarrierId(carrierId);
    }

    @Override
    public Collection<TransOutApplication> getOutByCarrierId(long carrierId) {
        return transApplicationMapper.getOutByCarrierId(carrierId);
    }

}
