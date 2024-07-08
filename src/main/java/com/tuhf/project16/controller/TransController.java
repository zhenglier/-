package com.tuhf.project16.controller;

import com.tuhf.project16.model.Carrier;
import com.tuhf.project16.model.Enterprise;
import com.tuhf.project16.model.TransInApplication;
import com.tuhf.project16.model.TransOutApplication;
import com.tuhf.project16.payload.request.TransInRequest;
import com.tuhf.project16.payload.request.TransOutRequest;
import com.tuhf.project16.payload.response.MessageResponse;
import com.tuhf.project16.payload.vo.TransInOutReviewTableVO;
import com.tuhf.project16.payload.vo.TransInVO;
import com.tuhf.project16.payload.vo.TransOutVO;
import com.tuhf.project16.service.IEntityService;
import com.tuhf.project16.service.ILoginUserService;
import com.tuhf.project16.service.ITransApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/trans")
@PreAuthorize("hasAnyAuthority('enterprise', 'carrier')")
@CrossOrigin("*")
public class TransController {

    @Autowired
    ILoginUserService loginUserService;

    @Autowired
    IEntityService entityService;

    @Autowired
    ITransApplicationService transApplicationService;

    /* 可用载体列表 */
    @GetMapping("/in")
    public TransInVO transInVO() {
        return new TransInVO(entityService.getAllCarriersNameAndId());
    }

    /* 提交入驻申请 */
    @PostMapping("/in")
    public MessageResponse transIn(@RequestBody TransInRequest request) {
        transApplicationService.addTransInApplication(
                new TransInApplication(request)
        );
        return new MessageResponse("Success");
    }

    /* 搬离申请页面信息 */
    @GetMapping("/out")
    public TransOutVO transOutVO() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Enterprise enterprise = entityService.getEnterpriseById(loginUserService.getEntityIdByUsername(username));
        return new TransOutVO(
                enterprise.getName(),
                entityService.getCarrierById(enterprise.getCarrierId()).getName(),
                enterprise.getTransInAt()
        );
    }

    /* 提交搬离申请 */
    @PostMapping("/out")
    public MessageResponse transOut(@RequestBody TransOutRequest request) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Enterprise enterprise = entityService.getEnterpriseById(loginUserService.getEntityIdByUsername(username));
        transApplicationService.addTransOutApplication(new TransOutApplication(
                null,
                enterprise.getId(),
                enterprise.getCarrierId(),
                request.transOutAt(),
                request.comment(),
                request.additionalData(),
                "待审批", 
                new Date()
        ));
        return new MessageResponse("Success");
    }

    @GetMapping("/review/in")
    public Collection<TransInOutReviewTableVO> getTransInReviewTableVO() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Carrier carrier = entityService.getCarrierById(loginUserService.getEntityIdByUsername(username));
        Collection<TransInApplication> applications = transApplicationService.getInByCarrierId(carrier.getId());

        ArrayList<TransInOutReviewTableVO> reviewTableVOs = new ArrayList<TransInOutReviewTableVO>();
        int index = 1;
        for (TransInApplication application : applications) {
            reviewTableVOs.add(new TransInOutReviewTableVO(
                    index++,
                    application.getCreditCode(),
                    application.getName(),
                    application.getCreateAt(),
                    application.getStatus(),
                    application.getId()
            ));
        }

        return reviewTableVOs;
    }

    @PreAuthorize("hasAuthority('carrier')")
    @GetMapping("/review/out")
    public Collection<TransInOutReviewTableVO> getTransOutReviewTableVO() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Carrier carrier = entityService.getCarrierById(loginUserService.getEntityIdByUsername(username));
        Collection<TransOutApplication> applications = transApplicationService.getOutByCarrierId(carrier.getId());

        ArrayList<TransInOutReviewTableVO> reviewTableVOs = new ArrayList<TransInOutReviewTableVO>();
        int index = 1;
        for (TransOutApplication application : applications) {
            Enterprise enterprise = entityService.getEnterpriseById(application.getEnterpriseId());
            reviewTableVOs.add(new TransInOutReviewTableVO(
                    index++,
                    enterprise.getCreditCode(),
                    enterprise.getName(),
                    application.getCreateAt(),
                    application.getStatus(),
                    application.getId()
            ));
        }

        return reviewTableVOs;
    }
}
