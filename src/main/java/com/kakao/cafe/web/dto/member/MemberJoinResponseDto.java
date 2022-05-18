package com.kakao.cafe.web.dto.member;

import com.kakao.cafe.domain.member.Member;
import lombok.Getter;

@Getter
public class MemberJoinResponseDto {

	private String email;
	private String name;

	public MemberJoinResponseDto(Member entity) {
		this.email = entity.getEmail();
		this.name = entity.getNickname();
	}
}
