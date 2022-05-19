package com.kakao.cafe.exception.advice;

import com.kakao.cafe.exception.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class JsonExceptionController {

	@ExceptionHandler({MethodArgumentNotValidException.class
		, BindException.class, HttpMessageNotReadableException.class})
	public ResponseEntity<ErrorResult> JsonException(Exception e){
		ErrorResult json_exception = new ErrorResult("Json exception", e.getMessage());
		return new ResponseEntity<>(json_exception, HttpStatus.BAD_REQUEST);
	}
}
