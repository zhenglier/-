package com.tuhf.project16.controller;

import com.tuhf.project16.model.Carrier;
import com.tuhf.project16.model.ChangeInfoApplication;
import com.tuhf.project16.model.Enterprise;
import com.tuhf.project16.model.Government;
import com.tuhf.project16.payload.request.ChangeInfoRequest;
import com.tuhf.project16.payload.response.MessageResponse;
import com.tuhf.project16.payload.vo.ChangeInfoVO;
import com.tuhf.project16.service.IChangeInfoApplicationService;
import com.tuhf.project16.service.IEntityService;
import com.tuhf.project16.service.ILoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasRole('enterprise')")
    @GetMapping("/etp")
    public Enterprise getEnterprise() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return entityService.getEnterpriseById(loginUserService.getEntityIdByUsername(username));
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
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long id = loginUserService.getEntityIdByUsername(username);
        int flag = entityService.setEnterpriseAdditionalData(id, additionalData);
        if (flag == 1) {
            return new MessageResponse("Success");
        } else {
            return new MessageResponse("Error");
        }
    }

    /* 传入的enterprise只需要有需要更改的字段即可 */
    @PreAuthorize("hasRole('enterprise')")
    @PostMapping("/etp")
    public MessageResponse modInfo(@RequestBody ChangeInfoRequest request) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long enterpriseId = loginUserService.getEntityIdByUsername(username);
        Enterprise enterprise = entityService.getEnterpriseById(enterpriseId);
        ChangeInfoApplication application = new ChangeInfoApplication(
                null,
                enterpriseId,
                entityService.getParentIdForEnterprise(enterpriseId),
                beforeInfoSelect(enterprise, request.type()),
                request.after(),
                request.material(),
                request.date()
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
