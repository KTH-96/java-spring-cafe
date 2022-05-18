package com.kakao.cafe.service;

import com.kakao.cafe.domain.member.Member;
import com.kakao.cafe.domain.member.MemberRepository;
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
		return Optional.ofNullable(new MemberJoinResponseDto(memberRepository.save(member)))
			.orElseThrow(() -> new IllegalArgumentException("회원 가입 실패"));
	}
}
