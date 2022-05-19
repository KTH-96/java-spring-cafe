package com.kakao.cafe.domain.member;

import com.kakao.cafe.domain.BaseTimeEntity;
import com.kakao.cafe.domain.posts.Post;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;

	@Column(length = 100, nullable = false)
	private String email;
	@Column(length = 100, nullable = false)
	private String password;
	@Column(length = 100, nullable = false)
	private String nickname;

	@Column
	private String picture;

	@Enumerated(EnumType.STRING)
	@Column()
	private Role role;

	@OneToMany(mappedBy = "member")
	private List<Post> postList = new ArrayList<>();

	@Builder
	public Member(String email, String password, String nickname, String picture, Role role) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.picture = picture;
		this.role = role;
	}

	public Member oauthUpdate(String name, String picture) {
		this.nickname = name;
		return this;
	}

	public String getRoleKey() {
		return this.role.getKey();
	}
}
