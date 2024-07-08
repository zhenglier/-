package com.tuhf.project16.service.impl;

import com.tuhf.project16.mapper.PerformanceMapper;
import com.tuhf.project16.model.PerfApplication;
import com.tuhf.project16.model.PerfItem;
import com.tuhf.project16.model.PerfReview;
import com.tuhf.project16.model.PerfTemplate;
import com.tuhf.project16.service.IPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PerformanceService implements IPerformanceService {

    @Autowired
    PerformanceMapper performanceMapper;

    @Override
    public int addTemplate(PerfTemplate perfTemplate) {
        return performanceMapper.addTemplate(perfTemplate);
    }

    @Override
    public PerfTemplate getTemplateById(long id) {
        return performanceMapper.getTemplateById(id);
    }

    @Override
    public Collection<PerfTemplate> getAllTemplates() {
        return List.of();
    }

    @Override
    public int addItem(PerfItem perfItem) {
        return performanceMapper.addItem(perfItem);
    }

    @Override
    public PerfItem getItemById(long id) {
        return performanceMapper.getItemById(id);
    }

    @Override
    public Collection<PerfApplication> getItemsByIssuerId(long issuerId) {
        return performanceMapper.getItemsByIssuerId(issuerId);
    }

    @Override
    public int addApplication(PerfApplication perfApplication) {
        return performanceMapper.addApplication(perfApplication);
    }

    @Override
    public PerfApplication getApplicationByItemId(long itemId) {
        return performanceMapper.getApplicationByItemId(itemId);
    }

    @Override
    public PerfApplication getApplicationByCarrierId(long carrierId) {
        return performanceMapper.getApplicationByCarrierId(carrierId);
    }

    @Override
    public int addReview(PerfReview perfReview) {
        return performanceMapper.addReview(perfReview);
    }

    @Override
    public Collection<PerfReview> getReviewsForGov(long govId) {
        return performanceMapper.getReviewsForGov(govId);
    }

    @Override
    public Collection<PerfReview> getReviewsForCarrier(long carrierId) {
        return performanceMapper.getReviewsForCarrier(carrierId);
    }

    @Override
    public PerfReview getReviewByAppId(long appId) {
        return performanceMapper.getReviewByAppId(appId);
    }
}
