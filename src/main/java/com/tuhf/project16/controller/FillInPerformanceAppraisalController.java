package com.tuhf.project16.controller;

import com.tuhf.project16.model.PerformanceAppraisalTemplate;
import com.tuhf.project16.payload.request.fillInDataRequest;
import com.tuhf.project16.service.PerformanceService;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/performance")//点击填写后的Map
public class FillInPerformanceAppraisalController {
    @Autowired
    PerformanceService performanceService;
    @PostMapping("/FillInData")
    public PerformanceAppraisalTemplate getPfTemplateByID(@RequestBody fillInDataRequest fillInDataRequest){
        return performanceService.getPerformanceAppraisalTemplateByID(fillInDataRequest.pf_item_id());
    }
}
