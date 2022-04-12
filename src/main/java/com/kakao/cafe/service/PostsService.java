package com.kakao.cafe.service;

import com.kakao.cafe.domain.posts.JdbcPostRepository;
import com.kakao.cafe.domain.posts.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostsService {
    private final JdbcPostRepository postRepository;

    @Autowired
    public PostsService(JdbcPostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public void qnaRegister(Post post) {
        postRepository.save(post);
    }

    public List<Post> findPosts() {
        return postRepository.findAll();
    }

    public Post findWriter(String writer) {
        return postRepository.findByWriter(writer);
    }
    public Post findPost(Long id) {
        return postRepository.findById(id);
    }

    public void update(String writer, Post post) {
        postRepository.updatePost(writer, post);
    }

    public void delete(String writer) {
        postRepository.deletePost(writer);
    }
}
