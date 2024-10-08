package com.elice.project.basic;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(String username) {
        userRepository.save(username);
    }
}
