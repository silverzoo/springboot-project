package com.elice.project.ch0603.practice3;

interface Service {
    String getDescription();
}

class UserService implements Service {
    @Override
    public String getDescription() {
        return "사용자 서비스";
    }
}
