package com.kakao.cafe.service;

import com.kakao.cafe.domain.user.JdbcUserRepository;
import com.kakao.cafe.domain.user.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final JdbcUserRepository userRepository;

    public MemberService(JdbcUserRepository userRepository) {
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
