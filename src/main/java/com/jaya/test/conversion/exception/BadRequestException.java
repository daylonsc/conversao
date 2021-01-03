package com.jaya.test.conversion.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -2658643264403220076L;

	public BadRequestException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public BadRequestException(final String message) {
		super(message);
	}
}
