package com.tuhf.project16.controller;

import com.tuhf.project16.model.PerformanceAppraisalApplicationItem;
import com.tuhf.project16.payload.request.commitFillInDataRequest;
import com.tuhf.project16.payload.response.MessageResponse;
import com.tuhf.project16.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/performance")//点击提交后的Map
public class CommitPerformanceAppraisalController {
    @Autowired
    PerformanceService performanceService;
    @PostMapping("/CommitFillInData")
    public ResponseEntity<?> commitPf(@RequestBody commitFillInDataRequest commitFillInDataRequest){
        PerformanceAppraisalApplicationItem performanceAppraisalApplicationItem=new PerformanceAppraisalApplicationItem(commitFillInDataRequest.pf_item_id(), commitFillInDataRequest.fill_in_data(),commitFillInDataRequest.carrier_name(),-1);
        performanceService.addPerformanceAppraisalApplicationItem(performanceAppraisalApplicationItem);
        return ResponseEntity.ok().body(
                new MessageResponse("Commit successfully!"));
    }
}
