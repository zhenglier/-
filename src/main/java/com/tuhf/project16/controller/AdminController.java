package com.tuhf.project16.controller;

import com.tuhf.project16.model.LoginUser;
import com.tuhf.project16.payload.request.RegisterRequest;
import com.tuhf.project16.payload.response.MessageResponse;
import com.tuhf.project16.service.ILoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ILoginUserService loginUserService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        if (!loginUserService.checkUsernameUnique(registerRequest.username())) {
            return ResponseEntity.badRequest().body(
                    new MessageResponse("Username is already taken!"));
        }

        LoginUser loginUser = new LoginUser(
                registerRequest.username(),
                passwordEncoder.encode(registerRequest.password()),
                registerRequest.role()
        );

        loginUserService.addLoginUser(loginUser);

        return ResponseEntity.ok().body(
                new MessageResponse("Successfully registered!"));
    }
}
