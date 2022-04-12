package com.kakao.cafe.domain.reply;

import java.time.LocalDateTime;

public class Reply {
    private Long post_id;//댓글을 달 게시글의 id
    private String writer;//user_id
    private String contents;
    private LocalDateTime createTime;

    public Reply(Long post_id, String writer, String contents, LocalDateTime createTime) {
        this.post_id = post_id;
        this.writer = writer;
        this.contents = contents;
        this.createTime = createTime;
    }


    public Long getPost_id() {
        return post_id;
    }

    public String getWriter() {
        return writer;
    }

    public String getContents() {
        return contents;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }
}
