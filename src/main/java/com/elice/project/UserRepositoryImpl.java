package com.elice.project;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public void save(String username) {
        System.out.println("사용자 저장: " + username);
    }
}
