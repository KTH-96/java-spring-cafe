package com.kakao.cafe.service;

import com.kakao.cafe.domain.member.Member;
import com.kakao.cafe.domain.member.MemberRepository;
import com.kakao.cafe.exception.custom.MemberExceptionHandler;
import com.kakao.cafe.web.dto.member.MemberJoinResponseDto;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberRepository memberRepository;

	@Transactional
	public MemberJoinResponseDto join(Member member) {
		log.debug("join service 호출");
		//예외를 터트려보자
		member = Member.builder()
			.nickname(member.getNickname())
			.password(member.getPassword())
			.email(null)
			.build();
		return Optional.of(new MemberJoinResponseDto(memberRepository.save(member)))
			.orElseThrow(() -> new MemberExceptionHandler("회원가입 실패", new NullPointerException()));
	}
}
