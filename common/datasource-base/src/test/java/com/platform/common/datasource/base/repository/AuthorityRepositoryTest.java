package com.platform.common.datasource.base.repository;


import com.platform.common.base.BaseSpringBootTest;
import com.platform.common.datasource.base.auth.BasicAuthority;
import com.platform.common.datasource.base.jooq.repository.authority.AuthorityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AuthorityRepositoryTest extends BaseSpringBootTest {

    @Autowired
    private AuthorityRepository authorityRepository;

    @DisplayName("id를 이용해서 사용자 조회")
    @Test
    public void testFindById() {
        var user = authorityRepository.findAuthorById("admin");

        assertEquals("admin@gmail.com", user.getEmail());
        assertEquals("admin", user.getId());
        assertEquals("어드민", user.getName());
        assertEquals(2, user.getRoles().size());

        assertThat(user.getRoles())
                .extracting(BasicAuthority::getAuthority)
                .containsExactlyInAnyOrder("IMPLEMENTER", "DECISION");
    }
}