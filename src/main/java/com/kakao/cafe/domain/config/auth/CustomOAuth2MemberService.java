package com.kakao.cafe.domain.config.auth;

import com.kakao.cafe.domain.config.auth.dto.OAuthAttributes;
import com.kakao.cafe.domain.config.auth.dto.SessionUser;
import com.kakao.cafe.domain.member.Member;
import com.kakao.cafe.domain.member.MemberRepository;
import java.util.Collections;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomOAuth2MemberService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

	private final MemberRepository memberRepository;
	private final HttpSession httpSession;
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);

		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		//현재 진행중인 로그인 서비스 비교를 위해, 나중에 OAuth2를 구글만이 아닌 깃헙,카카오등으로 늘릴때 구분하기 위해 필요
		String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint()
			.getUserNameAttributeName();//OAuth2진행시 키가 되는 필드값, 구글은 기본 코드 지원, 네이버 카카오는 지원 X
		OAuthAttributes attributes = OAuthAttributes
			.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
		//OAuthAttributes -> OAuth2User 의 attribute를 담을 클래스

		Member member = saveOrUpdate(attributes);

		httpSession.setAttribute("member", new SessionUser(member));

		return new DefaultOAuth2User(
			Collections.singleton(new SimpleGrantedAuthority(member.getRoleKey())),
			attributes.getAttributes(),
			attributes.getNameAttributeKey()
		);
	}

	private Member saveOrUpdate(OAuthAttributes attributes) {
		Member member =memberRepository.findByEmail(attributes.getEmail())
			.map(entity -> entity.oauthUpdate(attributes.getName(), attributes.getPicture()))
			.orElse(attributes.toEntity());

		return memberRepository.save(member);
	}
}
