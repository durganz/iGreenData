package com.durganz.microservices.booksratingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookRatingNotFoundException extends RuntimeException {
	public BookRatingNotFoundException(String message) {
		super(message);
	}
}
