package com.kakao.cafe.service;

import com.kakao.cafe.domain.user.JdbcUserRepository;
import com.kakao.cafe.domain.user.User;
import com.kakao.cafe.web.dto.UserJoinDto;
import com.kakao.cafe.web.dto.UserUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final JdbcUserRepository userRepository;

    public UserService(JdbcUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void userJoin(User user) {
        userRepository.save(user);
    }

    public Optional<User> findUser(String userId) {
        return userRepository.findByUserId(userId);
    }
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public void userUpdate(Long id, User user) {
        userRepository.updateUser(id, user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> login(String userId, String password) {
        return userRepository.findByUserId(userId);
    }
}
