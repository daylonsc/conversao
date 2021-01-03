package com.jaya.test.conversao.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class RestExceptionHandler {

	@ResponseBody
	@ResponseStatus(BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public ErrorResponse handleBadRequest(BadRequestException exception, HttpServletRequest request) {
		return new ErrorResponse(new Date(), BAD_REQUEST.value(), BAD_REQUEST.name(), exception.getMessage(), request.getServletPath());
	}
}
