package com.tuhf.project16.controller;

import com.tuhf.project16.service.ILoginUserService;
import com.tuhf.project16.service.IMoveApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/user/crr")
@RequestMapping("/crr")
@CrossOrigin("*")
//@PreAuthorize("hasRole('carrier')")
public class CarrierController {

    @Autowired
    IMoveApplicationService moveApplicationService;

    @Autowired
    ILoginUserService loginUserService;

    /**
     * 获取目标是本载体端的转移申请
     * @return collection of MoveApplication
     */
    @GetMapping("/move")
    public ResponseEntity<?> getMyMoveApplication() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(moveApplicationService.getByCarrierId(
                loginUserService.getIdByUsername(username)
        ));
    }
}
