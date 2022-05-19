package com.kakao.cafe.exception.advice;

import com.kakao.cafe.exception.ErrorResult;
import com.kakao.cafe.exception.custom.MemberExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.JDBCException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class MemberExceptionController {

	@ExceptionHandler({MemberExceptionHandler.class,
		JDBCException.class})
	public ResponseEntity<ErrorResult> memberException(Exception e){
		ErrorResult join_exception = new ErrorResult("Join exception", e.getMessage());
		return new ResponseEntity<>(join_exception, HttpStatus.BAD_REQUEST);
	}
}
