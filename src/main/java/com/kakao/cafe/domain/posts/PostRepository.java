package com.kakao.cafe.domain.posts;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

	Optional<Post> findByWriter(String writer);
}
