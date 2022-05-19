package com.kakao.cafe.domain.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

	GUEST("ROLE_GUEST", "손님"), USER("ROLE_ADMIN", "일반 사용자");

	private final String key;
	private final String title;
}
