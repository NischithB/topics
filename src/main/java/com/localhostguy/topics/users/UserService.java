package com.localhostguy.topics.users;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(
        @NonNull String username, 
        String password, 
        @NonNull String email) {
        var user = UserEntity.builder()
            .username(username)
            .email(email)
            .build();

        return userRepository.save(user);
    }

    public UserEntity getUserByUsername(String username) {
        return userRepository
            .findByUsername(username)
            .orElseThrow(() -> new UserNotFoundException(username));
    }

    public class UserNotFoundException extends IllegalArgumentException {
        public UserNotFoundException(String username) {
            super(String.format("User with username: %s Not Found", username));
        }
    }
}
