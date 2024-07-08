package com.tuhf.project16.controller;

import com.tuhf.project16.service.ILoginUserService;
import com.tuhf.project16.service.ITransApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    ITransApplicationService moveApplicationService;

    @Autowired
    ILoginUserService loginUserService;

}
