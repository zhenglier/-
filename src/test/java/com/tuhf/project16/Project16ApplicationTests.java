package com.tuhf.project16;

import com.tuhf.project16.mapper.ProgramMapper;
import com.tuhf.project16.model.LoginUser;
import com.tuhf.project16.model.ProgramTemplate;
import com.tuhf.project16.service.ILoginUserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Project16ApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(Project16ApplicationTests.class);
    @Autowired
    ILoginUserService loginUserService;
    @Autowired
    ProgramMapper programMapper;

     @Test
    void contextLoads() {
    }

    @Test
    void testAddUser() {
        LoginUser loginUser = new LoginUser(
                "admin",
                "admin123",
                "admin"
        );
        loginUserService.addLoginUser(loginUser);
    }

    @Test
    void testUniqueAndDelete() {
        assertFalse(loginUserService.checkUsernameUnique("admin"));
        Long id = loginUserService.getLoginUserByUsername("admin").getId();
        loginUserService.deleteLoginUserById(id);
        assertTrue(loginUserService.checkUsernameUnique("admin"));
    }

    @Test
    void checksumTest() {
         String data = "fuck you";
         InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            DigestInputStream dis = new DigestInputStream(inputStream, digest);
            byte[] buffer = digest.digest();
            StringBuilder hash = new StringBuilder();
            for (byte b : buffer) {
                hash.append(Integer.toHexString(b & 0xff));
            }
            System.out.println(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
