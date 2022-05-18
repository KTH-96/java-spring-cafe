package com.kakao.cafe.web.dto.member;

import com.kakao.cafe.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class MemberJoinRequestDto {

	private String email;
	private String password;
	private String name;

	@Builder
	public MemberJoinRequestDto(String email, String password, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public Member toEntity() {
		return Member.builder()
			.email(email)
			.password(password)
			.nickname(name).build();
	}
}
