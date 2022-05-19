package com.kakao.cafe.exception.custom;

public class MemberExceptionHandler extends RuntimeException {

	public MemberExceptionHandler() {
	}

	public MemberExceptionHandler(String message) {
		super(message);
	}

	public MemberExceptionHandler(String message, Throwable cause) {
		super(message, cause);
	}

	public MemberExceptionHandler(Throwable cause) {
		super(cause);
	}
}
