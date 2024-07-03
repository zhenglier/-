package com.tuhf.project16.controller;

import com.tuhf.project16.model.LoginUser;
import com.tuhf.project16.payload.request.LoginRequest;
import com.tuhf.project16.payload.request.RegisterRequest;
import com.tuhf.project16.payload.response.LoginResponse;
import com.tuhf.project16.payload.response.MessageResponse;
import com.tuhf.project16.service.ILoginUserService;
import com.tuhf.project16.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ILoginUserService loginUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // SS验证
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(),
                        loginRequest.password()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 如果通过了ss验证，发放token
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String role = userDetails.getAuthorities().iterator().next().getAuthority();
        String token = jwtUtil.create(authentication);

        return ResponseEntity.ok(
                new LoginResponse(
                        token,
                        userDetails.getUsername(),
                        role,
                        20000
                )
        );
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        if (!loginUserService.checkUsernameUnique(registerRequest.username())) {
            return ResponseEntity.badRequest().body(
                    new MessageResponse("Username is already taken!"));
        }

        LoginUser loginUser = new LoginUser(
                registerRequest.username(),
                passwordEncoder.encode(registerRequest.password()),
                //registerRequest.role()
                "enterprise"
        );

        loginUserService.addLoginUser(loginUser);

        return ResponseEntity.ok().body(
                new MessageResponse("Successfully registered!"));
    }

}
