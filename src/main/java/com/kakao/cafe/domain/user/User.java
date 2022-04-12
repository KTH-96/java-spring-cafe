package com.kakao.cafe.domain.user;

import com.kakao.cafe.web.dto.UserUpdateDto;

public class User {
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String email;

    public User() {
    }

    public User(String userId, String password, String name, String email) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public void setMapper(Long id, String userId, String password, String name, String email) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void updateProfile(UserUpdateDto userUpdateDto) {
        this.name = userUpdateDto.getName();
        this.email = userUpdateDto.getEmail();
    }

    public boolean passwordCheck(String password) {
        if (this.password.equals(password)) {
            return true;
        }
        return false;
    }
}
