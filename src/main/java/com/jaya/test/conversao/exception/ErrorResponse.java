package com.jaya.test.conversao.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
public class ErrorResponse {
	private final Date timestamp;
	private final Integer status;
	private final String error;
	private final String message;
	private final String path;
}
