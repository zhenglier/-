package com.tuhf.project16.mapper;

import com.tuhf.project16.model.TransInApplication;
import com.tuhf.project16.model.TransOutApplication;

import java.util.Collection;

public interface TransApplicationMapper {

    public int addIn(TransInApplication application);

    public int addOut(TransOutApplication application);

    public Collection<TransInApplication> getInByCarrierId(long carrierId);

    public Collection<TransOutApplication> getOutByCarrierId(long carrierId);

    public TransOutApplication getInById(long id);

    public TransInApplication getOutById(long id);

    public int setInStatus(long id, String status);

    public int setOutStatus(long id, String status);
}
