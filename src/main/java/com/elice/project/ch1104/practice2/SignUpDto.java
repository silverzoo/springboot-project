package com.elice.project.ch1104.practice2;


public class SignUpDto {
    private String email;
    private String password;
    private String nickname;

    public SignUpDto() {

    }

    public Member toEntity() {
        return new Member(email, password, nickname);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
