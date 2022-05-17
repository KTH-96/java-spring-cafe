package com.kakao.cafe.domain.posts;

import static javax.persistence.FetchType.*;

import com.kakao.cafe.domain.BaseTimeEntity;
import com.kakao.cafe.domain.member.Member;
import com.kakao.cafe.domain.reply.Reply;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    @Column(length = 100, nullable = false)
    private String writer;
    @Column(length = 500, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String contents;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "post")
    private List<Reply> replyList = new ArrayList<>();
    @Builder
    public Post(String writer, String title, String contents) {
        this.writer = writer;
        this.title = title;
        this.contents = contents;
    }
}
