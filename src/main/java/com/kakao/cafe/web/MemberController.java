package com.kakao.cafe.web;

import com.kakao.cafe.service.MemberService;
import com.kakao.cafe.web.dto.member.MemberJoinRequestDto;
import com.kakao.cafe.web.dto.member.MemberJoinResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/member/join")
	public ResponseEntity<MemberJoinResponseDto> join(@Validated @RequestBody MemberJoinRequestDto dto) {
		log.debug("회원가입 진행 ");
		MemberJoinResponseDto joinMember = memberService.join(dto.toEntity());
		return new ResponseEntity<>(joinMember, HttpStatus.OK);
	}
}
