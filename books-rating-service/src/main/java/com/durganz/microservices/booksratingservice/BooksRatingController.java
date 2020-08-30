package com.durganz.microservices.booksratingservice;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durganz.microservices.booksratingservice.bean.BookRating;
import com.durganz.microservices.booksratingservice.exception.BookRatingNotFoundException;

import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RestController
public class BooksRatingController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MessageSource messageSource; 

	@Autowired
	private BookRatingRepository bookRatingRepository;

	@GetMapping("/rating/{userId}")
	public List<BookRating> retrieveBooksRating(@PathVariable String userId) {
		
		List<BookRating> bookRatings = bookRatingRepository.findByUserId(userId);
		logger.info("Book Rating Response : {}", bookRatings);
		if(bookRatings != null)
			return bookRatings;
		else
			throw new BookRatingNotFoundException(messageSource.getMessage("bookrating.not.found", null, 
					LocaleContextHolder.getLocale()));
	}
	
	@PostMapping("/rating")
	public BookRating createRating(@Valid @RequestBody BookRating bookRating) {
		BookRating savedBookRating = bookRatingRepository.save(bookRating);
		return savedBookRating;

	}
	
}
