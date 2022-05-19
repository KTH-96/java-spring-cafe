package com.kakao.cafe.domain.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

	private final CustomOAuth2MemberService customOAuth2MemberService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.headers().frameOptions().disable()//h2-console 화면을 사용하기 위해 해당 옵션처리
			.and()
				.authorizeRequests()//url별 권한 권리
				.antMatchers("/", "/css/**", "/images/**",
					"/h2-console/**").permitAll()//이후에 url 권한 관련이 필요하다면 추가
				.anyRequest().authenticated()
			.and()
				.logout()
					.logoutSuccessUrl("/")
			.and()
				.oauth2Login()
					.userInfoEndpoint()
						.userService(customOAuth2MemberService);//소셜 로그인 성공 시 후속 조치를 진행하는 구현체 등록

		return http.build();
	}

}
