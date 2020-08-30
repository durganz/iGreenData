package com.durganz.microservices.bookscatalogservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.durganz.microservices.bookscatalogservice.bean.BookCatalog;
import com.durganz.microservices.bookscatalogservice.bean.BookInfo;
import com.durganz.microservices.bookscatalogservice.bean.BookRating;
import com.durganz.microservices.bookscatalogservice.exception.BookCatalogNotFoundException;


@RestController
public class BooksCatalogController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MessageSource messageSource; 
	
	@Autowired
	BookRatingServiceProxy bookRatingServiceProxy;
	
	@Autowired
	BookInfoServiceProxy bookInfoServiceProxy;
	
	List<BookCatalog> bookCatalog;
 

	@GetMapping("/catalog/{userId}")
	public List<BookCatalog> retrieveBooksCatalog(@PathVariable String userId) {
		
		BookRating[] bookRatings = bookRatingServiceProxy.retrieveBookRating(userId);
		bookCatalog = new ArrayList<BookCatalog>();
		for(BookRating bookRating : bookRatings) {

			int bookId = bookRating.getBookId();

			BookInfo bookInfo = bookInfoServiceProxy.retrieveBookInfo(bookId);
			if(Objects.nonNull(bookRating)) {
				bookCatalog.add(new BookCatalog(userId, bookId, bookInfo.getName(), bookRating.getRating()));
			}
			
		}
		logger.info("Book Catalog Response : {}", bookCatalog);
		if(Objects.nonNull(bookCatalog) && bookCatalog.size() > 0)
			return bookCatalog;
		else
			throw new BookCatalogNotFoundException(messageSource.getMessage("bookcatalog.not.found", null, 
					LocaleContextHolder.getLocale()));
	}
	
}
