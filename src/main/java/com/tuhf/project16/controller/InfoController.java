package com.tuhf.project16.controller;

import com.tuhf.project16.model.Carrier;
import com.tuhf.project16.model.ChangeInfoApplication;
import com.tuhf.project16.model.Enterprise;
import com.tuhf.project16.model.Government;
import com.tuhf.project16.payload.request.ChangeInfoRequest;
import com.tuhf.project16.payload.response.MessageResponse;
import com.tuhf.project16.payload.vo.ChangeInfoReviewTableVO;
import com.tuhf.project16.payload.vo.ChangeInfoVO;
import com.tuhf.project16.payload.vo.EnterpriseInfoVO;
import com.tuhf.project16.service.IChangeInfoApplicationService;
import com.tuhf.project16.service.IEntityService;
import com.tuhf.project16.service.ILoginUserService;
import com.tuhf.project16.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/info")
@CrossOrigin("*")
@PreAuthorize("hasAnyRole('enterprise', 'carrier', 'government')")
public class InfoController {

    @Autowired
    IEntityService entityService;

    @Autowired
    ILoginUserService loginUserService;

    @Autowired
    IChangeInfoApplicationService changeInfoApplicationService;

    @Autowired
    UserUtil userUtil;

    @PreAuthorize("hasRole('enterprise')")
    @GetMapping("/etp")
    public EnterpriseInfoVO getEnterprise() {
        Enterprise enterprise = entityService.getEnterpriseById(userUtil.getEtpId());
        return new EnterpriseInfoVO(
                enterprise.getId(),
                enterprise.getCreditCode(),
                enterprise.getName(),
                enterprise.getRegisteredCapital(),
                enterprise.getType(),
                enterprise.getIndustry(),
                enterprise.getAddress(),
                enterprise.getRegisterAt(),
                enterprise.getOperatorName(),
                entityService.getCarrierById(enterprise.getCarrierId()).getName(),
                enterprise.getBusiness(),
                enterprise.getTransInAt(),
                enterprise.getStatus(),
                enterprise.getAdditionalData()
        );
    }

    @PreAuthorize("hasRole('carrier')")
    @GetMapping("/crr")
    public Carrier getCarrier() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return entityService.getCarrierById(loginUserService.getEntityIdByUsername(username));
    }

    @PreAuthorize("hasRole('government')")
    @GetMapping("/gov")
    public Government getGovernment() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return entityService.getGovernmentById(loginUserService.getEntityIdByUsername(username));
    }


    @PreAuthorize("hasRole('enterprise')")
    @PutMapping("/etp")
    public MessageResponse setEnterpriseBasics(@RequestBody String additionalData) {
        int flag = entityService.updateEnterpriseAdditionalData(userUtil.getCrrId(), additionalData);
        if (flag == 1) {
            return new MessageResponse("Success");
        } else {
            return new MessageResponse("Error");
        }
    }

    /* 重大信息更改 */
    @PreAuthorize("hasRole('enterprise')")
    @PostMapping("/etp")
    public MessageResponse modInfo(@RequestBody ChangeInfoRequest request) {
        long enterpriseId = userUtil.getEtpId();
        Enterprise enterprise = entityService.getEnterpriseById(userUtil.getEtpId());
        ChangeInfoApplication application = new ChangeInfoApplication(
                null,
                enterpriseId,
                entityService.getParentIdForEnterprise(enterpriseId),
                request.type(),
                beforeInfoSelect(enterprise, request.type()),
                request.after(),
                request.material(),
                request.date(),
                "待审批"
        );

        int flag = changeInfoApplicationService.addApplication(application);
        if (flag == 1) {
            return new MessageResponse("Success");
        } else {
            return new MessageResponse("Error");
        }
    }

    @PreAuthorize("hasRole('enterprise')")
    @RequestMapping(value = "/etp", method = RequestMethod.GET, params = "type")
    public ChangeInfoVO getBeforeInfo(@RequestParam("type") String type) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long enterpriseId = loginUserService.getEntityIdByUsername(username);
        Enterprise enterprise = entityService.getEnterpriseById(enterpriseId);
        return new ChangeInfoVO(beforeInfoSelect(enterprise, type));
    }

    @PreAuthorize("hasAuthority('carrier')")
    @GetMapping("/review")
    public Collection<ChangeInfoReviewTableVO> getReviewVO() {
        Collection<ChangeInfoApplication> applications =
                changeInfoApplicationService.getApplicationsByCarrierId(userUtil.getCrrId());

        ArrayList<ChangeInfoReviewTableVO> vos = new ArrayList<>();
        int index = 1;
        for (ChangeInfoApplication application : applications) {
            vos.add(new ChangeInfoReviewTableVO(
                    index++,
                    entityService.getEnterpriseNameById(application.getEnterpriseId()),
                    application.getDate(),
                    application.getType(),
                    application.getStatus(),
                    application.getId()
            ));
        }

        return vos;
    }


    private static String beforeInfoSelect(Enterprise enterprise, String type) {
        return switch (type) {
            case "名称" -> enterprise.getName();
            case "注册资本" -> String.valueOf(enterprise.getRegisteredCapital());
            case "孵化状态" -> enterprise.getStatus();
            case "主营业务" -> enterprise.getBusiness();
            case "注册地址" -> enterprise.getAddress();
            default -> "";
        };
    }
}
