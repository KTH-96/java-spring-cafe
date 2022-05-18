package com.kakao.cafe.web;

import com.kakao.cafe.service.MemberService;
import com.kakao.cafe.web.dto.member.MemberJoinRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
@Controller
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/form")
	public String form(Model model) {
		log.debug("회원 가입 폼");
		model.addAttribute("member", new MemberJoinRequestDto());
		return "user/form";
	}

	@PostMapping("/form")
	public String join(@RequestBody MemberJoinRequestDto dto) {
		log.debug("dto = {}", dto);
		//TODO: null일때 exception처리 필요
		memberService.join(dto.toEntity());
		log.debug("회원 가입 member.email = {}", dto.getEmail());
		return "redirect:/";
	}
}
