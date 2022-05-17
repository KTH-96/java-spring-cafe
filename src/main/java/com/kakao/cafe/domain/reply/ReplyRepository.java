package com.kakao.cafe.domain.reply;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

	List<Reply> findAllById(Long id);
}
