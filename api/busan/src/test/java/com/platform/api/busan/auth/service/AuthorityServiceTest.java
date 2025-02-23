package com.platform.api.busan.auth.service;

import com.platform.common.datasource.base.auth.AuthRequest;
import com.platform.common.datasource.base.auth.AuthUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AuthorityServiceTest {
    @Autowired
    private AuthorityService authorityService;

    @DisplayName("로그인 인증 테스트")
    @Test
    public void login() {
        AuthRequest authRequest = new AuthRequest("admin", "12345");
        AuthUser user = authorityService.login(authRequest);

        assertEquals("admin", user.getUsername());
        assertEquals("admin", user.getId());
        assertEquals("어드민", user.getName());
        assertEquals("admin@gmail.com", user.getEmail());
    }
}
