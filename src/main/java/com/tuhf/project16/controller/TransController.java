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
import com.tuhf.project16.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @Autowired
    UserUtil userUtil;

    /* 可用载体列表 */
    @GetMapping("/in")
    public Map<?, ?> transInVO() {
        return entityService.getAllCarriersIdAndName();
    }

    /* 提交入驻申请 */
    @PostMapping("/in")
    public MessageResponse transIn(@RequestBody TransInRequest request) {
        TransInApplication application = new TransInApplication(request);
        application.setUserId(userUtil.getUserId());

        transApplicationService.addTransInApplication(
                new TransInApplication(request)
        );
        return new MessageResponse("Success");
    }

    /* 搬离申请页面信息 */
    @GetMapping("/out")
    public TransOutVO transOutVO() {
        Enterprise enterprise = entityService.getEnterpriseById(userUtil.getEtpId());
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
                "毕业",
                new Date()
        ));
        return new MessageResponse("Success");
    }

    @GetMapping("/review/in")
    public Collection<TransInOutReviewTableVO> getTransInReviewTableVO(@RequestParam int status) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Carrier carrier = entityService.getCarrierById(loginUserService.getEntityIdByUsername(username));
        Collection<TransInApplication> applications = transApplicationService.getInByCarrierId(carrier.getId());

        ArrayList<TransInOutReviewTableVO> reviewTableVOs = new ArrayList<TransInOutReviewTableVO>();
        int index = 1;
        for (TransInApplication application : applications) {
            if(status==1 ^ Objects.equals(application.getStatus(), "待审批")) {
                reviewTableVOs.add(new TransInOutReviewTableVO(
                        index++,
                        application.getCreditCode(),
                        application.getName(),
                        application.getCreateAt(),
                        application.getStatus(),
                        application.getId()
                ));
            }
        }

        return reviewTableVOs;
    }

    @PreAuthorize("hasAuthority('carrier')")
    @GetMapping("/review/out")
    public Collection<TransInOutReviewTableVO> getTransOutReviewTableVO(@RequestParam int status) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Carrier carrier = entityService.getCarrierById(loginUserService.getEntityIdByUsername(username));
        Collection<TransOutApplication> applications = transApplicationService.getOutByCarrierId(carrier.getId());

        ArrayList<TransInOutReviewTableVO> reviewTableVOs = new ArrayList<TransInOutReviewTableVO>();
        int index = 1;
        for (TransOutApplication application : applications) {
            Enterprise enterprise = entityService.getEnterpriseById(application.getEnterpriseId());
            if(status==1 ^ Objects.equals(application.getStatus(), "待审批")) {
                reviewTableVOs.add(new TransInOutReviewTableVO(
                        index++,
                        enterprise.getCreditCode(),
                        enterprise.getName(),
                        application.getCreateAt(),
                        application.getStatus(),
                        application.getId()
                ));
            }
        }

        return reviewTableVOs;
    }

    @PreAuthorize("hasAuthority('carrier')")
    @PutMapping("/review/in/accept/{id}")
    public MessageResponse acceptIn(@PathVariable long id) {

        TransInApplication application = transApplicationService.getInById(id);
        // 验证是否为本载体所属
        if (!Objects.equals(application.getCarrierId(), userUtil.getCrrId())) {
            return new MessageResponse("没有权限");
        }

        transApplicationService.setInStatus(id, "已完成");

        // 创建实体和连接
        Enterprise enterprise = new Enterprise(application);
        entityService.addEnterprise(enterprise);
        loginUserService.createBound(application.getUserId(), enterprise.getId(), "etp");
        return new MessageResponse("操作成功");
    }

    @PreAuthorize("hasAuthority('carrier')")
    @PutMapping("/review/out/accept/{id}")
    public MessageResponse acceptOut(@PathVariable long id) {

        // 验证是否为本载体所属
        if (!Objects.equals(transApplicationService.getOutById(userUtil.getCrrId()).getCarrierId(), userUtil.getCrrId())) {
            return new MessageResponse("没有权限");
        }

        transApplicationService.setOutStatus(id, "已完成");
        return new MessageResponse("操作成功");
    }

    @PreAuthorize("hasAuthority('carrier')")
    @PutMapping("/review/in/reject/{id}")
    public MessageResponse rejectIn(@PathVariable long id) {

        // 验证是否为本载体所属
        if (!Objects.equals(transApplicationService.getInById(userUtil.getCrrId()).getCarrierId(), userUtil.getCrrId())) {
            return new MessageResponse("没有权限");
        }

        transApplicationService.setInStatus(id, "已拒绝");
        return new MessageResponse("操作成功");
    }

    @PreAuthorize("hasAuthority('carrier')")
    @PutMapping("/review/out/reject/{id}")
    public MessageResponse rejectOut(@PathVariable long id) {

        // 验证是否为本载体所属
        if (!Objects.equals(transApplicationService.getOutById(userUtil.getCrrId()).getCarrierId(), userUtil.getCrrId())) {
            return new MessageResponse("没有权限");
        }

        transApplicationService.setOutStatus(id, "已拒绝");
        return new MessageResponse("操作成功");
    }
}
