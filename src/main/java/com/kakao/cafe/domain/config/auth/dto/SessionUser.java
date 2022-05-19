package com.kakao.cafe.domain.config.auth.dto;

import com.kakao.cafe.domain.member.Member;
import java.io.Serializable;
import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
	private String name;
	private String email;
	private String picture;

	public SessionUser(Member member) {
		name = member.getNickname();
		email = member.getEmail();
		picture = member.getPicture();
	}
}
