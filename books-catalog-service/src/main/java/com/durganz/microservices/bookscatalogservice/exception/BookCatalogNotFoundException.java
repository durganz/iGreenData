package com.durganz.microservices.bookscatalogservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookCatalogNotFoundException extends RuntimeException {
	public BookCatalogNotFoundException(String message) {
		super(message);
	}
}
