package com.tuhf.project16.mapper;

import com.tuhf.project16.model.PerfApplication;
import com.tuhf.project16.model.PerfItem;
import com.tuhf.project16.model.PerfReview;
import com.tuhf.project16.model.PerfTemplate;

import java.util.Collection;

public interface PerformanceMapper {
    public int addTemplate(PerfTemplate perfTemplate);

    public PerfTemplate getTemplateById(long id);

    public Collection<PerfTemplate> getAllTemplates(long id);

    public int addItem(PerfItem perfItem);

    public PerfItem getItemById(long id);


    public Collection<PerfApplication> getItemsByIssuerId(long id);

    public int addApplication(PerfApplication perfApplication);

    public PerfApplication getApplicationByItemId(long itemId);

    public PerfApplication getApplicationByCarrierId(long carrierId);


    public int addReview(PerfReview perfReview);

    public PerfReview getReviewByAppId(long appId);

    public Collection<PerfReview> getReviewsForGov(long govId);

    public Collection<PerfReview> getReviewsForCarrier(long carrierId);
}
