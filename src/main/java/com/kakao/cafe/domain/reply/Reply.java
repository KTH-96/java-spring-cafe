package com.kakao.cafe.domain.reply;

import static javax.persistence.FetchType.*;

import com.kakao.cafe.domain.BaseTimeEntity;
import com.kakao.cafe.domain.posts.Post;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Reply extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;

    @Column(length = 100, nullable = false)
    private String writer;//user_id

    @Column(columnDefinition = "TEXT")
    private String contents;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public Reply(String writer, String contents) {
        this.writer = writer;
        this.contents = contents;
    }
}
