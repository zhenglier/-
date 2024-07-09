package com.tuhf.project16.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.GifCaptcha;
import com.tuhf.project16.model.LoginUser;
import com.tuhf.project16.payload.request.LoginRequest;
import com.tuhf.project16.payload.request.LogoutRequest;
import com.tuhf.project16.payload.request.RegisterRequest;
import com.tuhf.project16.payload.request.VerifyCaptchaRequest;
import com.tuhf.project16.payload.response.LoginResponse;
import com.tuhf.project16.payload.response.LogoutResponse;
import com.tuhf.project16.payload.response.MessageResponse;
import com.tuhf.project16.service.ILoginUserService;
import com.tuhf.project16.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

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
    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 检查 token 的有效性
     * @param token token字符串
     * @return 以字符串表示的状态指示
     */
    @GetMapping("/check")
    public String check(@RequestParam String token) {
        if(jwtUtil.verify(token)){
            return "true";
        }else{
            return "false";
        }
    }

    /**
     * 登出操作，如果 token 有效则从缓存中删除
     * @param token token字符串
     * @return 提示消息
     */
    @PostMapping("/logout")
    public LogoutResponse logout(@RequestBody LogoutRequest token) {
        if(jwtUtil.verify(token.getToken())){
            jwtUtil.erase(token.getToken());
            return new LogoutResponse(20000,"Logout successfully!");
        }else{
            return new LogoutResponse(20000,"Has already logged out!");
        }
    }

    /**
     * 登入操作，验证由 SS 完成，通过验证则发放 token
     * @param loginRequest 包含前端输入的用户名和密码
     * @return LoginResponse 对象，包含令牌、用户名、角色、状态码
     */
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
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

        return new LoginResponse(
                        token,
                        userDetails.getUsername(),
                        role
        );
    }

    /**
     * 注册操作，验证输入合法性后存入数据库
     * @param registerRequest 包含用户名和密码
     * @return 消息响应
     */
    @PostMapping("/register")
    public MessageResponse register(@RequestBody RegisterRequest registerRequest) {
        // 重名检测
        if (!loginUserService.checkUsernameUnique(registerRequest.username())) {
            return new MessageResponse("Username is already taken!");
        }

        // 公开的注册功能只能注册企业角色的用户
        LoginUser loginUser = new LoginUser(
                registerRequest.username(),
                passwordEncoder.encode(registerRequest.password()),
                //registerRequest.role()
                "enterprise"
        );

        loginUserService.addLoginUser(loginUser);

        return new MessageResponse("Successfully registered!");
    }

    /*
    @GetMapping("/captcha")
    public CaptchaVO getCaptcha() {
        GifCaptcha captcha =  CaptchaUtil.createGifCaptcha(200, 50, 4);
        String uuid = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(uuid, captcha.getCode(), 20, TimeUnit.MINUTES);
        return new CaptchaVO(uuid, captcha.getImageBytes());
    }
    */
    @GetMapping("/captcha/{uuid}")
    public ResponseEntity<Resource> getCaptcha(@PathVariable String uuid) {
        GifCaptcha captcha =  CaptchaUtil.createGifCaptcha(200, 50, 4);
        redisTemplate.opsForValue().set(uuid, captcha.getCode(), 20, TimeUnit.MINUTES);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_GIF)
                .body(new ByteArrayResource(captcha.getImageBytes()));
    }

    @PostMapping("/captcha")
    public String verifyCaptcha(@RequestBody VerifyCaptchaRequest request) {
        String code = (String) redisTemplate.opsForValue().get(request.uuid());
        if (code == null) {
            return "expired";
        } else {
            redisTemplate.opsForValue().getAndDelete(request.uuid());
        }

        if (code.equals(request.code())) {
            return "true";
        } else {
            return "false";
        }
    }
}
