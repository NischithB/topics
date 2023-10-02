package com.localhostguy.topics.users;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTests {
    private UserRepository userRepository;

    @Autowired
    public UserRepositoryTests(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    @Order(1)
    void addUser_usersSizeIs1_True() {
        var user = UserEntity.builder()
            .username("nischithb01")
            .email("nischith@xyz.com")
            .build();

        userRepository.save(user);
        assert (userRepository.findAll().size() == 1); 
    }
}
