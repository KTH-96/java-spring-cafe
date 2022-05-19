package com.kakao.cafe.web.dto.member;

import com.kakao.cafe.domain.member.Member;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class MemberJoinRequestDto {

	@NotBlank
	private String email;
	@NotBlank
	private String password;
	@NotBlank
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
