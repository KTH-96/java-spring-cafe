package com.kakao.cafe.web;

import com.kakao.cafe.domain.config.auth.dto.SessionUser;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/")
@RestController
public class IndexController {

	@GetMapping
	public String index() {
		log.debug("home화면 호출 API");
		return "home";
	}
}
