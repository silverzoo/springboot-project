package com.elice.project.ch0603.practice5;

import java.util.UUID;

class UserService {
    private final String id;

    public UserService() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
