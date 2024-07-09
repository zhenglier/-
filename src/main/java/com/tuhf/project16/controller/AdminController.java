package com.tuhf.project16.controller;

import com.tuhf.project16.model.Carrier;
import com.tuhf.project16.model.Government;
import com.tuhf.project16.model.LoginUser;
import com.tuhf.project16.payload.request.RegisterRequest;
import com.tuhf.project16.payload.response.MessageResponse;
import com.tuhf.project16.service.IEntityService;
import com.tuhf.project16.service.ILoginUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")  //管理员账号
@Slf4j
@PreAuthorize("hasAuthority('admin')")
public class AdminController {

    @Autowired
    ILoginUserService loginUserService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    IEntityService entityService;

    @PostMapping("/register")
    public MessageResponse register(@RequestBody RegisterRequest registerRequest) {
        if (!loginUserService.checkUsernameUnique(registerRequest.username())) {
            return new MessageResponse("用户名已被占用");
        }

        LoginUser loginUser = new LoginUser(
                registerRequest.username(),
                passwordEncoder.encode(registerRequest.password()),
                registerRequest.role()
        );

        loginUserService.addLoginUser(loginUser);

        return new MessageResponse("Successfully registered!");
    }

    @PostMapping("/add/crr/{loginUserId}")
    public MessageResponse addCarrier(@RequestBody Carrier carrier, @PathVariable long loginUserId) {
        entityService.addCarrier(carrier);
        loginUserService.createBound(loginUserId, carrier.getId(), "crr");
        return new MessageResponse("Successfully added carrier!");
    }

    @PostMapping("/add/gov/{loginUserId}")
    public MessageResponse addGovernment(@RequestBody Government government, @PathVariable long loginUserId) {
        entityService.addGovernment(government);
        loginUserService.createBound(loginUserId, government.getId(), "gov");
        return new MessageResponse("Successfully added government!");
    }
}
