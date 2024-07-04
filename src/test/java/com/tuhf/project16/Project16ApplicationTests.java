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
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Project16ApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(Project16ApplicationTests.class);
    @Autowired
    ILoginUserService loginUserService;
    @Autowired
    ProgramMapper programMapper;

    @Test
    void testProgramMapper(){

        System.out.println(programMapper.getProgramApplications(-1L,-1,-1L,-1));


//        programMapper.addProgramTemplate(new ProgramTemplate(
//                1L,
//                "testTemplate",
//                1L,
//                2,
//                "114514"
//        ));
    }


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

}
