package com.kakao.cafe.service;

import com.kakao.cafe.domain.reply.JdbcReplyRepository;
import com.kakao.cafe.domain.reply.Reply;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {
    private final JdbcReplyRepository replyRepository;

    public ReplyService(JdbcReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    public List<Reply> findReply(Long id) {
        return replyRepository.findAllByPostId(id);
    }
}
