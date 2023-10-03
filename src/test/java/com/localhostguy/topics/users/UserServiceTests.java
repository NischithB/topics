package com.localhostguy.topics.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTests {
    private UserService userService;

    @Autowired
    public UserServiceTests(UserService userService) {
        this.userService = userService;
    }
    
    @Test
    void createUser_IsUserCreated_True() {
        var user = userService.createUser(
            "nischithb01", 
            "nischitb123", 
            "nischitb01@xyz.com"
        );

        assert userService.getUserByUsername("nischithb01").getUsername() == user.getUsername();
    }
}
