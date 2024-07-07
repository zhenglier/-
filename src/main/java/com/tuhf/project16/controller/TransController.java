package com.tuhf.project16.controller;

import com.tuhf.project16.model.Enterprise;
import com.tuhf.project16.model.TransInApplication;
import com.tuhf.project16.model.TransOutApplication;
import com.tuhf.project16.payload.request.TransInRequest;
import com.tuhf.project16.payload.request.TransOutRequest;
import com.tuhf.project16.payload.response.MessageResponse;
import com.tuhf.project16.payload.vo.TransInVO;
import com.tuhf.project16.payload.vo.TransOutVO;
import com.tuhf.project16.service.IEntityService;
import com.tuhf.project16.service.ILoginUserService;
import com.tuhf.project16.service.ITransApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trans")
@PreAuthorize("hasRole('enterprise')")
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
    @PostMapping
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
                "待审批"
        ));
        return new MessageResponse("Success");
    }
}
