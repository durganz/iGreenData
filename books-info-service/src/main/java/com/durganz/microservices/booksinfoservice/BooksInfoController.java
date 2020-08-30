package com.durganz.microservices.booksinfoservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durganz.microservices.booksinfoservice.bean.BookInfo;
import com.durganz.microservices.booksinfoservice.exception.BookNotFoundException;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BooksInfoController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MessageSource messageSource; 

	@Autowired
	private BookInfoRepository bookInfoRepository;
	

	@GetMapping("/books/{bookId}")
	public BookInfo retrieveBooksInfo(@PathVariable int bookId) {
		
		BookInfo bookinfo = bookInfoRepository.findById(bookId);
		logger.info("Book Info Response : {}", bookinfo);
		if(bookinfo != null)
			return bookinfo;
		else
			throw new BookNotFoundException(messageSource.getMessage("book.not.found", null, 
					LocaleContextHolder.getLocale()));
	}
	
	@PostMapping("/books")
	public BookInfo createUser(@Valid @RequestBody BookInfo bookInfo) {

		BookInfo savedBookInfo = bookInfoRepository.save(bookInfo);
		return savedBookInfo;

	}
	
}
