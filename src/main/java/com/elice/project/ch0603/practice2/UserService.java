package com.elice.project.ch0603.practice2;

interface Service {
    String getUserName();
}

class UserService implements Service {
    @Override
    public String getUserName() {
        return "홍길동";
    }
}
